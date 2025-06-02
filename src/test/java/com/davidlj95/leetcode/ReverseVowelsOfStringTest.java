package com.davidlj95.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.FieldSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseVowelsOfStringTest {
    static final TestCase[] TEST_CASES = {
            new TestCase("IceCreAm", "AceCreIm"),
            new TestCase("leetcode", "leotcede"),
    };

    @ParameterizedTest
    @FieldSource("TEST_CASES")
    void reverseVowels(TestCase testCase) {
        assertEquals(testCase.expected, ReverseVowelsOfString.reverseVowels(testCase.str));
    }

    record TestCase(String str, String expected) {
    }
}