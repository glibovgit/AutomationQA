package com.qa.hw2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Dmytro on 25.09.2016.
 */
public class Task2_7 {
    public static int getDifferentDigitsCount(int number) {
        int[] digits = Task2_1.getDigits(number);

        if (digits.length == 1) {
            return 1;
        }

        Arrays.sort(digits);
        int count = 0;
        for (int i = 0; i < digits.length; i++) {
            if (i > 0 && i < digits.length - 1) {
                if (digits[i] != digits[i + 1] && digits[i] != digits[i - 1]) {
                    count++;
                }
                if (digits[i] == digits[i + 1]) {
                    i++;
                }
            } else {
                if (i == 0 && digits[i] != digits[i + 1] || i == digits.length - 1 && digits[i] != digits[i - 1]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        //7. Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них.
        int[] numbers = Task2_1.getIntegerArrayFromConsole();
        System.out.println("\nЧисло, состоящее только из различных цифр: ");
        for (int i = 0; i < numbers.length; i++) {
            if(Task2_1.getDigits(numbers[i]).length == Task2_7.getDifferentDigitsCount(numbers[i])) {
                System.out.println(numbers[i]);
                break;
            }
        }
    }
}
