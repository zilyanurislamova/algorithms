package com.leetcode.longest.common.prefix;

public class Solution {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight","fl","f"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        String prefix = strs[0]; // starting with the first element as it is known there is at least one element
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1); // deleting one character in the end of prefix
                if (prefix.isEmpty()) // if prefix is empty - return empty string
                    return "";
            }
        }
        return prefix;
    }
}
