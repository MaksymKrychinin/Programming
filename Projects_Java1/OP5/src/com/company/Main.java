package com.company;

public class Main {
    public static void main(String[] args) {
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        int[][] matrixFootball ={
                {0, 1, 1, 1, 1},
                {1, 0, 2, 2, 1},
                {1, 0, 0, 1, 1},
                {1, 0, 1, 0, 0},
                {1, 1, 1, 2, 0}};
        try {
        Task4.transpose(matrix1);
        Display.resultsMatrix(matrix1);
        } catch (NullPointerException e) {
            e.getMessage();
        } catch (ArrayIndexOutOfBoundsException e){
            e.getMessage();
        }
        try {
        Display.resultsArray(Task11.getFlawless(matrixFootball));
        } catch (NullPointerException e){
            e.getMessage();
        } catch (ArrayIndexOutOfBoundsException e){
            e.getMessage();
        } catch (IllegalArgumentException e){
            e.getMessage();
        }
    }
}
class Task4 {
    static void transpose(int[][] matrix) {
        if (matrix.length == 0) {
            throw new ArrayIndexOutOfBoundsException("Пустой Массив");
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] == null) {
                throw new NullPointerException("Null Array");
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix.length != matrix[i].length) {
                throw new IllegalArgumentException("Не квадратна матриця");
            }
        }
        int matrix2[][] = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            matrix2[i] = new int[matrix[i].length];
            for (int j = 0; j < matrix[0].length; j++) {
                matrix2[i][j] = matrix[i][j];
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[j][i] = matrix2[i][j];
            }
        }
    }
}
class Task11 {
    public static int[] getFlawless(int[][] matrix1) {
        if (matrix1.length == 0) {
            throw new ArrayIndexOutOfBoundsException("Пустой Массив");
        }
        for (int i = 0; i < matrix1.length; i++) {
            if (matrix1[i] == null) {
                throw new NullPointerException("Null Array");
            }
        }
        for (int i = 0; i < matrix1.length; i++) {
            if (matrix1.length != matrix1[i].length) {
                throw new IllegalArgumentException("Не квадратна матриця");
            }
        }
        int[] allElements = new int[matrix1.length];
        int arrayTeamsCount = 0;
        for (int i = 0; i < matrix1.length; i++) {
            int n = -1;
            for (int j = 0; j < matrix1.length; j++) {
                if (matrix1[i][j] == 0) {
                    n++;
                }
            }
            if (n == 0) {
                arrayTeamsCount++;
                allElements[i] = 1;
            }
        }
        int[] numbersFTeams = new int[arrayTeamsCount];
        for (int i = 0, k = 0; i < matrix1.length; i++) {
            if (allElements[i] == 1) {
                numbersFTeams[k] = i + 1;
                k++;
            }
        }
        return numbersFTeams;
    }
}
class Display{
    public static void resultsMatrix(int matrix[][]) {
        System.out.println("===========================");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print("[" + matrix[i][j] + "]");
                if (j < matrix.length - 1) {
                    System.out.print(",");
                }
            }
            if (i < matrix[0].length - 1) {
                System.out.println();
            }
        }
        System.out.println();
    }
    public static void resultsArray(int array[]) {
        System.out.println("===========================");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append("[" + array[i] + "]");
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        System.out.println(sb);
    }
}


