package com.epam.spb.javacourse.core.basics;

import static java.lang.Math.pow;
import static java.lang.Math.PI;


public class StaticImport {

    public static void main(String[] args) {
        System.out.println("StaticImport");
    }

    private int i = 20;

    public void staticImport() {
        double x;
        x = pow(i, 2)*PI;
        System.out.println("x=" + x);
    }

}
