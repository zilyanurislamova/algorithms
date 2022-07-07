package com.leetcode.integer.to.roman;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        System.out.println(intToRoman(20));
    }

    public static String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        HashMap<Integer, String> symbols = new HashMap<>();
        symbols.put(1, "I");
        symbols.put(4, "IV");
        symbols.put(5, "V");
        symbols.put(9, "IX");
        symbols.put(10, "X");
        symbols.put(40, "XL");
        symbols.put(50, "L");
        symbols.put(90, "XC");
        symbols.put(100, "C");
        symbols.put(400, "CD");
        symbols.put(500, "D");
        symbols.put(900, "CM");
        symbols.put(1000, "M");

        // thousands
        if (num >= 1000) {
            int n = num/1000;
            for (int i = 0; i < n; i++) {
                result.append(symbols.get(1000));
                num -= 1000;
            }
        }

        // hundreds
        if (num >= 900) {
            result.append(symbols.get(900));
            num -= 900;
        } else if (num >= 500) {
            result.append(symbols.get(500));
            num -= 500;
            int n = num/100;
            for (int i = 0; i < n; i++) {
                result.append(symbols.get(100));
                num -= 100;
            }
        } else if (num >= 400) {
            result.append(symbols.get(400));
            num -= 400;
        } else {
            int n = num/100;
            for (int i = 0; i < n; i++) {
                result.append(symbols.get(100));
                num -= 100;
            }
        }

        // dozens
        if (num >= 90) {
            result.append(symbols.get(90));
            num -= 90;
        } else if (num >= 50) {
            result.append(symbols.get(50));
            num -= 50;
            int n = num/10;
            for (int i = 0; i < n; i++) {
                result.append(symbols.get(10));
                num -= 10;
            }
        } else if (num >= 40) {
            result.append(symbols.get(40));
            num -= 40;
        } else {
            int n = num/10;
            for (int i = 0; i < n; i++) {
                result.append(symbols.get(10));
                num -= 10;
            }
        }

        // numbers
        if (num == 9) {
            result.append(symbols.get(9));
        } else if (num >= 5) {
            result.append(symbols.get(5));
            num -= 5;
            for (int i = 0; i < num; i++) {
                result.append(symbols.get(1));
            }
        } else if (num == 4) {
            result.append(symbols.get(4));
        } else {
            for (int i = 0; i < num; i++) {
                result.append(symbols.get(1));
            }
        }

        return result.toString();
    }
}
