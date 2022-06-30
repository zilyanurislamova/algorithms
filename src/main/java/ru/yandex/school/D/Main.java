package ru.yandex.school.D;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nm = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        String[] strings = new String[n];
        int start = 0;
        int position = 0;
        for (int i = 0; i < n; i++) {
            strings[i] = scanner.nextLine();
            if (strings[i].contains("S")) {
                start = i;
                position = strings[i].indexOf("S");
            }
        }

        //вниз по лабиринту
        for (int i = start; i < n - 1; i++) {
            // вниз
            if (strings[i + 1].charAt(position) == '.' && Character.isLetter(strings[i].charAt(position))) {
                strings[i + 1] = strings[i + 1].substring(0, position) + 'D' + strings[i + 1].substring(position + 1);
            }
            // вправо
            for (int j = position + 1 ; j < m - 1; j++) {
                if (strings[i].charAt(j) == '.' && Character.isLetter(strings[i].charAt(j - 1))) {
                    strings[i] = strings[i].substring(0, j) + 'R' + strings[i].substring(j + 1);
                }
            }
            // влево
            for (int j = position - 1; j > 0 ; j--) {
                if (strings[i].charAt(j) == '.' && Character.isLetter(strings[i].charAt(j + 1))) {
                    strings[i] = strings[i].substring(0, j) + 'L' + strings[i].substring(j + 1);
                }
            }
        }

        // вверх по лабиринту
        for (int i = start; i > 0 ; i--) {
            // вверх
            if (strings[i - 1].charAt(position) == '.' && Character.isLetter(strings[i].charAt(position))) {
                strings[i - 1] = strings[i - 1].substring(0, position) + 'U' + strings[i - 1].substring(position + 1);
            }
            // вправо
            for (int j = position + 1 ; j < m - 1; j++) {
                if (strings[i].charAt(j) == '.' && Character.isLetter(strings[i].charAt(j - 1))) {
                    strings[i] = strings[i].substring(0, j) + 'R' + strings[i].substring(j + 1);
                }
            }
            // влево
            for (int j = position - 1; j > 0 ; j--) {
                if (strings[i].charAt(j) == '.' && Character.isLetter(strings[i].charAt(j + 1))) {
                    strings[i] = strings[i].substring(0, j) + 'L' + strings[i].substring(j + 1);
                }
            }
        }

        // оставшиеся пустые вверх
        for (int i = start - 1; i > 0 ; i--) {
            for (int j = 1; j < m - 1; j++) {
                if(strings[i].contains("."))
                    strings[i] = strings[i].replace('.', 'U');
            }
        }

        // оставшиеся пустые вниз
        for (int i = start; i < n - 1 ; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (i == start && strings[i].charAt(j) == '.') {
                    if (Character.isLetter(strings[i - 1].charAt(j)))
                        strings[i] = strings[i].substring(0, j) + 'D' + strings[i].substring(j + 1);
                    else if (Character.isLetter(strings[i + 1].charAt(j))) {
                        strings[i] = strings[i].substring(0, j) + 'U' + strings[i].substring(j + 1);
                    }
                }
                if(strings[i].contains("."))
                    strings[i] = strings[i].replace('.', 'D');
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(strings[i]);
        }
    }
}
