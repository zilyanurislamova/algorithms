package com.leetcode.string.to.integer.atoi;

public class Solution {
    public static void main(String[] args) {
        System.out.println(myAtoi("   -04193a with words"));
    }

    public static int myAtoi(String s) {
        int length = s.length();
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < length && s.charAt(index) == ' ') // ignore whitespaces
            index++;
        if (index < length && s.charAt(index) == '-') { // check if negative
            sb.append('-');
            index++;
        }
        else if (index < length && s.charAt(index) == '+') { // if positive -> ignore, but increment i
            index++;
        }
        boolean digitsRead = false;
        while (index < length && Character.isDigit(s.charAt(index))) { // read and write digits
            digitsRead = true;
            sb.append(s.charAt(index));
            index++;
        }
        if (!digitsRead)
                return 0; // if there are no digits to read
        try {
            return Integer.parseInt(String.valueOf(sb)); // try to parse integer
        } catch (NumberFormatException e) {
            if (sb.charAt(0) == '-')
                return Integer.MIN_VALUE; // if negative and not included in integer range
            else return Integer.MAX_VALUE;
        }
    }
}
