package com.TAlab5;


public class QuickSort implements SortingModule{
    public void sort(int[] array, int low, int high) {
        if (array.length == 0)
            return;
        if (low >= high)
            return;
        int pivot = array[high];
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j)
            sort(array, low, j);
        if (high > i)
            sort(array, i, high);
    }
@Override
    public void sort(int[] array) {
        int low = 0, high = array.length - 1;
        sort(array, low, high);
    }
}