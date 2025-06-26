package com.davidlj95.leetcode;

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// https://leetcode.com/problems/implement-trie-prefix-tree/ (208)
class Trie {
    final Trie[] children = new Trie['z' - 'a' + 1];
    boolean endOfWord = false;

    public Trie() {
    }

    public void insert(String word) {
        if (word.isEmpty()) {
            this.endOfWord = true;
            return;
        }
        var childIndex = word.charAt(0) - 'a';
        var node = children[childIndex];
        if (node == null) {
            node = new Trie();
            children[childIndex] = node;
        }
        node.insert(word.substring(1));
    }

    public boolean search(String word) {
        if (word.isEmpty()) return endOfWord;
        var childIndex = word.charAt(0) - 'a';
        var node = children[childIndex];
        if (node == null) return false;
        return node.search(word.substring(1));
    }

    public boolean startsWith(String prefix) {
        if (prefix.isEmpty()) return true;
        var childIndex = prefix.charAt(0) - 'a';
        var node = children[childIndex];
        if (node == null) return false;
        return node.startsWith(prefix.substring(1));
    }
}
