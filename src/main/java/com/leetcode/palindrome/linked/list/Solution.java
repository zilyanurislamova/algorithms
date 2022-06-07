package com.leetcode.palindrome.linked.list;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] ints = {1,1,2,1};
        System.out.println(isPalindrome(ints));
    }

    public boolean isPalindrome(ListNode head) {
        if (head.next == null)
            return true;
        int[] ints = new int[10*10*10*10*10];
        int i = 0;
        while (head.next != null) {
            ints[i] = head.val;
            head = head.next;
            i++;
            if (head.next == null)
                ints[i] = head.val;
        }
        int[] intsNew = Arrays.copyOfRange(ints, 0, i + 1);
        return isPalindrome(intsNew);
    }

    public static boolean isPalindrome(int[] ints) {
        int i = 0;
        int first = ints[i];
        int last = ints[ints.length - 1 - i];
        while (i < ints.length/2) {
            if (first != last)
                return false;
            else {
                i++;
                first = ints[i];
                last = ints[ints.length - 1 - i];
            }
        }
        return true;
    }
}
