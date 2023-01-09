package com.company;

class Calculation {
    void calculation(Calculator foo, double a, double b, double c, double d) {
        System.out.println("a = " + a + " b = " + b + " c = " + c
                + " d = " + d);
        System.out.println(foo.calculation(a, b, c, d));
    }
}
