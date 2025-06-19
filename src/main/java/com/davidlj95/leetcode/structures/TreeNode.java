package com.davidlj95.leetcode.structures;

import java.util.ArrayList;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
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

    @Override
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
