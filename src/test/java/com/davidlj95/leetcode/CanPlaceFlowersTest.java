package com.davidlj95.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.FieldSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CanPlaceFlowersTest {
    @SuppressWarnings("unused")
    static final TestCase[] TEST_CASES = {
            new TestCase(new int[]{1, 0, 0, 0, 1}, 1, true),
            new TestCase(new int[]{1, 0, 0, 0, 1}, 2, false),
            new TestCase(new int[]{1, 0, 0, 0, 0, 1}, 2, false),
            new TestCase(new int[]{0, 0, 1, 0, 1}, 1, true),
            new TestCase(new int[]{1, 0, 0, 0, 1, 0, 0}, 2, true)
    };

    @ParameterizedTest
    @FieldSource("TEST_CASES")
    void canPlaceFlowers(TestCase testCase) {
        assertEquals(testCase.expected(), CanPlaceFlowers.canPlaceFlowers(testCase.flowerbed, testCase.n));
    }

    record TestCase(int[] flowerbed, int n, boolean expected) {
    }
}