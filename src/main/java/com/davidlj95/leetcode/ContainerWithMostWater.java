package com.davidlj95.leetcode;

public class ContainerWithMostWater {
    @SuppressWarnings("unused")
    public static int maxArea(int[] height) {
        return smartPointerMove(height);
    }

    // Initial approach. Time Limit Exceeded error. 58 / 65 test cases.
    public static int bruteForce(int[] height) {
        var maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = height.length - 1; i < j; j--) {
                var area = (j - i) * Math.min(height[i], height[j]);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

    // Works. 5ms. Beats 75.31%; Mem 57.91 MB. Beats 54.91%.
    public static int smartPointerMove(int[] height) {
        var maxArea = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            var area = (j - i) * Math.min(height[i], height[j]);
            maxArea = Math.max(maxArea, area);
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return maxArea;
    }

    // After looking at fastest @ LeetCode. Didn't include JIT warmup ones.
    public static int optimized(int[] height) {
        int maxArea = 0, left = 0, right = height.length - 1;
        while (left < right) {
            var minHeight = Math.min(height[left], height[right]);
            var area = (right - left) * minHeight;
            if (area > maxArea) maxArea = area;
            if (height[left] < height[right]) {
                while (left < right && height[left] <= minHeight) left++;
            } else {
                while (left < right && height[right] <= minHeight) right--;
            }
        }
        return maxArea;
    }
}
