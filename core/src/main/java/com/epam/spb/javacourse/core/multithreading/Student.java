package com.epam.spb.javacourse.core.multithreading;

public class Student implements Runnable {
    private Message msg;

    public Student(Message m){
        this.msg = m;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        synchronized (msg) {
            try{
                System.out.println(name + " ждем вызов метода notify: " + System.currentTimeMillis());
                msg.wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(name + " был вызов метода notify: " + System.currentTimeMillis());
            System.out.println(name + " : " + msg.getMsg());
        }
    }
}
