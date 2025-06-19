package com.davidlj95.leetcode;


import com.davidlj95.leetcode.structures.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.FieldSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeleteNodeInABSTTest {
    @SuppressWarnings("unused")
    static final TestCase[] TEST_CASES = {
            new TestCase(
                    new TreeNode(5,
                            new TreeNode(3,
                                    new TreeNode(2),
                                    new TreeNode(4)
                            ),
                            new TreeNode(6, null, new TreeNode(7))
                    ),
                    3,
                    new TreeNode(5,
                            new TreeNode(2, null, new TreeNode(4)),
                            new TreeNode(6, null, new TreeNode(7))
                    )
            )
    };

    @ParameterizedTest
    @FieldSource("TEST_CASES")
    void deleteNode(TestCase testCase) {
        assertEquals(testCase.expected, DeleteNodeInABST.deleteNode(testCase.root, testCase.key));
    }

    record TestCase(TreeNode root, int key, TreeNode expected) {
    }

}