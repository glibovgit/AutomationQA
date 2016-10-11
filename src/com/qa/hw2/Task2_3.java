package com.qa.hw2;

/**
 * Created by Dmytro on 25.09.2016.
 */
public class Task2_3 {
    public static int getAverageDigitsCount(int[] numbers) {
        int totalCount = 0;
        for (int i = 0; i < numbers.length; i++) {
            totalCount += Task2_1.getDigits(numbers[i]).length;
        }
        return totalCount / numbers.length;
    }

    public static void main(String[] args) {
        //3. Вывести на консоль те числа, длина которых меньше (больше) средней, а также длину.
        int[] numbers = Task2_1.getIntegerArrayFromConsole();

        int averageDigits = Task2_3.getAverageDigitsCount(numbers);
        System.out.println("\nСредняя длина: " + averageDigits);
        System.out.println("\nЧисла, длина которых меньше средней:");
        for (int i = 0; i < numbers.length; i++) {
            int digitsCount = Task2_1.getDigits(numbers[i]).length;
            if (digitsCount < averageDigits) {
                System.out.println(numbers[i] + " (длина: " + digitsCount + ")");
            }
        }

        System.out.println("Числа, длина которых больше средней:");
        for (int i = 0; i < numbers.length; i++) {
            int digitsCount = Task2_1.getDigits(numbers[i]).length;
            if (digitsCount > averageDigits) {
                System.out.println(numbers[i] + " (длина: " + digitsCount + ")");
            }
        }

    }
}
