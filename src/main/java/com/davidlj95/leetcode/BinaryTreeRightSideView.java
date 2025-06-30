package com.davidlj95.leetcode;

import com.davidlj95.leetcode.structures.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

// https://leetcode.com/problems/binary-tree-right-side-view/ (199)
public class BinaryTreeRightSideView {
    @SuppressWarnings("unused")
    public static List<Integer> rightSideView(TreeNode root) {
        return withClassicApis(root);
    }

    public static List<Integer> withStreamApis(TreeNode root) {
        if (root == null) return List.of();
        var values = new ArrayList<Integer>();
        var nodes = List.of(root);
        while (!nodes.isEmpty()) {
            values.add(nodes.get(nodes.size() - 1).val);
            nodes = nodes.stream()
                    .flatMap(node -> Stream.of(node.left, node.right).filter(Objects::nonNull))
                    .toList();
        }
        return values;
    }

    public static List<Integer> withClassicApis(TreeNode root) {
        if (root == null) return List.of();
        var values = new ArrayList<Integer>();
        var nodes = new LinkedList<TreeNode>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            values.add(nodes.get(nodes.size() - 1).val);
            var children = new LinkedList<TreeNode>();
            for (var node : nodes) {
                if (node.left != null) children.add(node.left);
                if (node.right != null) children.add(node.right);
            }
            nodes = children;
        }
        return values;
    }
}
