package com.company;

public class Main {
    public static void main(String[] args) {
        Tasker calc;
        calc = new Tasker(new Task1());
        double a = 3.56;
        double b = 1.02;
        double c = 3;
        double d = 2.43;
        System.out.println(calc.execute(a, b, c, d));
        calc = new Tasker(new Task2());
        a = 1.234;
        b = -3.12;
        c = 5.45;
        d = 2;
        System.out.println(calc.execute(a, b, c, d));
        calc = new Tasker(new Task3());
        a = 2.54;
        b = -1.34;
        c = 1.05;
        d = 0.78;
        System.out.println(calc.execute(a, b, c, d));
    }
}

interface MathTask {
    double calc(double a, double b, double c, double d);
}

class Task1 implements MathTask {
    @Override
    public double calc(double a, double b, double c, double d) {
        return (Math.cbrt(Math.tan(a)) / (1 + (Math.sinh(b) / Math.log(d + c))));
    }
}

class Task2 implements MathTask {
    @Override
    public double calc(double a, double b, double c, double d) {
        return (Math.pow(Math.tan(a), 1 / c) / (1 + (Math.sinh(b) / Math.log(d + c))));
    }
}

class Task3 implements MathTask {
    @Override
    public double calc(double a, double b, double c, double d) {
        return (Math.log(Math.abs((c / a) * (Math.sqrt((Math.tanh(Math.abs(b)) * c) /
                ((Math.log(d)) / (Math.log(Math.sqrt(c))))))))) / (Math.log(a));
    }
}

class Tasker {
    private MathTask mathTask;

    Tasker(MathTask mathTask) {
        this.mathTask = mathTask;
    }

    public double execute(double a, double b, double c, double d) {
        return mathTask.calc(a, b, c, d);
    }
}