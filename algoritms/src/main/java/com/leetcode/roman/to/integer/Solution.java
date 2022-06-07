package com.leetcode.roman.to.integer;
class Solution {
    public static void main(String[]args){
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'I':
                    if (i != s.length()-1) {
                        switch (s.charAt(i + 1)) {
                            case 'V':
                                result += 4;
                                i++;
                                break;
                            case 'X':
                                result += 9;
                                i++;
                                break;
                            default:
                                result += 1;
                        }
                    }
                    else
                        result += 1;
                    break;
                case 'X':
                    if (i != s.length()-1) {
                        switch (s.charAt(i + 1)) {
                            case 'L':
                                result += 40;
                                i++;
                                break;
                            case 'C':
                                result += 90;
                                i++;
                                break;
                            default:
                                result += 10;
                        }
                    }
                    else
                        result += 10;
                    break;
                case 'C':
                    if (i != s.length()-1) {
                        switch (s.charAt(i + 1)) {
                            case 'D':
                                result += 400;
                                i++;
                                break;
                            case 'M':
                                result += 900;
                                i++;
                                break;
                            default:
                                result += 100;
                        }
                    }
                    else
                        result += 100;
                    break;
                case 'V':
                    result += 5;
                    break;
                case 'L':
                    result += 50;
                    break;
                case 'D':
                    result += 500;
                    break;
                case 'M':
                    result += 1000;
            }
        }
        return result;
    }
}
