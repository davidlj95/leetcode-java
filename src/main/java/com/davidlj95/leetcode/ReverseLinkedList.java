package com.davidlj95.leetcode;

import com.davidlj95.leetcode.structures.ListNode;

public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        var newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
