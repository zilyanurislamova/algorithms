package com.leetcode.reverse.integer;

public class Solution {
    public static void main(String[] args) {
        System.out.println(reverse(-120));
    }

    public static int reverse(int x) {
        StringBuilder result = x >= 0 ? new StringBuilder("") : new StringBuilder("-");
        while (Math.abs(x) % 10 > 0 || Math.abs(x) / 10 > 0) {
            result.append(Math.abs(x) % 10);
            x = Math.abs(x) / 10;
        }
        try {
            return Integer.parseInt(String.valueOf(result));
        }
        catch (NumberFormatException e) {
            return 0;
        }
    }
}
