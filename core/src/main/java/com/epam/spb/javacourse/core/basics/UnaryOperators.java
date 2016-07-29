package com.epam.spb.javacourse.core.basics;

public class UnaryOperators {

    public static void main(String[] args) {
        System.out.println("UnaryOperators");

        int i=3;
        i = -i++ + i++ + -i;

        System.out.println(i);

    }
}
