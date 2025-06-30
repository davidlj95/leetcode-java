package com.davidlj95.leetcode;

import com.davidlj95.leetcode.structures.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.FieldSource;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTreeRightSideViewTest {
    @SuppressWarnings("unused")
    static final TestCase[] TEST_CASES = {
            new TestCase(Arrays.asList(1, 2, 3, null, 5, null, 4), new int[]{1, 3, 4}),
            new TestCase(Arrays.asList(1, 2, 3, 4, null, null, null, 5), new int[]{1, 3, 4, 5}),
            new TestCase(Arrays.asList(1, null, 3), new int[]{1, 3}),
            new TestCase(List.of(), new int[]{}),
    };

    @ParameterizedTest
    @FieldSource("TEST_CASES")
    void withStreamApis(TestCase testCase) {
        assertEquals(Arrays.stream(testCase.expected).boxed().toList(), BinaryTreeRightSideView.withStreamApis(TreeNode.fromIntCollection(testCase.input)));
    }

    @ParameterizedTest
    @FieldSource("TEST_CASES")
    void withClassicApis(TestCase testCase) {
        assertEquals(Arrays.stream(testCase.expected).boxed().toList(), BinaryTreeRightSideView.withClassicApis(TreeNode.fromIntCollection(testCase.input)));
    }

    @ParameterizedTest
    @FieldSource("TEST_CASES")
    void withRecursion(TestCase testCase) {
        assertEquals(Arrays.stream(testCase.expected).boxed().toList(), BinaryTreeRightSideView.withRecursion(TreeNode.fromIntCollection(testCase.input)));
    }

    record TestCase(Collection<Integer> input, int[] expected) {
    }

}