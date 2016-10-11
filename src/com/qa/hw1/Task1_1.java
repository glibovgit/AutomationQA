package com.qa.hw1;

import java.util.Random;
import java.util.Scanner;

public class Task1_1 {
    public static void main(String[] args) {
        // write your code here
        //1. Приветствовать любого пользователя при вводе его имени через командную строку.
        System.out.println("Введите имя: ");
        Scanner scan = new Scanner(System.in);
        String name = scan.next();
        System.out.println("Привет, " + name);
    }
}
