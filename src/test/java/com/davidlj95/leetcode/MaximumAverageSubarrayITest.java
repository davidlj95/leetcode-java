package com.davidlj95.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.FieldSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumAverageSubarrayITest {
    @SuppressWarnings("unused")
    static final TestCase[] TEST_CASES = {
            new TestCase(new int[]{1, 12, -5, -6, 50, 3}, 4, 12.75),
            new TestCase(new int[]{5}, 1, 5),
            new TestCase(new int[]{4, 2, 1, 3, 3}, 2, 3),
    };


    @ParameterizedTest
    @FieldSource("TEST_CASES")
    void bruteForce(TestCase testCase) {
        assertEquals(testCase.expected, MaximumAverageSubarrayI.bruteForce(testCase.nums, testCase.k));
    }

    @ParameterizedTest
    @FieldSource("TEST_CASES")
    void sumOnce(TestCase testCase) {
        assertEquals(testCase.expected, MaximumAverageSubarrayI.sumOnce(testCase.nums, testCase.k));
    }

    record TestCase(int[] nums, int k, double expected) {
    }
}