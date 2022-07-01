package com.leetcode.longest.palindromic.substring;


public class Solution {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("c"));
    }

    public static String longestPalindrome(String s) {
        String answer = "";
        for (int i = 0; i < s.length(); i++) {
            String sub;
            for (int j = s.length() - 1; j >= i; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    sub = s.substring(i, j + 1);
                    if (answer.length() > sub.length())
                        break;
                    char left = sub.charAt(0);
                    char right = sub.charAt(sub.length() - 1);
                    boolean isPalindrome = true;
                    for (int k = 1; k < sub.length() / 2 + 1; k++) {
                        if (left != right) {
                            isPalindrome = false;
                            break;
                        }
                        else {
                            left = sub.charAt(k);
                            right = sub.charAt(sub.length() - 1 - k);
                        }
                    }
                    if (isPalindrome) {
                        answer = sub;
                    }
                }
            }
        }
        return answer;
    }
}
