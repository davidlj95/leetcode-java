package com.davidlj95.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.FieldSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumDepthBinaryTreeTest {
    @SuppressWarnings("unused")
    static final TestCase[] TEST_CASES = {
            new TestCase(
                    new MaximumDepthBinaryTree.TreeNode(3,
                            new MaximumDepthBinaryTree.TreeNode(9),
                            new MaximumDepthBinaryTree.TreeNode(20,
                                    new MaximumDepthBinaryTree.TreeNode(15),
                                    new MaximumDepthBinaryTree.TreeNode(7)
                            )), 3),
            new TestCase(
                    new MaximumDepthBinaryTree.TreeNode(1,
                            new MaximumDepthBinaryTree.TreeNode(),
                            new MaximumDepthBinaryTree.TreeNode(2)
                    ),
                    2
            )
    };

    @ParameterizedTest
    @FieldSource("TEST_CASES")
    void maxDepth(TestCase testCase) {
        assertEquals(testCase.expected, MaximumDepthBinaryTree.maxDepth(testCase.root));
    }

    record TestCase(MaximumDepthBinaryTree.TreeNode root, int expected) {
    }
}