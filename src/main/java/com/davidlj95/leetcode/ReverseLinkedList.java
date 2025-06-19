package com.davidlj95.leetcode;

import com.davidlj95.leetcode.structures.ListNode;

// https://leetcode.com/problems/reverse-linked-list/ (206)
public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        var newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
