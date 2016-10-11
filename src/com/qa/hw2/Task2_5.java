package com.qa.hw2;

/**
 * Created by Dmytro on 25.09.2016.
 */
public class Task2_5 {
    public static boolean isEvenNumber(int number) {
        return number % 2 == 0 ? true : false;
    }

    public static int evenNumberCount(int number) {
        int[] digits = Task2_1.getDigits(number);

        int count = 0;
        for (int i = 0; i < digits.length; i++) {
            if (Task2_5.isEvenNumber(digits[i])) {
                count++;
            }
        }
        return count;
    }

    public static int nonEvenNumberCount(int number) {
        int[] digits = Task2_1.getDigits(number);

        int count = 0;
        for (int i = 0; i < digits.length; i++) {
            if (!Task2_5.isEvenNumber(digits[i])) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        //5. Найти количество чисел, содержащих только четные цифры, а среди них количество чисел с равным числом четных и нечетных цифр.
        int[] numbers = Task2_1.getIntegerArrayFromConsole();

        int evenNumberCount = 0;
        int equalNumberCount = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (Task2_5.isEvenNumber(numbers[i])) {
                evenNumberCount++;
                if (Task2_5.evenNumberCount(numbers[i]) == Task2_5.nonEvenNumberCount(numbers[i])) {
                    equalNumberCount++;
                }
            }
        }

        System.out.println("\nКоличество чисел, содержащих только четные цифры: " + evenNumberCount);
        System.out.println("Количество чисел с равным числом четных и нечетных цифр: " + equalNumberCount);
    }
}
