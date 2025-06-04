package com.davidlj95.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.FieldSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumNumberOfVowelsInSubstringOfGivenLengthTest {
    @SuppressWarnings("unused")
    static final TestCase[] TEST_CASES = {
            new TestCase("abciiidef", 3, 3),
            new TestCase("aeiou", 2, 2),
            new TestCase("leetcode", 3, 2),
    };

    @ParameterizedTest
    @FieldSource("TEST_CASES")
    void loopKThenMoveWindow(TestCase testCase) {
        assertEquals(testCase.expected, MaximumNumberOfVowelsInSubstringOfGivenLength.loopKThenMoveWindow(testCase.input, testCase.k));
    }

    @ParameterizedTest
    @FieldSource("TEST_CASES")
    void optimized(TestCase testCase) {
        assertEquals(testCase.expected, MaximumNumberOfVowelsInSubstringOfGivenLength.optimized(testCase.input, testCase.k));
    }

    record TestCase(String input, int k, int expected) {
    }
}