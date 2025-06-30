package com.davidlj95.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.FieldSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseWordsInAStringTest {
    @SuppressWarnings("unused")
    static final TestCase[] TEST_CASES = {
            new TestCase("the sky is blue", "blue is sky the"),
            new TestCase("  hello world  ", "world hello"),
            new TestCase("a good    example", "example good a")
    };

    @ParameterizedTest
    @FieldSource("TEST_CASES")
    void trimSeparateAndBuild(TestCase testCase) {
        assertEquals(testCase.expected, ReverseWordsInAString.trimSeparateAndBuild(testCase.input));
    }

    @ParameterizedTest
    @FieldSource("TEST_CASES")
    void loopAndPrepend(TestCase testCase) {
        assertEquals(testCase.expected, ReverseWordsInAString.loopAndPrepend(testCase.input));
    }

    record TestCase(String input, String expected) {
    }

}