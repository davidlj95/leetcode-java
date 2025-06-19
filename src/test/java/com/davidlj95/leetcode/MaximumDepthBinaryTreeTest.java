package com.davidlj95.leetcode;

import com.davidlj95.leetcode.structures.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.FieldSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumDepthBinaryTreeTest {
    @SuppressWarnings("unused")
    static final TestCase[] TEST_CASES = {
            new TestCase(
                    new TreeNode(3,
                            new TreeNode(9),
                            new TreeNode(20,
                                    new TreeNode(15),
                                    new TreeNode(7)
                            )), 3),
            new TestCase(
                    new TreeNode(1,
                            new TreeNode(),
                            new TreeNode(2)
                    ),
                    2
            )
    };

    @ParameterizedTest
    @FieldSource("TEST_CASES")
    void maxDepth(TestCase testCase) {
        assertEquals(testCase.expected, MaximumDepthBinaryTree.maxDepth(testCase.root));
    }

    record TestCase(TreeNode root, int expected) {
    }
}