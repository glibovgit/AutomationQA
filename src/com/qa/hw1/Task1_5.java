package com.qa.hw1;

/**
 * Created by Dmytro on 22.09.2016.
 */
public class Task1_5 {
    public static void main(String[] args) {
        //5. Ввести целые числа как аргументы командной строки, подсчитать их суммы (произведения) и вывести результат на консоль.
        int sum = 0;
        int product = 1;
        for (int i = 0; i < args.length; i++) {
            sum += Integer.parseInt(args[i]);
            product *= Integer.parseInt(args[i]);
        }
        System.out.println("Сумма: " + sum);
        System.out.println("Произведение: " + product);
    }
}
