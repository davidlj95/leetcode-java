package com.davidlj95.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.FieldSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfRecentCallsTest {
    @SuppressWarnings("unused")
    static final TestCase[] TEST_CASES = {
            new TestCase(new int[]{1, 100, 3001, 3002}, new int[]{1, 2, 3, 3}),
    };

    @ParameterizedTest
    @FieldSource("TEST_CASES")
    void numberOfRecentCalls(TestCase testCase) {
        var counter = new NumberOfRecentCalls.RecentCounter();
        for (var i = 0; i < testCase.t.length; i++) {
            var t = testCase.t[i];
            var expected = testCase.expected[i];
            assertEquals(expected, counter.ping(t));
        }
    }

    record TestCase(int[] t, int[] expected) {
    }
}