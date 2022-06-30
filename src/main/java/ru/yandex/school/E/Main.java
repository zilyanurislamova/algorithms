package ru.yandex.school.E;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("input.txt"));
        String s = scanner.nextLine();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')')
                for (int j = i - 1; j >= 0; j--) {
                    if (s.charAt(j) == '(') {
                        s = s.substring(0, j) + 'L' + s.substring(j + 1, i) + 'R' + s.substring(i + 1);
                        break;
                    }
                }
        }

        if ((s.contains("(") && s.contains(")"))
                || (!s.contains("(") && !s.contains(")"))
                || s.lastIndexOf("(") != s.indexOf("(")
                || s.lastIndexOf(")") != s.indexOf(")"))
            System.out.println(-1);
        else if (s.contains("("))
            System.out.println(s.indexOf("(") + 1);
        else
            System.out.println(s.indexOf(")") + 1);
    }
}
