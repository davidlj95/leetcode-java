package com.davidlj95.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.FieldSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KthLargestElementArrayTest {
    @SuppressWarnings("unused")
    static final TestCase[] TEST_CASES = {
            new TestCase(new int[]{3, 2, 1, 5, 6, 4}, 2, 5),
            new TestCase(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4, 4),
            new TestCase(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6, 7, 7, 8, 2, 3, 1, 1, 1, 10, 11, 5, 6, 2, 4, 7, 8, 5, 6}, 20, 2),
    };

    @ParameterizedTest
    @FieldSource("TEST_CASES")
    void findKthLargest(TestCase testCase) {
        assertEquals(testCase.expected, KthLargestElementArray.findKthLargest(testCase.nums, testCase.k));
    }

    record TestCase(int[] nums, int k, int expected) {
    }
}