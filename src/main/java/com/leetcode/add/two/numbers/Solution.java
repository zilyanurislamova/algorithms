package com.leetcode.add.two.numbers;

import com.leetcode.palindrome.linked.list.ListNode;
import java.math.BigInteger;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String s1 = String.valueOf(l1.val);
        while (l1.next != null) {
            l1 = l1.next;
            s1 = l1.val + s1;
        }
        String s2 = String.valueOf(l2.val);
        while (l2.next != null) {
            l2 = l2.next;
            s2 = l2.val + s2;
        }
        BigInteger b1 = new BigInteger(s1);
        BigInteger b2 = new BigInteger(s2);
        BigInteger sum = b1.add(b2);
        String s = String.valueOf(sum);
        int length = s.length();
        ListNode result = new ListNode(Character.digit(s.charAt(length - 1), 10));
        ListNode current = result;
        for (int j = length - 2; j >= 0; j--) {
            current = result.next;
            result.next = new ListNode(Character.digit(s.charAt(j), 10));
        }
        return result;
    }
}
