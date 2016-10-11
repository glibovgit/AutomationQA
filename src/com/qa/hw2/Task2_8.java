package com.qa.hw2;

import java.util.Arrays;

/**
 * Created by Dmytro on 27.09.2016.
 */
public class Task2_8 {
    public static int getMatrixSize(int elementCount) {
        int size = 1;
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            int result = i * i;
            if (result / elementCount >= 1) {
                size = i;
                break;
            }
        }
        return size;
    }

    public static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }

    public static void main(String[] args) {
        //8. Вывести числа от 1 до k в виде матрицы N x N слева направо и сверху вниз.
        //System.out.println(Task2_8.getMatrixSize(2));
        int k = 8;
        System.out.println(Task2_8.getMatrixSize(k));
        int n = Task2_8.getMatrixSize(k);
        int index = 1;

        int[][] array = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (index <= k) {
                    array[i][j] = index++;
                }
            }
        }
        Task2_8.printArray(array);

        index = 1;
        array = new int[n][n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                if (index <= k) {
                    array[i][j] = index++;
                }
            }
        }
        Task2_8.printArray(array);
    }
}
