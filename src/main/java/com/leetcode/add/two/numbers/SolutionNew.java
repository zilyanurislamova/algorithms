package com.leetcode.add.two.numbers;

import com.leetcode.palindrome.linked.list.ListNode;

import java.util.Set;

class SolutionNew {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0); // Initialize current node to dummy head of the returning list.
        ListNode p = l1, q = l2, curr = dummyHead; // Initialize p and q to head of l1 and l2 respectively.
        int carry = 0; // Initialize carry to 0 (0 or 1 because the largest possible sum of two digits (including the carry) is 9 + 9 + 1 = 19).
        while (p != null || q != null) { // Loop through lists l1l1 and l2l2 until you reach both ends.
            int x = (p != null) ? p.val : 0; // Set x to node p's value. If p has reached the end of l1, set to 0.
            int y = (q != null) ? q.val : 0; // Set y to node q's value. If q has reached the end of l2, set to 0.
            int sum = carry + x + y; // Set sum = x + y + carry.
            carry = sum / 10; // Update carry = sum / 10.
            curr.next = new ListNode(sum % 10); // Create a new node with the digit value of (sum mod 10) and set it to current node's next
            curr = curr.next; // then advance current node to next.
            if (p != null) p = p.next; // Advance both p and q.
            if (q != null) q = q.next;
        }
        if (carry > 0) { // If carry = 1, append a new node with digit 1 to the returning list.
            curr.next = new ListNode(carry);
        }
        return dummyHead.next; // Return dummy head's next node.
    }
}
