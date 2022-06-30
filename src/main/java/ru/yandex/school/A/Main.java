package ru.yandex.school.A;

import java.util.Scanner;

public class Main {
    public static final String correct = "correct";
    public static final String present = "present";
    public static final String absent = "absent";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String q = scanner.nextLine();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (!s.contains(String.valueOf(q.charAt(i)))) {
                System.out.println(absent);
                continue;
            }
            if (q.charAt(i) == s.charAt(i)) {
                s = s.substring(0, i) + s.substring(i + 1);
                q = q.substring(0, i) + q.substring(i + 1);
                length--;
                i--;
                System.out.println(correct);
                continue;
            }
            for (int j = 0; j < length; j++) {
                if (i != j && q.charAt(i) == s.charAt(j) && q.charAt(j) != s.charAt(j)) {
                    s = s.substring(0, j) + "*" + s.substring(j + 1);
                    System.out.println(present);
                    break;
                }
                if (j == length - 1) {
                    System.out.println(absent);
                    break;
                }
            }
        }
    }
}
