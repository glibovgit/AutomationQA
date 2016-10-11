package com.qa.hw2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Dmytro on 24.09.2016.
 */
public class Task2_1 {
    public static int getShortestNumberIndex(int[] numbers) {
        if (numbers.length == 0 || numbers.length == 1) {
            return -1;
        }

        int index = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (Task2_1.getDigits(numbers[i]).length < Task2_1.getDigits(numbers[index]).length) {
                index = i;
            }
        }
        return index;
    }

    public static int[] getDigits(int number) {
        number = Math.abs(number);
        int[] array = new int[String.valueOf(number).length()];

        int index = array.length - 1;
        while (number != 0) {
            array[index--] = number % 10;
            number = number / 10;
        }
        return array;
    }

    public static int getLongestNumberIndex(int[] numbers) {
        if (numbers.length == 0 || numbers.length == 1) {
            return -1;
        }

        int index = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (Task2_1.getDigits(numbers[i]).length > Task2_1.getDigits(numbers[index]).length) {
                index = i;
            }
        }
        return index;
    }

    public static int[] getIntegerArrayFromConsole() {
        System.out.println("\nВведите количество чисел:");
        Scanner scan = new Scanner(System.in);
        int[] array;

        String numberStr = scan.next();
        array = new int[Integer.parseInt(numberStr)];

        for (int i = 0; i < Integer.parseInt(numberStr); i++) {
            System.out.println("Введите " + (i + 1) + "-е число:");
            String number = scan.next();
            array[i] = Integer.parseInt(number);
        }
        scan.close();
        return array;
    }

    public static void main(String[] args) {
        //1. Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
        int[] numbers = Task2_1.getIntegerArrayFromConsole();

        int index = Task2_1.getShortestNumberIndex(numbers);
        if (index != -1) {
            System.out.println("Самое короткое число: " + numbers[index]);
            System.out.println("Индекс: " + index);
        } else {
            System.out.println("Самое короткое число: такого числа нет");
        }

        index = Task2_1.getLongestNumberIndex(numbers);
        if (index != -1) {
            System.out.println("\nСамое длинное число: " + numbers[index]);
            System.out.println("Индекс: " + index);
        } else {
            System.out.println("\nСамое длинное число: такого числа нет");
        }
    }
}
