package com.davidlj95.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.FieldSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class FindDifferenceTwoArraysTest {
    @SuppressWarnings("unused")
    static final TestCase[] TEST_CASES = {
            new TestCase(new int[]{1, 2, 3}, new int[]{2, 4, 6}, List.of(List.of(1, 3), List.of(4, 6))),
            new TestCase(new int[]{1, 2, 3, 3}, new int[]{1, 1, 2, 2}, List.of(List.of(3), List.of())),
    };

    @ParameterizedTest
    @FieldSource("TEST_CASES")
    void setAndDifference(TestCase testCase) {
        assertIterableEquals(
                testCase.expected,
                FindDifferenceTwoArrays.setAndDifferences(testCase.nums1, testCase.nums2)
        );
    }

    @ParameterizedTest
    @FieldSource("TEST_CASES")
    void optimized(TestCase testCase) {
        assertIterableEquals(
                testCase.expected,
                FindDifferenceTwoArrays.optimized(testCase.nums1, testCase.nums2)
        );
    }

    record TestCase(int[] nums1, int[] nums2, List<List<Integer>> expected) {
    }
}