package ru.tinkoff.tinkoff3;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger number = scanner.nextBigInteger();
        int result = 0;
        while (number.remainder(BigInteger.TEN).equals(BigInteger.ZERO)) {
            number = number.divide(BigInteger.TEN);
        }
        String s = String.valueOf(number);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0')
                result++;
        }
        System.out.println(result);
    }
}
