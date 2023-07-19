package org.example.matrixmultiplication;

import java.util.ArrayList;

public class MatrixMultiplier {

    public static void main(String... args) throws InterruptedException {
        //number of required threads equals the number of rows in the left matrix
        int[][] A = new int[][]{{1, 2, 3}, {4, 5, 6}};
        int[][] B = new int[][]{{7, 8}, {9, 10}, {11, 12}};
        int[][] result = new int[A.length][B[0].length];

        var list = new ArrayList<Thread>();
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < B[0].length; j++){
                list.add(new Worker(i, j, getRow(i, A), getColumn(j, B), result));
            }
        }

        for(var th: list){
            th.start();
        }
        for(var th: list){
            th.join();
        }

        System.out.println("done");
    }

    private static int[] getColumn(int columnIndex, int[][] matrix) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][columnIndex];
        }
        return column;
    }

    private static int[] getRow(int rowNumber, int[][] matrix) {
        return matrix[rowNumber];
    }

    private static class Worker extends Thread {

        private int rowIndex;
        private int columnIndex;
        private int[] actualRow;
        private int[] actualColumn;
        private int[][] result;

        public Worker(int rowIndex, int columnIndex, int[] actualRow, int[] actualColumn, int[][] result) {
            this.rowIndex = rowIndex;
            this.columnIndex = columnIndex;
            this.actualRow = actualRow;
            this.actualColumn = actualColumn;
            this.result = result;
        }

        @Override
        public void run() {
            int result = 0;
            for (int i = 0; i < actualColumn.length; i++) {
                result += actualColumn[i] * actualRow[i];
            }

            this.result[rowIndex][columnIndex] = result;
        }
    }
}
