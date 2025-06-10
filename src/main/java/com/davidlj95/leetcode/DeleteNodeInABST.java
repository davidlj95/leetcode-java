package com.davidlj95.leetcode;

import java.util.ArrayList;

public class DeleteNodeInABST {
    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
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

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (!(obj instanceof TreeNode other)) return false;
            return val == other.val && ((left != null && left.equals(other.left)) || (left == null && other.left == null)) && ((right != null && right.equals(other.right)) || (right == null && other.right == null));
        }

        @Override
        public int hashCode() {
            return this.val + (this.left != null ? this.left.hashCode() : 0) + (this.right != null ? this.right.hashCode() : 0);
        }

        public String toString() {
            var values = new ArrayList<Integer>();
            var toVisit = new ArrayList<TreeNode>();
            toVisit.add(this);
            while (!toVisit.isEmpty()) {
                var node = toVisit.remove(0);
                if (node == null) {
                    values.add(null);
                    continue;
                }
                values.add(node.val);
                toVisit.add(node.left);
                toVisit.add(node.right);
            }
            while (values.get(values.size() - 1) == null) {
                values.remove(values.size() - 1);
            }
            return values.toString();
        }
    }
}
