package com.TAlab5;


public class Main {
    public static void main(String[] args) {
        int[] arrayQ1 = new int[100000];
        int[] arrayQ2 = new int[1000000];
        int[] arrayQ1R = new int[100000];
        int[] arrayQ2R = new int[1000000];
        for (int i = 0; i < arrayQ1.length; i++) {
            arrayQ1[i] = 1;
        }
        for (int i = 0; i < arrayQ2.length; i++) {
            arrayQ2[i] = 1;
        }
        for (int i = 0; i < arrayQ1R.length; i++) {
            arrayQ1R[i] = (int) (Math.random() * 100);
        }
        for (int i = 0; i < arrayQ2R.length; i++) {
            arrayQ2R[i] = (int) (Math.random() * 100);
        }
        SortingModule quickSort = new QuickSort();
        SortingModule mergeSort = new MergeSort();
        SortingModule shellSort = new ShellSort();
        SortingModule heapSort = new HeapSort();
        int[] arrayM1 = arrayQ1.clone();
        int[] arrayM2 = arrayQ2.clone();
        int[] arrayM1R = arrayQ1R.clone();
        int[] arrayM2R = arrayQ2R.clone();
        int[] arrayS1 = arrayQ1.clone();
        int[] arrayS2 = arrayQ2.clone();
        int[] arrayS1R = arrayQ1R.clone();
        int[] arrayS2R = arrayQ2R.clone();
        int[] arrayH1 = arrayQ1.clone();
        int[] arrayH2 = arrayQ2.clone();
        int[] arrayH1R = arrayQ1R.clone();
        int[] arrayH2R = arrayQ2R.clone();

        long startTime = System.nanoTime();
        quickSort.sort(arrayQ1R);
        long endTime = System.nanoTime();
        System.out.printf("%-24s", "");
        System.out.printf("%-30s", "Random elements");
        System.out.printf("%-30s", "Already sorted");
        System.out.println();
        System.out.printf("%-20s", "");
        System.out.printf("%-13s", "100 000");
        System.out.print("|");
        System.out.printf("%-15s", "1 000 000");
        System.out.printf("%-13s", "100 000");
        System.out.print("|");
        System.out.printf("%-15s", "1 000 000");
        System.out.println();
        System.out.printf("%-20s", "QuickSort: ");
        System.out.printf("%-13s", (double) (endTime - startTime) / 1000000 + "ms");
        System.out.print("|");


        startTime = System.nanoTime();
        quickSort.sort(arrayQ2R);
        endTime = System.nanoTime();
        System.out.printf("%-15s", (double) (endTime - startTime) / 1000000 + "ms");
        startTime = System.nanoTime();
        quickSort.sort(arrayQ1);
        endTime = System.nanoTime();
        System.out.printf("%-13s", (double) (endTime - startTime) / 1000000 + "ms");
        System.out.print("|");
        startTime = System.nanoTime();
        quickSort.sort(arrayQ2);
        endTime = System.nanoTime();
        System.out.printf("%-13s", (double) (endTime - startTime) / 1000000 + "ms");
        System.out.println();

        startTime = System.nanoTime();
        mergeSort.sort(arrayM1R);
        endTime = System.nanoTime();
        System.out.printf("%-20s", "MergeSort: ");
        System.out.printf("%-13s", (double) (endTime - startTime) / 1000000 + "ms");
        System.out.print("|");
        startTime = System.nanoTime();
        mergeSort.sort(arrayM2R);
        endTime = System.nanoTime();
        System.out.printf("%-15s", (double) (endTime - startTime) / 1000000 + "ms");
        startTime = System.nanoTime();
        mergeSort.sort(arrayM1);
        endTime = System.nanoTime();
        System.out.printf("%-13s", (double) (endTime - startTime) / 1000000 + "ms");
        System.out.print("|");
        startTime = System.nanoTime();
        mergeSort.sort(arrayM2);
        endTime = System.nanoTime();
        System.out.printf("%-13s", (double) (endTime - startTime) / 1000000 + "ms");
        System.out.println();

        startTime = System.nanoTime();
        shellSort.sort(arrayS1R);
        endTime = System.nanoTime();
        System.out.printf("%-20s", "ShellSort: ");
        System.out.printf("%-13s", (double) (endTime - startTime) / 1000000 + "ms");
        System.out.print("|");
        startTime = System.nanoTime();
        shellSort.sort(arrayS2R);
        endTime = System.nanoTime();
        System.out.printf("%-15s", (double) (endTime - startTime) / 1000000 + "ms");
        startTime = System.nanoTime();
        shellSort.sort(arrayS1);
        endTime = System.nanoTime();
        System.out.printf("%-13s", (double)(endTime - startTime) / 1000000 + "ms");
        System.out.print("|");
        startTime = System.nanoTime();
        shellSort.sort(arrayS2);
        endTime = System.nanoTime();
        System.out.printf("%-13s", (double) (endTime - startTime) / 1000000 + "ms");
        System.out.println();

        startTime = System.nanoTime();
        heapSort.sort(arrayH1R);
        endTime = System.nanoTime();
        System.out.printf("%-20s", "HeapSort: ");
        System.out.printf("%-13s", (double) (endTime - startTime) / 1000000 + "ms");
        System.out.print("|");
        startTime = System.nanoTime();
        heapSort.sort(arrayH2R);
        endTime = System.nanoTime();
        System.out.printf("%-15s", (double) (endTime - startTime) / 1000000 + "ms");
        startTime = System.nanoTime();
        heapSort.sort(arrayH1);
        endTime = System.nanoTime();
        System.out.printf("%-13s", (double)(endTime - startTime) / 1000000 + "ms");
        System.out.print("|");
        startTime = System.nanoTime();
        heapSort.sort(arrayH2);
        endTime = System.nanoTime();
        System.out.printf("%-13s", (double) (endTime - startTime) / 1000000 + "ms");
        System.out.println();
    }
}
