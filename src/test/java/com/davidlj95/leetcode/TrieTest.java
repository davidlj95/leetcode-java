package com.davidlj95.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TrieTest {
    @Test
    void case1BasicUse() {
        var trie = new Trie();

        trie.insert("apple");
        assertTrue(trie.search("apple"));
        assertFalse(trie.search("app"));
        assertTrue(trie.startsWith("app"));

        trie.insert("app");
        assertTrue(trie.search("app"));
    }

    @Test
    void whenDoesNotStartWith() {
        var trie = new Trie();
        trie.insert("apple");
        assertFalse(trie.startsWith("foo"));
    }

    @Test
    void whenWordHasZ() {
        var trie = new Trie();
        trie.insert("z");
    }
}