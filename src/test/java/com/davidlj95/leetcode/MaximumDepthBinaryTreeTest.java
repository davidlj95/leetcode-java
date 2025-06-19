package com.davidlj95.leetcode;

import com.davidlj95.leetcode.structures.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.FieldSource;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumDepthBinaryTreeTest {
    @SuppressWarnings("unused")
    static final TestCase[] TEST_CASES = {
            new TestCase(Arrays.asList(3, 9, 20, null, null, 15, 7), 3),
            new TestCase(Arrays.asList(1, null, 2), 2),
    };

    @ParameterizedTest
    @FieldSource("TEST_CASES")
    void maxDepth(TestCase testCase) {
        assertEquals(testCase.expected, MaximumDepthBinaryTree.maxDepth(TreeNode.fromIntCollection(testCase.root)));
    }

    record TestCase(Collection<Integer> root, int expected) {
    }
}