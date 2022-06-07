package ru.yandex.school.E;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("input.txt"));
        char[] line = scanner.nextLine().toCharArray();
        for (int i = line.length - 1; i >= 0; i--) {
            if (line[i] == ')')
                for (int j = i - 1; j >= 0; j--) {
                    if (line[j] == '(') {
                        line[i] = 'R';
                        line[j] = 'L';
                        break;
                    }
                }
        }
        String s = String.valueOf(line);
        if ((s.contains("(") && s.contains(")"))
                || (!s.contains("(") && !s.contains(")"))
                || s.split("\\(").length > 2
                || s.split("\\)").length > 2)
            System.out.println(-1);
        else if (s.contains("("))
            System.out.println(s.indexOf("(") + 1);
        else
            System.out.println(s.indexOf(")") + 1);
    }
}
