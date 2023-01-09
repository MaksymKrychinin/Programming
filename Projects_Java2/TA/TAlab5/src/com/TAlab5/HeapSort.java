package com.TAlab5;

public class HeapSort implements SortingModule{
    int field=0;
    int field1=0;
    @Override
    public void sort(int arr[]) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            field++;
            heapify(arr, i, 0);
        }
    }

    void heapify(int arr[], int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && arr[l] > arr[largest])
            field++;
            largest = l;
        if (r < n && arr[r] > arr[largest])
            field++;
            largest = r;
        if (largest != i & largest<arr.length) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
            field1++;
        }
    }
}
