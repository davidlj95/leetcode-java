package com.davidlj95.leetcode;

import java.util.LinkedList;
import java.util.PriorityQueue;

// https://leetcode.com/problems/kth-largest-element-in-an-array/ (215)
public class KthLargestElementArray {
    @SuppressWarnings("unused")
    public static int findKthLargest(int[] nums, int k) {
        return byMinHeap(nums, k);
    }

    public static int byMinHeap(int[] nums, int k) {
        var heap = new PriorityQueue<Integer>(k);
        for (var i = 0; i < k; i++) heap.offer(nums[i]);
        for (var i = k; i < nums.length; i++) {
            //noinspection DataFlowIssue
            if (nums[i] >= heap.peek()) {
                heap.poll();
                heap.offer(nums[i]);
            }
        }
        //noinspection DataFlowIssue
        return heap.peek();
    }

    // Time exceeded.
    // Given inserting in order is O(log k), and we do n-1 (length of nums) insertions,
    // the complexity is quite huge: O( (n-1) * log k ). Or O(n log k) to simplify. Quite many if k is big
    // Indeed, it would take the same average complexity to just sort it using Quick Sort.
    public static int byInsertingInOrder(int[] nums, int k) {
        var greatestK = new LinkedList<Integer>();
        greatestK.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            var num = nums[i];
            insertInOrder(greatestK, num);
            if (greatestK.size() > k) {
                greatestK.removeFirst();
            }
        }
        return greatestK.getFirst();
    }

    private static void insertInOrder(LinkedList<Integer> nums, int num) {
        if (num >= nums.getLast()) {
            nums.add(num);
            return;
        } else if (num <= nums.getFirst()) {
            nums.add(0, num);
            return;
        }
        var i = 0;
        var j = nums.size();
        var position = (j - i) / 2;
        while (num < nums.get(position - 1) || num > nums.get(position)) {
            if (num > nums.get(position)) {
                i = position;
            } else {
                j = position;
            }
            position = i + (j - i) / 2;
        }
        nums.add(position, num);
    }
}