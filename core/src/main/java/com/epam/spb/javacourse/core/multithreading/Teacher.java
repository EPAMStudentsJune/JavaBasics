package com.epam.spb.javacourse.core.multithreading;

public class Teacher implements Runnable {
    private Message msg;

    public Teacher(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " стартовал");
        try {
            Thread.sleep(4000);
            synchronized (msg) {
                msg.setMsg(name + " поток Teacher отработал");
                msg.notifyAll();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
