package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double[] array = {1, 10, 30, 22, 11, 0, 13, 42, 41, 5, 1, 5, 12, 3, 5, 12, 41, 4, 124, 124};
        ExceptionThrower eThrow = new ExceptionThrow();
        try {
            eThrow.checker(array);
        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println(e.getMessage());
            System.exit(404);
        }//static
        SortStrategy sort = new SortBigToSmall();
        Scanner method = new Scanner(System.in);
        int scan = method.nextInt();
        if (scan == 1) {//
            sort.bubble(array);
        } else if (scan == 2) {
            sort.selection(array);
        } else if (scan == 3) {
            sort.insertion(array);
        } else {
            System.out.println("Введи 1 или 2!");
        }
        System.out.println(Arrays.toString(array));
    }
}

interface SortStrategy {
    void bubble(double[] array);
//3 class
    void selection(double[] array);

    void insertion(double[] array);
}
//dip(Dippendency injection) proffweb
interface ExceptionThrower {
    void checker(double[] array);
}

class SortBigToSmall implements SortStrategy{
    public void bubble(double[] array) {

    }
    //quick sort
//@Override
    public void selection(double[] array) {

    }

    public void insertion(double[] array) {
        for (int j = 0; j < array.length; j++) {
            double tmp = array[j];
            int i;
            for (i = j - 1; (i >= 0) && (array[i] < tmp); i--) {
                array[i + 1] = array[i];
            }
            array[i + 1] = tmp;
        }
    }
}

class ExceptionThrow implements ExceptionThrower {
    public void checker(double[] array) {
        if (array == null) {
            throw new NullPointerException("Null Array");
        } else if (array.length == 0 | array.length<2) {
            throw new IllegalArgumentException("Неправильный массив или 1 элемент в массиве");
        }
    }
}

