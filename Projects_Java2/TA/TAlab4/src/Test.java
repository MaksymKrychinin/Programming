public class Test {
    public static void main(String[] args) {
        int[] array10 = new int[10];
        int[] array100 = new int[100];
        int[] array1000 = new int[1000];
        int[] array5000 = new int[5000];
        int[] array10000 = new int[10000];
        int[] array20000 = new int[20000];
        int[] array50000 = new int[50000];
        for (int i = 0; i < array10.length; i++) {
            array10[i] = (int) (Math.random() * 100);
        }
        for (int i = 0; i < array100.length; i++) {
            array100[i] = (int) (Math.random() * 100);
        }
        for (int i = 0; i < array1000.length; i++) {
            array1000[i] = (int) (Math.random() * 100);
        }
        for (int i = 0; i < array5000.length; i++) {
            array5000[i] = (int) (Math.random() * 100);
        }
        for (int i = 0; i < array10000.length; i++) {
            array10000[i] = (int) (Math.random() * 100);
        }
        for (int i = 0; i < array20000.length; i++) {
            array20000[i] = (int) (Math.random() * 100);
        }
        for (int i = 0; i < array50000.length; i++) {
            array50000[i] = (int) (Math.random() * 100);
        }
        System.out.printf("|%10s|%20s|%20s|%n", "Массив", "Число порівнянь", "Число перестановок");
        HeapSort sort = new HeapSort();
        sort.sort(array10);
        System.out.printf("|%10s|%20s|%20s|%n", "10", sort.field, sort.field1);
        HeapSort sort1 = new HeapSort();
        sort1.sort(array100);
        System.out.printf("|%10s|%20s|%20s|%n", "100", sort1.field, sort1.field1);
        HeapSort sort2 = new HeapSort();
        sort2.sort(array1000);
        System.out.printf("|%10s|%20s|%20s|%n", "1000", sort2.field, sort2.field1);
        HeapSort sort3 = new HeapSort();
        sort3.sort(array5000);
        System.out.printf("|%10s|%20s|%20s|%n", "5000", sort3.field, sort3.field1);
        HeapSort sort4 = new HeapSort();
        sort4.sort(array10000);
        System.out.printf("|%10s|%20s|%20s|%n", "10000", sort4.field, sort4.field1);
        HeapSort sort5 = new HeapSort();
        sort5.sort(array20000);
        System.out.printf("|%10s|%20s|%20s|%n", "20000", sort5.field, sort5.field1);
        HeapSort sort6 = new HeapSort();
        sort6.sort(array50000);
        System.out.printf("|%10s|%20s|%20s|%n", "50000", sort6.field, sort6.field1);
    }
}
