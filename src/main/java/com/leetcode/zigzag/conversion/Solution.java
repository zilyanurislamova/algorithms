package com.leetcode.zigzag.conversion;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }

    public static String convert(String s, int numRows) {
        StringBuilder[] stringBuilders = new StringBuilder[numRows]; // array of sbs
        for (int i = 0; i < numRows; i++) {
            stringBuilders[i] = new StringBuilder(); // define sbs to avoid npe
        }

        char[] sArray = s.toCharArray();
        int n = s.length();
        int index = 0; // index of the letter in a string

        while (index < n) { // traverse zig zag
            for (int i = 0; i < numRows && index < n; i++) { // go down
                stringBuilders[i].append(sArray[index++]);
            }
            for (int i = numRows - 2; i > 0 && index < n ; i--) { // go up from last row to first row (not including)
                stringBuilders[i].append(sArray[index++]);
            }
        }
        
        StringBuilder result = stringBuilders[0];
        for (int i = 1; i < numRows; i++) { // collect all sbs into one
            result.append(stringBuilders[i]);
        }

        return result.toString(); // sb to string
    }
}
