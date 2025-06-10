package com.davidlj95.leetcode;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.FieldSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeleteNodeInABSTTest {
    @SuppressWarnings("unused")
    static final TestCase[] TEST_CASES = {
            new TestCase(
                    new DeleteNodeInABST.TreeNode(5,
                            new DeleteNodeInABST.TreeNode(3,
                                    new DeleteNodeInABST.TreeNode(2),
                                    new DeleteNodeInABST.TreeNode(4)
                            ),
                            new DeleteNodeInABST.TreeNode(6, null, new DeleteNodeInABST.TreeNode(7))
                    ),
                    3,
                    new DeleteNodeInABST.TreeNode(5,
                            new DeleteNodeInABST.TreeNode(2, null, new DeleteNodeInABST.TreeNode(4)),
                            new DeleteNodeInABST.TreeNode(6, null, new DeleteNodeInABST.TreeNode(7))
                    )
            )
    };

    @ParameterizedTest
    @FieldSource("TEST_CASES")
    void deleteNode(TestCase testCase) {
        assertEquals(testCase.expected, DeleteNodeInABST.deleteNode(testCase.root, testCase.key));
    }

    record TestCase(DeleteNodeInABST.TreeNode root, int key, DeleteNodeInABST.TreeNode expected) {
    }

}