package com.TAlab3;

public class Main {
    public static void main(String[] args) {
        long startTime, endTime, startTime1, endTime1;
        System.out.printf("|%-15s | %-15s | %-15s | %n", "", "SingleLinked", "DoubleLinked");
        ListConn<Integer> SingleLinked = new SingleLinked<>();
        ListConn<Integer> DoubleLinked = new DoubleLinked<>();
        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            SingleLinked.addOnStart(i);
        }
        endTime = System.nanoTime();
        startTime1 = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            DoubleLinked.addOnStart(i);
        }
        endTime1 = System.nanoTime();
        System.out.printf("|%-15s | %-15s | %-15s | %n", "addOnStart", (double) (endTime - startTime)/ 1000000 +"ms",
                (double) (endTime1 - startTime1)/ 1000000 +"ms");
        ListConn<Integer> list1 = new SingleLinked<>();
        ListConn<Integer> list1D = new SingleLinked<>();
        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            list1.addOnEnd(i);
        }
        endTime = System.nanoTime();
        startTime1 = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            list1D.addOnEnd(i);
        }
        endTime1 = System.nanoTime();
        System.out.printf("|%-15s | %-15s | %-15s | %n", "addOnEnd", (double) (endTime - startTime)/ 1000000 +"ms",
                (double) (endTime1 - startTime1)/ 1000000 +"ms");
        ListConn<Integer> list2 = new SingleLinked<>();
        ListConn<Integer> list2D = new DoubleLinked<>();
        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            list2.addOnIndex(i, i);
        }
        endTime = System.nanoTime();
        startTime1 = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            list2D.addOnIndex(i, i);
        }
        endTime1 = System.nanoTime();
        System.out.printf("|%-15s | %-15s | %-15s | %n", "addOnIndex", (double) (endTime - startTime)/ 1000000 +"ms",
                (double) (endTime1 - startTime1)/ 1000000 +"ms");
        SingleLinked.addOnIndex(1023, 600);
        startTime = System.nanoTime();
        SingleLinked.indexOfElement(1023);
        endTime = System.nanoTime();
        DoubleLinked.addOnIndex(1023, 600);
        startTime1 = System.nanoTime();
        DoubleLinked.indexOfElement(1023);
        endTime1 = System.nanoTime();
        System.out.printf("|%-15s | %-15s | %-15s | %n", "indexOfElement", (double) (endTime - startTime)/ 1000000 +"ms",
                (double) (endTime1 - startTime1)/ 1000000 +"ms");
        startTime = System.nanoTime();
        for (int i = 0; i < 999; i++) {
            SingleLinked.deleteOnStart();
        }
        endTime = System.nanoTime();
        startTime1 = System.nanoTime();
        for (int i = 0; i < 999; i++) {
            DoubleLinked.deleteOnStart();
        }
        endTime1 = System.nanoTime();
        System.out.printf("|%-15s | %-15s | %-15s | %n", "delOnStart", (double) (endTime - startTime)/ 1000000 +"ms",
                (double) (endTime1 - startTime1)/ 1000000 +"ms");
        startTime = System.nanoTime();
        for (int i = 1; i < 999; i++) {
            list1.deleteOnIndex(999 - i);
        }
        endTime = System.nanoTime();
        startTime1 = System.nanoTime();
        for (int i = 1; i < 999; i++) {
            list1D.deleteOnIndex(999 - i);
        }
        endTime1 = System.nanoTime();
        System.out.printf("|%-15s | %-15s | %-15s | %n", "delOnIndex", (double) (endTime - startTime)/ 1000000 +"ms",
                (double) (endTime1 - startTime1)/ 1000000 +"ms");
        startTime = System.nanoTime();
        for (int i = 0; i < 999; i++) {
            list2.deleteOnEnd();
        }
        endTime = System.nanoTime();
        startTime1 = System.nanoTime();
        for (int i = 0; i < 999; i++) {
            list2D.deleteOnEnd();
        }
        endTime1 = System.nanoTime();
        System.out.printf("|%-15s | %-15s | %-15s | %n", "delOnEnd", (double) (endTime - startTime)/ 1000000 +"ms",
                (double) (endTime1 - startTime1)/ 1000000 +"ms");
        System.out.println("=========================Stack========================");

        Stack stack = new Stack();
        stack.add(10);
        stack.add(15);
        stack.add(12);
        stack.add(3);
        stack.display();
        System.out.printf("\nTop element is %d\n", stack.get());
        stack.delete();
        stack.delete();
        stack.display();
        System.out.printf("\nTop element is %d\n", stack.get());

        System.out.println("========================Queue=========================");
        Queue q = new Queue();
        q.add(12);
        q.add(7);
        q.delete();
        q.delete();
        q.add(15);
        q.add(16);
        q.add(20);
        System.out.println("Queue Front : " + q.get());
        q.display();

    }
}
