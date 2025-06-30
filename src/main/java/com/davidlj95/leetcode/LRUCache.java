package com.davidlj95.leetcode;

import java.util.HashMap;

// https://leetcode.com/problems/lru-cache/ (146)
public class LRUCache {
    final HashMap<Integer, Node> nodeByKey = new HashMap<>();
    final int capacity;
    final Node oldest = new Node();
    final Node latest = new Node();

    LRUCache(int capacity) {
        this.capacity = capacity;
        oldest.next = latest;
        latest.prev = oldest;
    }

    public int get(int key) {
        var node = nodeByKey.get(key);
        if (node == null) return -1;
        node.remove();
        node.insert();
        return node.value;
    }

    public void put(int key, int value) {
        var existingNode = nodeByKey.get(key);
        if (existingNode != null) {
            existingNode.remove();
        }
        var node = new Node(key, value);
        nodeByKey.put(key, node);
        node.insert();
        if (nodeByKey.size() > capacity) {
            var lru = oldest.next;
            lru.remove();
            nodeByKey.remove(lru.key);
        }
    }

    class Node {
        final int key;
        final int value;
        Node next;
        Node prev;

        Node() {
            this(0, 0);
        }

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        void insert() {
            var prev = latest.prev;
            var next = latest;
            prev.next = next.prev = this;
            this.next = next;
            this.prev = prev;
        }

        void remove() {
            prev.next = next;
            next.prev = prev;
        }
    }
}
