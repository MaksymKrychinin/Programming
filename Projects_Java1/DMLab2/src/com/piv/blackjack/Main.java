package com.piv.blackjack;

public class Main {

    public static void main(String[] args) {
        int[][] matrix = {{1, 0},
                {0, 1}};
        DisplayMatrix.resultsMatrix(MatrixMath.power(matrix, 3));
    }

}


class MatrixMath {
    public static int[][] power(int[][] matrix, int power) {
        int[][] ToTwo = new int[matrix.length][matrix[0].length];
        int[][] ToThree = new int[matrix.length][matrix[0].length];
        int[][] c = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                ToTwo[i][j] = matrix[i][j];
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                ToThree[i][j] = matrix[i][j];
            }
        }
        if (power == 3) {
            c=multiply(multiply(matrix, ToTwo), ToThree);
        } else if (power == 2) {
            c=multiply(matrix, ToTwo);
        }
        return c;
    }

    static int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int k = 0; k < b[0].length; k++) {
                int sum = 0;
                for (int j = 0; j < a[i].length; j++) {
                    sum += a[i][j] * b[j][k];
                }
                c[i][k] = sum;
            }
        }
        return c;
    }
}

class DisplayMatrix {
    public static void resultsMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print("[" + matrix[i][j] + "]");
                if (j < matrix[0].length - 1) {
                    System.out.print(",");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}