package com.davidlj95.leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/move-zeroes/submissions/1652058204/ (283)
public class MoveZeroes {
    @SuppressWarnings("unused")
    public static void moveZeroes(int[] nums) {
        optimal(nums);
    }

    public static void spaceSuboptimal(int[] nums) {
        var notZeroes = Arrays.stream(nums).filter(n -> n != 0).toArray();
        System.arraycopy(notZeroes, 0, nums, 0, notZeroes.length);
        Arrays.fill(nums, notZeroes.length, nums.length, 0);
    }

    public static void spaceOptimalOperationSuboptimal(int[] nums) {
        var zeroes = 0;
        for (var i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroes++;
            } else {
                nums[i - zeroes] = nums[i];
            }
        }
        for (var i = nums.length - zeroes; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void optimal(int[] nums) {
        var lastNonZeroElement = 0;
        for (var i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                var tmp = nums[lastNonZeroElement];
                nums[lastNonZeroElement] = nums[i];
                nums[i] = tmp;
                lastNonZeroElement++;
            }
        }
    }
}
