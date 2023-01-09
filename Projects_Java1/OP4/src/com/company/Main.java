package com.company;

public class Main {
    public static void main(String[] args) {
    int[]arrayStandart1 = {-31, 32, 17, 0, -71};
    int[]arrayStandart2 = {};
    int[]arrayStandart3 = null;
        System.out.println("===========First==============");
        try {
            System.out.println(task10.task10start(arrayStandart1));
            System.out.println(task10.task10start(arrayStandart2));
            System.out.println(task10.task10start(arrayStandart3));
        } catch (IllegalArgumentException | NullPointerException e){
            System.out.println(e.getMessage());
        }
        System.out.println("===========Second==============");
        try {
            System.out.println(maximum.max(arrayStandart1)-arrayStandart1[1]);
            System.out.println(maximum.max(arrayStandart2)-arrayStandart2[1]);
            System.out.println(maximum.max(arrayStandart3)-arrayStandart3[1]);
        } catch (IllegalArgumentException | NullPointerException e){
            System.out.println(e.getMessage());
        }
        System.out.println("===========Third==============");
        try {
            System.out.println(DisplayUtils
                    .getArrayFormattedString(task63.task63start(arrayStandart1)));
            System.out.println(DisplayUtils
                    .getArrayFormattedString(task63.task63start(arrayStandart2)));
            System.out.println(DisplayUtils
                    .getArrayFormattedString(task63.task63start(arrayStandart3)));
        } catch (IllegalArgumentException | NullPointerException e){
            System.out.println(e.getMessage());
        }
    }
}
class task10{
    static double task10start(int[] arrayToMax){
        double sumAll = 0;
        if (arrayToMax == null){
            throw new NullPointerException("Null Array");
        } else if (arrayToMax.length == 0){
            throw new IllegalArgumentException("Элемента нету в списке");
        }
        for(int i=0; i<arrayToMax.length;i++) {
            sumAll += arrayToMax[i];
        }
        return (sumAll / arrayToMax.length);
    }
}
class maximum {
    public static int max(int[] arrayMax) {
        if (arrayMax == null){
            throw new NullPointerException("Null Array");
        } else if (arrayMax.length == 0){
            throw new IllegalArgumentException("Элемента нету в списке");
        }
        int max = arrayMax[0];
        for (int i:arrayMax) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
}
class task63 {
    public static int[] task63start(int[] arrayMax) {
        int arrayReplaced[] = new int[arrayMax.length];
        for (int i = 0; i< arrayMax.length; i++){
            arrayReplaced[i]=arrayMax[i];
        }
        if (arrayMax == null){
            throw new NullPointerException("Null Array");
        } else if (arrayMax.length == 0){
            throw new IllegalArgumentException("Элемента нету в списке");
        }
        int max =maximum.max(arrayMax);
        for (int i = 0; i<arrayMax.length; i++) {
            if (arrayMax[i] < 0) {
                arrayReplaced[i]=arrayMax[i]+max;
            } else if (i==0){
                arrayReplaced[i]=1;
            } else if (i>0){
                arrayReplaced[i]=arrayMax[i]*2;
            }
        }return arrayReplaced;}}

class DisplayUtils{
    public static String getArrayFormattedString(int[] arrayStandart1) {
        StringBuilder allArray = new StringBuilder();
        for (int i = 0; i<task63.task63start(arrayStandart1).length; i++){
            allArray.append("[" + task63.task63start(arrayStandart1)[i] + "]");
            if (i<(task63.task63start(arrayStandart1).length-1)){
                allArray.append(", ");
            }
        }
        return allArray.toString();
    }
}