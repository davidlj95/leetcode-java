package com.davidlj95.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.FieldSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContainerWithMostWaterTest {
    @SuppressWarnings("unused")
    static final TestCase[] TEST_CASES = {
            new TestCase(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49),
            new TestCase(new int[]{1, 1}, 1)
    };

    @ParameterizedTest
    @FieldSource("TEST_CASES")
    void bruteForce(TestCase testCase) {
        assertEquals(testCase.expected, ContainerWithMostWater.bruteForce(testCase.height));
    }

    @ParameterizedTest
    @FieldSource("TEST_CASES")
    void smartPointerMove(TestCase testCase) {
        assertEquals(testCase.expected, ContainerWithMostWater.smartPointerMove(testCase.height));
    }

    @ParameterizedTest
    @FieldSource("TEST_CASES")
    void optimized(TestCase testCase) {
        assertEquals(testCase.expected, ContainerWithMostWater.optimized(testCase.height));
    }

    record TestCase(int[] height, int expected) {
    }
}