package com.davidlj95.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.FieldSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MoveZeroesTest {
    static final TestCase[] TEST_CASES = {
            new TestCase(new int[]{0, 1, 0, 3, 12}, new int[]{1, 3, 12, 0, 0}),
            new TestCase(new int[]{0}, new int[]{0}),
            new TestCase(new int[]{0, 0, 1}, new int[]{1, 0, 0})
    };

    @ParameterizedTest
    @FieldSource("TEST_CASES")
    void spaceSuboptimal(TestCase testCase) {
        var nums = testCase.nums.clone();
        MoveZeroes.spaceSuboptimal(nums);
        assertArrayEquals(testCase.expected, nums);
    }

    @ParameterizedTest
    @FieldSource("TEST_CASES")
    void spaceOptimalOperationSuboptimal(TestCase testCase) {
        var nums = testCase.nums.clone();
        MoveZeroes.spaceOptimalOperationSuboptimal(nums);
        assertArrayEquals(testCase.expected, nums);
    }

    @ParameterizedTest
    @FieldSource("TEST_CASES")
    void optimal(TestCase testCase) {
        var nums = testCase.nums.clone();
        MoveZeroes.optimal(nums);
        assertArrayEquals(testCase.expected, nums);
    }

    record TestCase(int[] nums, int[] expected) {

    }
}