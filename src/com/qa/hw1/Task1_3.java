package com.qa.hw1;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Dmytro on 22.09.2016.
 */
public class Task1_3 {
    public static void main(String[] args) {
        //3. Вывести заданное количество случайных чисел с переходом и без переходана новую строку.
        Scanner scan = new Scanner(System.in);
        int[] array;
        System.out.println("Введите количество случайных чисел: ");

        int randomNumberCount = Integer.parseInt(scan.next());
        array = new int[randomNumberCount];
        for (int i = 0; i < randomNumberCount; i++) {
            array[i] = new Random().nextInt() % 100000;
        }

        System.out.println("Отображение случайных чисел с переходом на новую строку:");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        System.out.println("Отображение случайных чисел без перехода на новую строку:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
