package com.davidlj95.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

// https://leetcode.com/problems/find-the-difference-of-two-arrays/ (2215)
public class FindDifferenceTwoArrays {
    public static List<List<Integer>> findDifferences(int[] nums1, int[] nums2) {
        return setAndDifferences(nums1, nums2);
    }

    public static List<List<Integer>> setAndDifferences(int[] nums1, int[] nums2) {
        var nums1Set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        var nums2Set = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        var numsIn1NotPresentIn2 = nums1Set.stream().filter(x -> !nums2Set.contains(x)).toList();
        var numsIn2NotPresentIn1 = nums2Set.stream().filter(x -> !nums1Set.contains(x)).toList();
        return List.of(numsIn1NotPresentIn2, numsIn2NotPresentIn1);
    }

    public static List<List<Integer>> optimized(int[] nums1, int[] nums2) {
        var nums2Set = new HashSet<Integer>();
        for (int i : nums2) {
            nums2Set.add(i);
        }
        var nums1Set = new HashSet<Integer>();
        var seenNums1 = new HashSet<Integer>();
        for (int i : nums1) {
            if (seenNums1.contains(i)) {
                continue;
            }

            if (nums2Set.contains(i)) {
                nums2Set.remove(i);
                seenNums1.add(i);
            } else {
                nums1Set.add(i);
            }
        }
        return List.of(new ArrayList<>(nums1Set), new ArrayList<>(nums2Set));
    }
}
