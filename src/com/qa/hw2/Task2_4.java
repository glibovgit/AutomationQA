package com.qa.hw2;

/**
 * Created by Dmytro on 25.09.2016.
 */
public class Task2_4 {
    public static void main(String[] args) {
        //4. Найти число, в котором число различных цифр минимально. Если таких чисел несколько, найти первое из них.
        int[] numbers = Task2_1.getIntegerArrayFromConsole();

        int index = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (Task2_7.getDifferentDigitsCount(numbers[i]) < Task2_7.getDifferentDigitsCount(numbers[index])) {
                index = i;
            }
        }

        System.out.println("Число, в котором число различных цифр минимально: " + numbers[index]);
    }
}
