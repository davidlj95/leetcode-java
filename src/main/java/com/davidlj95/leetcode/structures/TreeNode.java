package com.davidlj95.leetcode.structures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    @SuppressWarnings("unused")
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

    public static TreeNode fromIntCollection(Collection<Integer> vals) {
        if (vals.isEmpty()) return null;
        var size = vals.size();
        var nodes = vals.stream().map(x -> x != null ? new TreeNode(x) : null).toList();
        for (var i = 0; i < size; i++) {
            var node = nodes.get(i);
            if (node == null) continue;
            var childIndex = 2 * i + 1;
            if (childIndex < size) {
                node.left = nodes.get(childIndex);
            }
            childIndex++;
            if (childIndex < size) {
                node.right = nodes.get(childIndex);
            }
        }
        return nodes.get(0);
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
        return this.toIntCollection().toString();
    }

    public Collection<Integer> toIntCollection() {
        var ints = new ArrayList<Integer>();
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(this);
        var nodesToProcess = 1;
        while (nodesToProcess > 0) {
            var node = nodes.poll();
            if (node == null) {
                ints.add(null);
                nodes.offer(null);
                nodes.offer(null);
                continue;
            }
            ints.add(node.val);
            nodesToProcess--;

            nodes.add(node.left);
            if (node.left != null) nodesToProcess++;

            nodes.add(node.right);
            if (node.right != null) nodesToProcess++;
        }

        for (var i = ints.size() - 1; i >= 0; i--) {
            if (ints.get(i) != null) {
                ints.subList(i + 1, ints.size()).clear();
                break;
            }
        }
        return ints;
    }
}
