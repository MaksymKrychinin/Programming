package com.company;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BubbleSortTest {
    Sort sortConstructor;
    public static boolean isSorted(double[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    @org.junit.jupiter.api.Test
    void testIsSortedBubble() {
        double[] arrayNotSorted = {1, 5, 8, 4, 1, 7, 8, 8, 4, 3, 2, 4, 6, 6, 6};
        sortConstructor = new Sort(new BubbleSort());
        sortConstructor.execute(arrayNotSorted);
        boolean isSorted = isSorted(arrayNotSorted);
        assertEquals(true, isSorted);
    }

    @org.junit.jupiter.api.Test
    void TestIsSortedOneElement() {
        double[] arrayNotSorted = {1};
        sortConstructor = new Sort(new BubbleSort());
        sortConstructor.execute(arrayNotSorted);
        boolean isSorted = isSorted(arrayNotSorted);
        assertEquals(true, isSorted);
    }

    @org.junit.jupiter.api.Test
    void TestIsSortedZero() {
        double[] arrayNotSorted = {};
        sortConstructor = new Sort(new BubbleSort());
        sortConstructor.execute(arrayNotSorted);
        boolean isSorted = isSorted(arrayNotSorted);
        assertEquals(true, isSorted);
    }

    @org.junit.jupiter.api.Test
    void testResultNull() {
        double[] arrayNotSorted = null;
        sortConstructor = new Sort(new BubbleSort());
        sortConstructor.execute(arrayNotSorted);
        boolean isSorted = isSorted(arrayNotSorted);
        assertEquals(true, isSorted);
    }
}
