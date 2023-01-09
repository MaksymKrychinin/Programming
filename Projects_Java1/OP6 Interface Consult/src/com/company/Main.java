package com.company;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        double[] arrayNotSorted;
        Sort array;
        try {
            arrayNotSorted = new double[]{10, 12, 32, 34, 45, 655, 23, 64, 342, 76};
            array = new Sort(new SelectionSort());
            array.execute(arrayNotSorted);
            System.out.println(Arrays.toString(arrayNotSorted));
            arrayNotSorted = new double[]{10, 12, 32, 34, 45, 655, 23, 64, 342, 76};
            array = new Sort(new BubbleSort());
            array.execute(arrayNotSorted);
            System.out.println(Arrays.toString(arrayNotSorted));
            arrayNotSorted = new double[]{10, 12, 32, 34, 45, 655, 23, 64, 342, 76};
            array = new Sort(new QuickSort());
            array.execute(arrayNotSorted);
            System.out.println(Arrays.toString(arrayNotSorted));
            arrayNotSorted = new double[]{10, 12, 32, 34, 45, 655, 23, 64, 342, 76};
            array = new Sort(new InsertionSort());
            array.execute(arrayNotSorted);
            System.out.println(Arrays.toString(arrayNotSorted));
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

interface SortStrategy {
    void sortArray(double[] array);
}

class BubbleSort implements SortStrategy {
    @Override
    public void sortArray(double[] array) {
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
}

class SelectionSort implements SortStrategy {
    @Override
    public void sortArray(double[] array) {
        for (int k = 0; k < array.length; k++) {
            double max = array[k];
            for (int i = k; i < array.length; i++) {
                if (array[i] > max) {
                    max = array[i];
                }
            }
            for (int i = k; i < array.length; i++) {
                if (array[i] == max) {
                    array[i] = array[i] + array[k] - (array[k] = array[i]);
                }
            }
        }
    }
}

class InsertionSort implements SortStrategy {
    @Override
    public void sortArray(double[] array) {
        int n = array.length;
        for (int j = 1; j < n; j++) {
            double key = array[j];
            int i = j - 1;
            while ((i > -1) && (array[i] > key)) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = key;
        }
    }
}

class QuickSort implements SortStrategy {
    @Override
    public void sortArray(double array[]) {
        quickSort(array, 0, array.length - 1);
    }

    public void quickSort(double array[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(array, begin, end);
            quickSort(array, begin, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, end);
        }
    }

    private int partition(double array[], int begin, int end) {
        double pivot = array[end];
        int i = (begin - 1);
        for (int j = begin; j < end; j++) {
            if (array[j] >= pivot) {
                i++;
                array[i] = array[i] + array[j] - (array[j] = array[i]);
            }
        }
        array[i + 1] = array[i + 1] + array[end] - (array[end] = array[i + 1]);
        return i + 1;
    }
}

class Sort {
    private SortStrategy sortStrategy;

    Sort(SortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public void execute(double[] array) {
        sortStrategy.sortArray(array);
    }
}
