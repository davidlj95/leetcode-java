package com.davidlj95.leetcode;

// https://leetcode.com/problems/maximum-average-subarray-i/ (643)
public class MaximumAverageSubarrayI {
    @SuppressWarnings("unused")
    public static double findMaxAverage(int[] nums, int k) {
        return sumOnce(nums, k);
    }

    // First iteration
    public static double bruteForce(int[] nums, int k) {
        var maxAverage = -Double.MAX_VALUE;
        for (int i = 0; i + k <= nums.length; i++) {
            var sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += nums[j];
            }
            var average = (double) sum / k;
            if (average > maxAverage) {
                maxAverage = average;
            }
        }
        return maxAverage;
    }

    // Optimization
    public static double sumOnce(int[] nums, int k) {
        var maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += nums[i];
        }
        var sum = maxSum;
        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i - k] + nums[i];
            if (sum > maxSum) maxSum = sum;
        }
        return (double) maxSum / k;
    }
}
