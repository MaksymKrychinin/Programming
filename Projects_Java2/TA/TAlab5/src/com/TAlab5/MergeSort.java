package com.TAlab5;


public class MergeSort implements SortingModule{

    int[] merge(int[] array1, int[] array2) {
        int[] arrayToReturn = new int[array1.length + array2.length];
        int firstIndex = 0, secondIndex = 0;
        for (int i = 0; i < arrayToReturn.length; i++) {
            if (firstIndex < array1.length && secondIndex < array2.length && array1[firstIndex] <= array2[secondIndex]) {
                arrayToReturn[i] = array1[firstIndex];
                firstIndex++;
            } else if (secondIndex < array2.length) {
                arrayToReturn[i] = array2[secondIndex];
                secondIndex++;
            } else {
                arrayToReturn[i] = array1[firstIndex];
                firstIndex++;
            }
        }
        return arrayToReturn;
    }

     int[] sort1(int[] array) {
        if (array.length < 2) {
            return array;
        }
        int[] array1 = new int[array.length / 2];
        System.arraycopy(array, 0, array1, 0, array.length / 2);
        int[] array2 = new int[array.length - array.length / 2];
        System.arraycopy(array, array.length / 2, array2, 0, array.length - array.length / 2);
        array1 = sort1(array1);
        array2 = sort1(array2);
        return merge(array1, array2);
    }



@Override
    public void sort(int[] array) {
        array=sort1(array);
    }
}
