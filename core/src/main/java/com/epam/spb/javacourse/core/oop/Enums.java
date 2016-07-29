package com.epam.spb.javacourse.core.oop;

import java.util.AbstractList;

public class Enums {


    public static void main(String[] args) {
        AbstractList abstractList = new AbstractList() {
            @Override
            public Object get(int index) {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }

            public void sayHello2Leonid() {
                System.out.println("hello Lyonya");
            }
        };

        abstractList.say

    }
}


