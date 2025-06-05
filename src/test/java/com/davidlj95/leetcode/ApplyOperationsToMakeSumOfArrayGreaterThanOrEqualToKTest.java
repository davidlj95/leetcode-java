package com.davidlj95.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.FieldSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplyOperationsToMakeSumOfArrayGreaterThanOrEqualToKTest {
    @SuppressWarnings("unused")
    static final TestCase[] TEST_CASES = {
            new TestCase(11, 5),
            new TestCase(1, 0),
            new TestCase(2, 1),
            new TestCase(3, 2),
            new TestCase(4, 2),
            new TestCase(8, 4),
    };


    @ParameterizedTest
    @FieldSource("TEST_CASES")
    void kComplexity(TestCase testCase) {
        assertEquals(testCase.expected, ApplyOperationsToMakeSumOfArrayGreaterThanOrEqualToK.kComplexity(testCase.k));
    }

    @ParameterizedTest
    @FieldSource("TEST_CASES")
    void constantComplexity(TestCase testCase) {
        assertEquals(testCase.expected, ApplyOperationsToMakeSumOfArrayGreaterThanOrEqualToK.constantComplexity(testCase.k));
    }

    @ParameterizedTest
    @FieldSource("TEST_CASES")
    void constantChatGpt(TestCase testCase) {
        assertEquals(testCase.expected, ApplyOperationsToMakeSumOfArrayGreaterThanOrEqualToK.constantChatGpt(testCase.k));
    }

    record TestCase(int k, int expected) {
    }
}