package com.davidlj95.leetcode;


import com.davidlj95.leetcode.structures.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.FieldSource;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeleteNodeInABSTTest {
    @SuppressWarnings("unused")
    static final TestCase[] TEST_CASES = {
            new TestCase(
                    Arrays.asList(5, 3, 6, 2, 4, null, 7),
                    3,
                    Arrays.asList(5, 2, 6, null, 4, null, 7)
            )
    };

    @ParameterizedTest
    @FieldSource("TEST_CASES")
    void deleteNode(TestCase testCase) {
        assertEquals(
                TreeNode.fromIntCollection(testCase.expected), DeleteNodeInABST.deleteNode(
                        TreeNode.fromIntCollection(testCase.root), testCase.key));
    }

    record TestCase(Collection<Integer> root, int key, Collection<Integer> expected) {
    }

}