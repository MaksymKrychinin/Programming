package com.company;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        double[] array = {1, 10, 30, 22, 11, 0, 13, 42, 41, 5, 1, 5, 12, 3, 5, 12, 41, 4, 124, 124};
        double[] array1 = {7, 13, 7, 2, 3, 1, 3, 12, 31, 3111};
        System.out.println("===========================");
        try {
            SortBigToSmall.bubble(array);
            SortBigToSmall.selection(array1);
            System.out.println(Arrays.toString(array));
            System.out.println(Arrays.toString(array1));
        } catch (NullPointerException | IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}

class SortBigToSmall {
    public static void bubble(double[] array) {
        if (array == null) {
            throw new NullPointerException("Null Array");
        } else if (array.length == 0) {
            throw new IllegalArgumentException("Элемента нету в списке");
        }
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] < array[i + 1]) {
                    array[i] = array[i] + array[i + 1] - (array[i + 1] = array[i]);
                    flag = true;
                }
            }
        }
    }

    public static void selection(double[] array) {
        if (array == null) {
            throw new NullPointerException("Null Array");
        } else if (array.length == 0) {
            throw new IllegalArgumentException("Элемента нету в списке");
        }
        double tmp;
        for (int k = 0; k < array.length; k++) {
            double max = array[k];
            for (int i = k; i < array.length; i++) {
                if (array[i] > max) {
                    max = array[i];
                }
            }
            for (int i = k; i < array.length; i++) {
                if (array[i] == max) {
                    tmp = array[k];
                    array[k] = max;
                    array[i] = tmp;
                }
            }
        }
    }
}


class Display {
    public static void resultsArray(double[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0, k = 1; i < array.length; i++, k++) {
            sb.append("[").append(array[i]).append("]");
            if (i < array.length - 1) {
                sb.append(", ");
                if (k == 10) {
                    k = 0;
                    sb.append("\n");
                }
            }
        }
        System.out.println(sb);
        System.out.println("===========================");
    }
}