package com.davidlj95.leetcode;

import com.davidlj95.leetcode.structures.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.FieldSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeleteMiddleNodeOfLinkedListTest {
    @SuppressWarnings("unused")
    static final TestCase[] TEST_CASES = {
            new TestCase(new int[]{1, 3, 4, 7, 1, 2, 6}, new int[]{1, 3, 4, 1, 2, 6}),
            new TestCase(new int[]{1, 2, 3, 4}, new int[]{1, 2, 4}),
            new TestCase(new int[]{2, 1}, new int[]{2}),
            new TestCase(new int[]{}, new int[]{}),
            new TestCase(new int[]{1}, new int[]{}),
    };

    @ParameterizedTest
    @FieldSource("TEST_CASES")
    void byMovingMidParent(TestCase testCase) {
        assertEquals(ListNode.fromIntArray(testCase.expected), DeleteMiddleNodeOfLinkedList.byMovingMidParent(ListNode.fromIntArray(testCase.input)));
    }

    @ParameterizedTest
    @FieldSource("TEST_CASES")
    void bySlowAndFastPointers(TestCase testCase) {
        assertEquals(ListNode.fromIntArray(testCase.expected), DeleteMiddleNodeOfLinkedList.bySlowAndFastPointers(ListNode.fromIntArray(testCase.input)));
    }

    record TestCase(int[] input, int[] expected) {
    }
}