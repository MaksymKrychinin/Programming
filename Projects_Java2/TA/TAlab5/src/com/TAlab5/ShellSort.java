package com.TAlab5;

public class ShellSort implements SortingModule {
    @Override
    public void sort(int[] array) {
        int h=3;
        for (int gap = array.length / h; gap > 0; gap /= h) {
            for (int i = gap; i < array.length; i += 1) {
                int temp = array[i];int j;
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
        }
    }
}
