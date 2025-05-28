package com.davidlj95.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.FieldSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MergeStringsAlternatelyTest {
    @SuppressWarnings({"unused", "SpellCheckingInspection"})
    static final TestCase[] TEST_CASES = {
            new TestCase("abc", "pqr", "apbqcr"),
            new TestCase("ab", "pqrs", "apbqrs"),
            new TestCase("abcd", "pq", "apbqcd"),
    };

    @ParameterizedTest
    @FieldSource("TEST_CASES")
    void byLoopAndCheck(TestCase testCase) {
        assertEquals(MergeStringsAlternately.byLoopAndCheck(testCase.word1(), testCase.word2()), testCase.expected());
    }

    @ParameterizedTest
    @FieldSource("TEST_CASES")
    void commonAndThenRest(TestCase testCase) {
        assertEquals(MergeStringsAlternately.commonAndThenRest(testCase.word1(), testCase.word2()), testCase.expected());
    }

    record TestCase(String word1, String word2, String expected) {
    }
}

