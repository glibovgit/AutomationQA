package com.qa.hw2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Dmytro on 25.09.2016.
 */
public class Task2_6 {
    public static boolean areDigitsInAscendingOrder(int number) {
        int[] digits = Task2_1.getDigits(number);
        int[] sortedDigits = new int[digits.length];

        System.arraycopy(digits, 0, sortedDigits, 0, digits.length);
        Arrays.sort(sortedDigits);
        return Arrays.equals(digits, sortedDigits);
    }

    public static void main(String[] args) {
        //6. Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел несколько, найти первое из них.
        int[] numbers = Task2_1.getIntegerArrayFromConsole();

        System.out.println("Число, цифры в котором идут в строгом порядке возрастания: ");
        for (int i = 0; i < numbers.length; i++) {
            if (Task2_6.areDigitsInAscendingOrder(numbers[i])) {
                System.out.println(numbers[i]);
                break;
            }
        }
    }
}
