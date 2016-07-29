package com.epam.spb.javacourse.core.basics;

public class LogicOperations {

    public static void main(String[] args) {
        if(bFalse()&&bTrue());
        System.out.println();

        if(bFalse()&bTrue());
        System.out.println();
    }

    private static boolean bTrue() {
        System.out.print("true ");
        return true;
    }

    private static boolean bFalse() {
        System.out.print("false ");
        return false;
    }

}
