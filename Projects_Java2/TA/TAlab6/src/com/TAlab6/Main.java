package com.TAlab6;

public class Main {
    public static void main(String[] args) {
        long startTime, endTime;
        double a,b,c,d,e,f;
        System.out.printf(" %-15s | %-30s | %-30s | %-25s | %-25s | %n", "", "Insertion", "Balancing", "Search", "Deletion");
        System.out.printf(" %-15s |%-15s |%-15s|%-15s |%-15s| %-25s | %-25s | %n", "", "r/e", "c/e", "r/e", "c/e", "", "");
        BalancedTree balancedTree1 = new BalancedTree();
        BalancedTree balancedTree2 = new BalancedTree();
        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            balancedTree1.insert((int) (Math.random()*1000));
        }
        endTime = System.nanoTime();
        a=(double) (endTime - startTime)/ 1000000;

        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            balancedTree2.insert(i);
        }
        endTime = System.nanoTime();
        b=(double) (endTime - startTime)/ 1000000;

        c=0.0001;
        d=0.0001;

        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            balancedTree1.find(i);
        }
        endTime = System.nanoTime();
        e=(double) (endTime - startTime)/ 1000000;

        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            balancedTree1.delete(i);
        }
        endTime = System.nanoTime();
        f=(double) (endTime - startTime)/ 1000000;
        System.out.printf(" %-15s |%-15s |%-15s|%-15s |%-15s| %-25s | %-25s | %n", "Balanced", a, b, c, d, e, f);

        NotBalancedTree notBalancedTree1 = new NotBalancedTree();
        NotBalancedTree notBalancedTree2 = new NotBalancedTree();
        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            notBalancedTree1.insert((int) (Math.random()*1000));
        }
        endTime = System.nanoTime();
        a=(double) (endTime - startTime)/ 1000000;

        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            notBalancedTree2.insert(i);
        }
        endTime = System.nanoTime();
        b=(double) (endTime - startTime)/ 1000000;

        c=0;
        d=0;

        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            notBalancedTree1.search(i);
        }
        endTime = System.nanoTime();
        e=(double) (endTime - startTime)/ 1000000;

        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            notBalancedTree1.deleteKey(i);
        }
        endTime = System.nanoTime();
        f=(double) (endTime - startTime)/ 1000000;
        System.out.printf(" %-15s |%-15s |%-15s|%-15s |%-15s| %-25s | %-25s | %n", "NotBalanced", a, b, c, d, e, f);
    }
}
