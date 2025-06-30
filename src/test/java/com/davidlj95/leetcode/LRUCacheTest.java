package com.davidlj95.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LRUCacheTest {
    @Test
    void case_1() {
        var lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);

        assertEquals(1, lruCache.get(1));

        lruCache.put(3, 3);

        assertEquals(-1, lruCache.get(2));

        lruCache.put(4, 4);

        assertEquals(-1, lruCache.get(1));
        assertEquals(3, lruCache.get(3));
        assertEquals(4, lruCache.get(4));
    }

    @Test
    void case_16() {
        var lruCache = new LRUCache(2);
        lruCache.put(2, 1);
        lruCache.put(1, 1);
        lruCache.put(2, 3);
        lruCache.put(4, 1);

        assertEquals(-1, lruCache.get(1));
        assertEquals(3, lruCache.get(2));
    }
}