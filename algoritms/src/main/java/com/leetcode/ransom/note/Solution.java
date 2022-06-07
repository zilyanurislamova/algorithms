package com.leetcode.ransom.note;

public class Solution {
    public static void main(String[] args) {
        System.out.println(canConstruct("aa", "aba"));
    }
    public static boolean canConstruct(String ransomNote, String magazine) {
        boolean[] isOk = new boolean[ransomNote.length()];
        for (int i = 0; i < ransomNote.length(); i++) {
            for (int j = 0; j < magazine.length(); j++) {
                if (ransomNote.charAt(i) == magazine.charAt(j)) {
                    magazine = magazine.substring(0, j) + magazine.substring(j + 1);
                    isOk[i] = true;
                    break;
                }
            }
        }
        for (boolean value: isOk) {
            if (!value)
                return false;
        }
        return true;
    }
}
