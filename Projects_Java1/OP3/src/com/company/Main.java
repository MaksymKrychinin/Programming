package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Input s:");
        int s = myObj.nextInt();
        System.out.println("Input i:");
        int i = myObj.nextInt();
        System.out.println("Input t:");
        int t = myObj.nextInt();
        System.out.println("Input e:");
        double e = myObj.nextDouble();
        try {
            System.out.println(
                    "============1==============" + '\n' + task1.task1start(s) + '\n' +
                    "============2==============" + '\n' + task2.task2start(i, t) + '\n' + task2.task2start(i, t)+
                    "============3==============" + '\n' + task3.task3start(e));
        } catch (IllegalArgumentException a) {
            System.out.println(a.getMessage());
        }
    }
}

class task1 {
    static double task1start(int s) {
        double sum = 0;
        for (int i = 1; i < 35; i++) {
            sum += Math.log10(Math.sqrt((double) s / (i * i)));
        }
        return sum;
    }
}

class task2 {
    static double task2start(int i, int t) {
        double sum = 0;
        double a;
        if (i == 2 & t == 0) {
            throw new IllegalArgumentException("Деление на 0 это плохо!");
        }
        if (i == 1) {
            a = (Math.sqrt(t));
        } else if (i == 2) {
            a = (1 / Math.sqrt(t));
        } else {
            for (int k = 1; k < i; k++) {
                sum += k * t;
            }
            a = sum;
        }
        return a;
    }
}

class task3 {
    static double task3start(double e) {
        double sum = 0;
        double d;
        for (int i = 1; (1.0 / (i * (i + 1))) > e; i++) {
            d = 1.0 / (i * (i + 1));
            sum += d;
        }
        return sum;
    }
}