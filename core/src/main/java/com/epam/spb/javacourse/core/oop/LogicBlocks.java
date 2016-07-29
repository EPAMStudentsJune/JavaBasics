package com.epam.spb.javacourse.core.oop;

public class LogicBlocks {

    public static final int bzz = 10;

    public static void mm() {}

    public static void main(String[] args) {
        new LogicBlocks(2);
    }


    public LogicBlocks(int d) {
        id = d;
        System.out.println("конструктор id=" + id);
        wait();
        Thread
    }

    private int id = 7;

    {
        System.out.println("logic (?) id=" + this.id);
    }

    {
        id = 10;
        System.out.println("logic (?) id=" + id);
    }

    private void calc(long timestamp) {
        System.out.println(" timestamp is " + timestamp);
    }


    {
        System.out.println("logic (?) id=" + id);
        long timestamp = System.currentTimeMillis();
        calc(timestamp);
    }

    static {
        System.out.println("42?");
    }

}

