package ru.tinkoff.tinkoff1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        if (a > b || (a > b/n && b%n == 0))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
