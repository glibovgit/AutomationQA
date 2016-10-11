package com.qa.hw2;

import java.util.Arrays;

/**
 * Created by Dmytro on 25.09.2016.
 */
public class Task2_2 {
    public static void sortAscending(int[] numbers) {
        for (int barrier = numbers.length - 1; barrier >= 0; barrier--) {
            for (int index = 0; index < barrier; index++) {
                if (Task2_1.getDigits(numbers[index]).length > Task2_1.getDigits(numbers[index + 1]).length) {
                    int tmp = numbers[index];
                    numbers[index] = numbers[index + 1];
                    numbers[index + 1] = tmp;
                }
            }
        }
    }

    public static void sortDescending(int[] numbers) {
        for (int barrier = numbers.length - 1; barrier >= 0; barrier--) {
            for (int index = 0; index < barrier; index++) {
                if (Task2_1.getDigits(numbers[index]).length < Task2_1.getDigits(numbers[index + 1]).length) {
                    int tmp = numbers[index];
                    numbers[index] = numbers[index + 1];
                    numbers[index + 1] = tmp;
                }
            }
        }
    }

    public static int[] getArrayCopy(int[] array) {
        int[] arrayCopy = new int[array.length];
        System.arraycopy(array, 0, arrayCopy, 0, array.length);
        return arrayCopy;
    }

    public static void main(String[] args) {
        //2. Упорядочить и вывести числа в порядке возрастания (убывания) значений их длины.
        int[] numbers = Task2_1.getIntegerArrayFromConsole();
        int[] arrayCopy = Task2_2.getArrayCopy(numbers);

        Task2_2.sortAscending(arrayCopy);
        System.out.println("\nЧисла в порядке возрастания значений их длины: ");
        System.out.println(Arrays.toString(arrayCopy));


        Task2_2.sortDescending(arrayCopy);
        System.out.println("\nЧисла в порядке убывания значений их длины: ");
        System.out.println(Arrays.toString(arrayCopy));
    }
}
