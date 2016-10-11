package com.qa.hw1;

/**
 * Created by Dmytro on 22.09.2016.
 */
public class Task1_2 {
    public static void main(String[] args) {
        //2. Отобразить в окне консоли аргументы командной строки в обратном порядке.
        for (int i = args.length - 1; i >= 0; i--) {
            System.out.print(args[i] + " ");
        }
    }
}
