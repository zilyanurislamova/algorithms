package com.leetcode.middle.of.the.linked.list;


import com.leetcode.palindrome.linked.list.ListNode;

public class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode middle = head;
        if (head.next == null)
            return head;
        int i = 0;
        while (head.next != null) {
            head = head.next;
            i++;
            if (head.next == null)
                i++;
        }
        for (int j = 0; j < i/2; j++) {
            middle = middle.next;
        }
        return middle;
    }
}
