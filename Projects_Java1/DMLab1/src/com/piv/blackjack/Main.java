package com.piv.blackjack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        int[] U = {1, 1, 1, 1, 1, 1, 1, 1};
        int[] c = {0, 0, 0, 0, 0, 0, 0, 0};
        int[] d = {0, 0, 0, 0, 0, 0, 0, 0};
        int[] newC = new int[8];
        int[] newA = new int[8];
        Constructor operation;
        Scanner inputArray = new Scanner(System.in);
        System.out.println("Введіть довжину множини А");
        int sizeFirst = inputArray.nextInt();//задання розміру масива а
        System.out.println("Вводьте елементи A");
        int a[] = new int[sizeFirst];//створення самого масиву
        for (int i = 0; i < sizeFirst; i++) {
            a[i] = inputArray.nextInt();
        }
        System.out.println("Введіть довжину множини В");
        int sizeSecond = inputArray.nextInt();//задання розміру масива b
        int b[] = new int[sizeSecond];//створення самого масиву
        System.out.println("Вводьте елементи B");
        for (int i = 0; i < sizeSecond; i++) {
            b[i] = inputArray.nextInt();
        }
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        //tmp переменні для вивода
        String isEquals;
        String isAParentB;
        String isBParentA;
        //Чи є множини рівні
        if (Equals.aToB(a, b) == true) {
            isEquals = "Так";
        } else {
            isEquals = "Ні";
        }
        System.out.println("Множини рівні?" + '\n' + isEquals);
        //Чи множина B належить множині A
        if (Parent.aToB(a, b) == true) {
            isAParentB = "Так";
        } else {
            isAParentB = "Ні";
        }
        System.out.println("B належить множині А?" + '\n' + isAParentB);
        //Чи множина А належить множині В
        if (Parent.bToA(a, b) == true) {
            isBParentA = "Так";
        } else {
            isBParentA = "Ні";
        }
        System.out.println("А належить множині В?" + '\n' + isBParentA);
        ReMake.toBit(a, c);//перетворення масиву а в бітовий рядок
        System.out.println(Arrays.toString(c));

        ReMake.toBit(b, d);//перетворення масиву b в бітовий рядок
        System.out.println(Arrays.toString(d));

        System.out.println("об'єднання");
        operation = new Constructor(new Or());//виклик логічної операції через конструктор
        operation.allArrays(c, d, newC);
        ReMake.toD(newC, newA);

        System.out.println("переріз");
        operation = new Constructor(new And());//виклик логічної операції через конструктор
        operation.allArrays(c, d, newC);
        ReMake.toD(newC, newA);

        System.out.println("симетрична різниця");
        operation = new Constructor(new Xor());//виклик логічної операції через конструктор
        operation.allArrays(c, d, newC);
        ReMake.toD(newC, newA);

        System.out.println("різниця");
        operation = new Constructor(new Riz());//виклик логічної операції через конструктор
        operation.allArrays(c, d, newC);
        ReMake.toD(newC, newA);

        System.out.println("доповнення");
        operation = new Constructor(new Dop());//виклик логічної операції через конструктор
        operation.allArrays(c, U, newC);
        ReMake.toD(newC, newA);

        System.out.println("декартовий добуток");
        operation = new Constructor(new Dob());//виклик логічної операції через конструктор
        operation.allArrays(a, b, newC);
        System.out.println();

        System.out.println("протилежні значення");
        operation = new Constructor(new Not());//виклик логічної операції через конструктор
        operation.allArrays(c, d, newC);
        ReMake.toD(newC, newA);

    }
}

class ReMake {//метод перетворення множин в бітові рядки і назад
    public static void toBit(int[] a, int[] c) {//переведення в бітові рядки
        for (int i = 0; i < a.length; i++) {
            c[a[i] - 1] = 1;
        }
    }
    public static void toD(int[] a, int[] c){//перетворення в звичайну множину значень
        List<Integer> Arr1 = new ArrayList<>();
        for (int i =0; i<a.length;i++){
            if (a[i]==1){
                Arr1.add(i+1);
            }
        }
        System.out.println(Arr1);
    }
}

class Constructor {//конструктор для взаємозвязку інтерфейсу
    LogicOperation logicOperation;
    private int a[];
    private int b[];

    public Constructor(LogicOperation logicOperation) {

        this.logicOperation = logicOperation;
    }

    public void allArrays(int[] a, int[] b, int [] c) {
        logicOperation.toDo(a, b, c);
    }

}

interface LogicOperation {
    void toDo(int[] a, int[] b, int [] c);
}

class Equals {
    static boolean aToB(int[] Arr, int[] Brr) {
        int ElementNow = Arr[0] + 1;
        List<Integer> Arr1 = new ArrayList<>();
        List<Integer> Brr1 = new ArrayList<>();
        List<Integer> Arr2 = new ArrayList<>();
        List<Integer> Brr2 = new ArrayList<>();
        for (int i : Arr) {
            Arr1.add(i);
        }
        for (int i : Brr) {
            Brr1.add(i);
        }
        Collections.sort(Arr1);
        Collections.sort(Brr1);
        for (int i = 0; i < Arr.length; i++) {
            if (ElementNow != Arr1.get(i)) {
                ElementNow = Arr1.get(i);
                Arr2.add(ElementNow);
            }
        }
        for (int i = 0; i < Brr.length; i++) {
            if (ElementNow != Brr1.get(i)) {
                ElementNow = Brr1.get(i);
                Brr2.add(ElementNow);
            }
        }
        int isEqualTmp = Arr1.size();
        boolean isEqual = false;
        if (Arr2.size() == Brr2.size()) {
            for (int i = 0; i < Arr2.size(); i++) {//a=b
                if (Arr2.get(i) == Brr2.get(i)) {
                    isEqualTmp--;
                }
            }
            if (isEqualTmp == 0) {
                isEqual = true;
            }
        } else {
            isEqual = false;
        }
        return isEqual;
    }
}

class Parent {
    static boolean aToB(int[] Arr, int[] Brr) {
        boolean isParent = false;
        List<Integer> Arr1 = new ArrayList<>();
        List<Integer> Brr1 = new ArrayList<>();
        for (int i : Arr) {
            Arr1.add(i);
        }
        for (int i : Brr) {
            Brr1.add(i);
        }
        Collections.sort(Arr1);
        Collections.sort(Brr1);
        int AParentB = 0;
        int BParentA = 0;
        for (int i : Arr1) {//скільки елементів b є в а
            for (int j = 0; j < Brr1.size(); j++) {
                if (i == Brr1.get(j)) {
                    AParentB++;
                }
            }
        }
        if (AParentB == Brr1.size()) {
            isParent = true;
        }
        return isParent;
    }

    static boolean bToA(int[] Arr, int[] Brr) {
        boolean isParent = false;
        List<Integer> Arr1 = new ArrayList<>();
        List<Integer> Brr1 = new ArrayList<>();
        for (int i : Arr) {
            Arr1.add(i);
        }
        for (int i : Brr) {
            Brr1.add(i);
        }
        Collections.sort(Arr1);
        Collections.sort(Brr1);
        int BParentA = 0;
        for (int i : Brr1) {//скільки елементів b є в а
            for (int j = 0; j < Arr1.size(); j++) {
                if (i == Arr1.get(j)) {
                    BParentA++;
                }
            }
        }
        if (BParentA == Arr1.size()) {
            isParent = true;
        }
        return isParent;
    }
}

class Or implements LogicOperation { //об'єднання
    @Override
    public void toDo(int[] a, int[] b, int [] c) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1 && b[i] == 1) {
                c[i] = 1;
            } else if (a[i] == 1 && b[i] == 0) {
                c[i] = 1;
            } else if (a[i] == 0 && b[i] == 1) {
                c[i] = 1;
            } else {
                c[i] = 0;
            }
        }
    }
}

class And implements LogicOperation {//переріз

    @Override
    public void toDo(int[] a, int[] b, int [] c) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1 && b[i] == 1) {
                c[i] = 1;
            } else {
                c[i] = 0;
            }
        }
    }
}

class Xor implements LogicOperation {  //симетрична різниця
    @Override
    public void toDo(int[] a, int[] b, int [] c) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1 && b[i] == 1) {
                c[i] = 0;
            } else if (a[i] == 0 && b[i] == 0) {
                c[i] = 0;
            } else {
                c[i] = 1;
            }
        }
    }
}

class Riz implements LogicOperation { //різниця
    @Override
    public void toDo(int[] a, int[] b, int [] c) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1 && b[i] == 0) {
                c[i] = 1;
            } else {
                c[i] = 0;
            }
        }
    }
}

class Dop implements LogicOperation { //доповнення
    @Override
    public void toDo(int[] a, int[] U, int [] c) {
        for (int i = 0; i < a.length; i++) {
            if (U[i] == 1 && a[i] == 0) {
                c[i] = 1;
            } else {
                c[i] = 0;
            }
        }
    }
}

class Dob implements LogicOperation {//декартовий добуток

    @Override
    public void toDo(int[] a, int[] b, int [] c) {

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                System.out.print("{" + a[i] + ", " + b[j] + "}, ");
            }
        }
    }
}

class Not implements LogicOperation {//протилежні значення
    @Override
    public void toDo(int[] a, int[] b, int [] c) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                c[i] = 1;
            } else {
                c[i] = 0;
            }
        }
    }
}
//nope
class Translator {
    static int toInt(int[] a) {//переведення в число
        int currentInt = 0;
        for (int i = 0; i < a.length; i++) {
            currentInt += a[i] * (int) (Math.pow(2, a.length - i - 1));
        }
        return currentInt;
    }

    static int[] toByte(int a) {//переведення в двійковий код
        int currentArray[] = new int[8];
        int tmp[] = new int[8];
        for (int i = 0; i < currentArray.length; i++) {
            if (a < 0)
                break;
            if (a % 2 == 1) {
                a--;
                a /= 2;
                tmp[i] = 1;
            } else {
                a /= 2;
                tmp[i] = 0;
            }
        }
        for (int i = 0; i < 8; i++) {
            currentArray[8 - i - 1] = tmp[i];
        }

        return currentArray;
    }
}