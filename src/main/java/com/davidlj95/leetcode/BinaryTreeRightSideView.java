package com.davidlj95.leetcode;

import com.davidlj95.leetcode.structures.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class BinaryTreeRightSideView {
    public static List<Integer> rightSideView(TreeNode root) {
        if (root == null) return List.of();
        var values = new ArrayList<Integer>();
        var nodes = List.of(root);
        while (!nodes.isEmpty()) {
            values.add(nodes.get(nodes.size() - 1).val);
            nodes = nodes.stream()
                    .map(node -> Arrays.asList(node.left, node.right))
                    .flatMap(List::stream)
                    .filter(Objects::nonNull)
                    .toList();
        }
        return values;
    }
}
