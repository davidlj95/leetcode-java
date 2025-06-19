package com.davidlj95.leetcode;

import com.davidlj95.leetcode.structures.ListNode;

// https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/ (2095)
public class DeleteMiddleNodeOfLinkedList {
    @SuppressWarnings("unused")
    public static ListNode deleteMiddle(ListNode head) {
        return bySlowAndFastPointers(head);
    }

    static ListNode byMovingMidParent(ListNode head) {
        if (head == null || head.next == null) return null;
        var midParent = head;
        var midParentIndex = 0;
        var i = 1;
        var current = head.next;
        while (current != null) {
            var newMidParentIndex = Math.ceil(i / 2.0) - 1;
            if (newMidParentIndex > midParentIndex) {
                midParent = midParent.next;
                midParentIndex++;
            }
            current = current.next;
            i++;
        }
        midParent.next = midParent.next.next;
        return head;
    }

    static ListNode bySlowAndFastPointers(ListNode head) {
        if (head == null || head.next == null) return null;
        var slow = new ListNode();
        slow.next = head;
        var fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
