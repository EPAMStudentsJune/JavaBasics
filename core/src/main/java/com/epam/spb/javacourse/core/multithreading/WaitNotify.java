package com.epam.spb.javacourse.core.multithreading;

public class WaitNotify {
    public static void main(String[] args) {
        Message msg = new Message("Привет с Воронежской");

        Student student = new Student(msg);
        new Thread(student, "ученик 1").start();

        Student student1 = new Student(msg);
        new Thread(student1, "ученик 2").start();

        Teacher teacher = new Teacher(msg);

        new Thread(teacher, "тормоз").start();
        System.out.println("Стартовали все потоки");
    }
}
