package com.qa.hw1;

import java.util.Scanner;

/**
 * Created by Dmytro on 22.09.2016.
 */
public class Task1_6 {
    public static boolean isEvenNumber(int number) {
        if (number % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static int getMaxArrayValue(int[] array) {
        int maxValue = array[0];
        for (int i = 0; i < array.length; i++) {
            if (maxValue < array[i]) {
                maxValue = array[i];
            }
        }
        return maxValue;
    }

    public static int getMinArrayValue(int[] array) {
        int minValue = array[0];
        for (int i = 0; i < array.length; i++) {
            if (minValue > array[i]) {
                minValue = array[i];
            }
        }
        return minValue;
    }

    public static boolean isDividedByThreeOrNine(int number) {
        if (number % 3 == 0 || number % 9 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isDividedByFiveAndSeven(int number) {
        if (number % 5 == 0 && number % 7 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isHappyNumber(int number) {
        int digitCount = String.valueOf(number).length();
        if (digitCount % 2 == 1) return false;

        int leftPartSum = 0;
        for (int i = 0; i < digitCount / 2; i++) {
            leftPartSum += Integer.parseInt(Character.toString(String.valueOf(number).charAt(i)));
        }

        int rigthPartSum = 0;
        for (int i = digitCount / 2; i < digitCount; i++) {
            rigthPartSum += Integer.parseInt(Character.toString(String.valueOf(number).charAt(i)));
        }
        return leftPartSum == rigthPartSum ? true : false;
    }

    public static void main(String[] args) {
        //6.Ввести с консоли n целых чисел. На консоль вывести:
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

        //6.1. Четные и нечетные числа.
        System.out.println("\nЧетные числа: ");
        for (int i = 0; i < array.length; i++) {
            if (Task1_6.isEvenNumber(array[i])) {
                System.out.print(array[i] + " ");
            }
        }

        System.out.println("\nНечетные числа: ");
        for (int i = 0; i < array.length; i++) {
            if (!Task1_6.isEvenNumber(array[i])) {
                System.out.print(array[i] + " ");
            }
        }

        //6.2. Наибольшее и наименьшее число.
        System.out.println("\nНаибольшее число: " + Task1_6.getMaxArrayValue(array));
        System.out.println("Наименьшее число: " + Task1_6.getMinArrayValue(array));

        //6.3. Числа, которые делятся на 3 или на 9.
        System.out.println("Числа, которые делятся на 3 или на 9: ");
        for (int i = 0; i < array.length; i++) {
            if (Task1_6.isDividedByThreeOrNine(array[i])) {
                System.out.print(array[i] + " ");
            }
        }

        //6.4. Числа, которые делятся на 5 и на 7.
        System.out.println("\nЧисла, которые делятся на 5 и на 7: ");
        for (int i = 0; i < array.length; i++) {
            if (Task1_6.isDividedByFiveAndSeven(array[i])) {
                System.out.print(array[i] + " ");
            }
        }

        //6.5. Все трехзначные числа, в десятичной записи которых нет одинаковых цифр.
        for (int i = 0; i < array.length; i++) {
            int n1 = array[i] / 100;
            if (n1 > 0 && n1 < 10) {
                int n2 = array[i] / 10 % 10;
                int n3 = array[i] % 10;
                if (n1 != n2 && n2 != n3 && n1 != n3) {
                    System.out.print(array[i] + " ");
                }
            }
        }

        //6.6. «Счастливые» числа.
        for (int i = 0; i < array.length; i++) {
            if (Task1_6.isHappyNumber(array[i])) {
                System.out.print(array[i] + " ");
            }
        }

        //6.7. Элементы, которые равны полусумме соседних элементов.
        System.out.println("\nЭлементы, которые равны полусумме соседних элементов: ");
        for (int i = 1; i < array.length; i++) {
            if (i + 1 < array.length && ((float) array[i - 1] + (float) array[i + 1]) / 2 == (float) array[i]) {
                System.out.print(array[i] + " ");
            }
        }
    }
}
