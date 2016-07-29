package com.epam.spb.javacourse.core.multithreading;

// CountDownLatch (замок с обратным отсчетом) предоставляет возможность любому
// количеству потоков в блоке кода ожидать до тех пор,
// пока не завершится определенное количество операций,
// выполняющихся в других потоках, перед тем как они будут «отпущены»,
// чтобы продолжить свою деятельность.
// В конструктор CountDownLatch (CountDownLatch(int count)) обязательно передается количество операций,
// которое должно быть выполнено, чтобы замок «отпустил» заблокированные потоки.

// https://hsto.org/files/46b/3ae/b41/46b3aeb417cf4fb4ba271b4c66b52436.gif
import java.util.concurrent.CountDownLatch;

//
public class Race {
    private static final CountDownLatch START = new CountDownLatch(8);
    private static final CountDownLatch FINISH = new CountDownLatch(5);
    //Условная длина гоночной трассы
    private static final int trackLength = 500000;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= 5; i++) {
            new Thread(new Car(i, (int) (Math.random() * 100 + 50))).start();
            Thread.sleep(1000);
        }

        new Thread(new FinishWaiter()).start();

        while (START.getCount() > 3) //Проверяем, собрались ли все автомобили
            Thread.sleep(100);              //у стартовой прямой. Если нет, ждем 100ms

        Thread.sleep(1000);
        System.out.println("На старт!");
        START.countDown();//Команда дана, уменьшаем счетчик на 1
        Thread.sleep(1000);
        System.out.println("Внимание!");
        START.countDown();//Команда дана, уменьшаем счетчик на 1
        Thread.sleep(1000);
        System.out.println("Марш!");
        START.countDown();//Команда дана, уменьшаем счетчик на 1
        //счетчик становится равным нулю, и все ожидающие потоки
        //одновременно разблокируются
    }

    public static class Car implements Runnable {
        private int carNumber;
        private int carSpeed;//считаем, что скорость автомобиля постоянная

        public Car(int carNumber, int carSpeed) {
            this.carNumber = carNumber;
            this.carSpeed = carSpeed;
        }

        @Override
        public void run() {
            try {
                System.out.printf("Автомобиль №%d подъехал к стартовой прямой.\n", carNumber);
                //Автомобиль подъехал к стартовой прямой - условие выполнено
                //уменьшаем счетчик на 1
                START.countDown();
                //метод await() блокирует поток, вызвавший его, до тех пор, пока
                //счетчик CountDownLatch не станет равен 0
                START.await();
                System.out.printf("Автомобиль №%d погнал!\n", carNumber);
                Thread.sleep(trackLength / carSpeed);//ждем пока проедет трассу
                System.out.printf("Автомобиль №%d финишировал!\n", carNumber);
                FINISH.countDown();
            } catch (InterruptedException e) { }
        }
    }

    static class FinishWaiter implements Runnable {
        @Override
        public void run() {
            try {
                FINISH.await();
                System.out.println("ВСЕ ФИНИШИРОВАЛИ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}