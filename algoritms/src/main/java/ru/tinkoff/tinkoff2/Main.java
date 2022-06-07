package ru.tinkoff.tinkoff2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ab = scanner.nextLine();
        String ac = scanner.nextLine();
        String bc = scanner.nextLine();
        String more = ">";
        String less = "<";
        String equal = "=";
        if ((ab.equals(less) || ab.equals(equal)) && ac.equals(less) && (bc.equals(less) || bc.equals(equal)))
            System.out.println("abc");
        if (ab.equals(less) && (ac.equals(less) || ac.equals(equal)) && (bc.equals(more) || bc.equals(equal)))
            System.out.println("acb");
        if ((ab.equals(more) || ab.equals(equal)) && (ac.equals(less) || ac.equals(equal)) && bc.equals(less))
            System.out.println("bac");
        if (ab.equals(more) && (ac.equals(more) || ac.equals(equal)) && (bc.equals(less) || bc.equals(equal)))
            System.out.println("bca");
        if ((ab.equals(less) || ab.equals(equal)) && (ac.equals(more) || ac.equals(equal)) && bc.equals(more))
            System.out.println("cab");
        if ((ab.equals(more) || ab.equals(equal)) && ac.equals(more) && (bc.equals(more) || bc.equals(equal)))
            System.out.println("cba");

        if (ab.equals(equal) && ac.equals(equal) && bc.equals(equal)) {
            System.out.println("abc");
            System.out.println("acb");
            System.out.println("bac");
            System.out.println("bca");
            System.out.println("cab");
            System.out.println("cba");
        }
    }
}
