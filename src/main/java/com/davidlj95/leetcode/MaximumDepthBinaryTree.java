package com.davidlj95.leetcode;

import com.davidlj95.leetcode.structures.TreeNode;

public class MaximumDepthBinaryTree {
    public static int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
    }
}


