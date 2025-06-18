package com.davidlj95.leetcode;

import java.util.ArrayList;

public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        var newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        @SuppressWarnings("unused")
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        static ListNode fromIntArray(int[] array) {
            if (array.length == 0) return new ListNode();
            ListNode node = null;
            for (int i = array.length - 1; i >= 0; i--) {
                node = new ListNode(array[i], node);
            }
            return node;
        }

        @Override
        public int hashCode() {
            return Integer.valueOf(val).hashCode() + (next != null ? next.hashCode() : 0);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return false;
            if (!(obj instanceof ListNode other)) return false;
            return val == other.val && ((next != null && next.equals(other.next)) || (next == null && other.next == null));
        }

        @Override
        public String toString() {
            var values = new ArrayList<Integer>();
            var node = this;
            while (node != null) {
                values.add(node.val);
                node = node.next;
            }
            return values.toString();
        }
    }
}
