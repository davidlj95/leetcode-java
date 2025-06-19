package com.davidlj95.leetcode;

import com.davidlj95.leetcode.structures.TreeNode;

// https://leetcode.com/problems/delete-node-in-a-bst/ (450)
public class DeleteNodeInABST {
    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
            return root;
        }
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
            return root;
        }

        // Easy case: leaf
        if (root.left == null && root.right == null) return null;

        // Mid-case: one child
        if (root.left == null) return root.right;
        if (root.right == null) return root.left;

        // Hard case: two children. Pick next in order.
        // In this case, using the greatest of the left side of the tree.
        // It could also be the lowest of the right side.
        var leftGreatest = root.left;
        while (leftGreatest.right != null) {
            leftGreatest = leftGreatest.right;
        }
        leftGreatest.left = deleteNode(root.left, leftGreatest.val);
        leftGreatest.right = root.right;
        return leftGreatest;
    }
}
