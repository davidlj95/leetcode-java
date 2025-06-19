package com.davidlj95.leetcode.structures;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.FieldSource;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TreeNodeTest {
    @SuppressWarnings("unused")
    static final TreeAsArray[] TREES_AS_ARRAYS = {
            new TreeAsArray(List.of(), null),
            new TreeAsArray(List.of(1), new TreeNode(1)),
            new TreeAsArray(List.of(1, 2), new TreeNode(1, new TreeNode(2), null)),
            new TreeAsArray(List.of(1, 2, 3), new TreeNode(1, new TreeNode(2), new TreeNode(3))),
            new TreeAsArray(List.of(1, 2, 3, 4), new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3))),
            new TreeAsArray(List.of(1, 2, 3, 4, 5, 6, 7), new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)))),
            new TreeAsArray(Arrays.asList(1, 2, 3, null, 5, null, 7), new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3, null, new TreeNode(7)))),
            new TreeAsArray(Arrays.asList(1, null, 3, null, null, 6, 7), new TreeNode(1, null, new TreeNode(3, new TreeNode(6), new TreeNode(7)))),
    };

    @ParameterizedTest
    @FieldSource("TREES_AS_ARRAYS")
    void fromIntArray(TreeAsArray testCase) {
        assertEquals(testCase.root, TreeNode.fromIntCollection(testCase.collection));
    }

    record TreeAsArray(Collection<Integer> collection, TreeNode root) {
    }
}