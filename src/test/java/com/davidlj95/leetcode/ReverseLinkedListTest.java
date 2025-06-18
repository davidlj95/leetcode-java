package com.davidlj95.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.FieldSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseLinkedListTest {
    @SuppressWarnings("unused")
    static final TestCase[] TEST_CASES = {
            new TestCase(new int[]{1, 2, 3, 4, 5}, new int[]{5, 4, 3, 2, 1}),
            new TestCase(new int[]{1, 2}, new int[]{2, 1}),
            new TestCase(new int[]{}, new int[]{}),
    };

    @ParameterizedTest
    @FieldSource("TEST_CASES")
    void reverseList(TestCase testCase) {
        assertEquals(ReverseLinkedList.ListNode.fromIntArray(testCase.expected), ReverseLinkedList.reverseList(ReverseLinkedList.ListNode.fromIntArray(testCase.input)));
    }

    record TestCase(int[] input, int[] expected) {
    }
}