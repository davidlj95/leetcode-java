package com.davidlj95.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.FieldSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KidsWithGreatestNumberOfCandiesTest {
    @SuppressWarnings({"unused"})
    static final TestCase[] TEST_CASES = {
            new TestCase(new int[]{2, 3, 5, 1, 3}, 3, List.of(true, true, true, false, true)),
            new TestCase(new int[]{4, 2, 1, 1, 2}, 1, List.of(true, false, false, false, false)),
            new TestCase(new int[]{12, 1, 12}, 10, List.of(true, false, true)),
    };

    @ParameterizedTest
    @FieldSource("TEST_CASES")
    void kidsWithCandies(TestCase testCase) {
        assertEquals(testCase.expected, KidsWithGreatestNumberOfCandies.streamy(testCase.candies, testCase.extraCandies));
    }

    @ParameterizedTest
    @FieldSource("TEST_CASES")
    void oldFashionButMorePerformant(TestCase testCase) {
        assertEquals(testCase.expected, KidsWithGreatestNumberOfCandies.oldFashionButMorePerformant(testCase.candies, testCase.extraCandies));
    }

    record TestCase(int[] candies, int extraCandies, List<Boolean> expected) {
    }
}