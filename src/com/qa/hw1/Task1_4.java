package com.qa.hw1;

import java.util.Scanner;

/**
 * Created by Dmytro on 22.09.2016.
 */
public class Task1_4 {
    public static void main(String[] args) {
        //4. Ввести пароль из командной строки и сравнить его со строкой-образцом.
        String password = "12345";
        System.out.println("Введите пароль:");
        Scanner scan = new Scanner(System.in);
        String enteredPassword = scan.next();

        if (enteredPassword.equals(password)) {
            System.out.println("Введенный пароль совпал с существующим");
        } else {
            System.out.println("Пароли разные");
        }

    }
}
