package com.leetcode.longest.substring.without.repeating.characters;

import javax.xml.stream.events.Characters;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        String s = "pwwkew";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        int maxLength = 1;
        for (int i = 0; i < s.length(); i++) {
            String currentSubstring = String.valueOf(s.charAt(i));
            int currentLength = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (!currentSubstring.contains(Character.toString(s.charAt(j)))) {
                    currentSubstring += s.charAt(j);
                    currentLength++;
                }
                else
                    break;
            }
            if (currentLength > maxLength)
                maxLength = currentLength;
        }
        return maxLength;
    }
}
