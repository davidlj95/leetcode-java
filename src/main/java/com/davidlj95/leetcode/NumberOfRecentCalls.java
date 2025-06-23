package com.davidlj95.leetcode;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/number-of-recent-calls/ (933)
public class NumberOfRecentCalls {
    static class RecentCounter {
        static final int THRESHOLD = 3000;
        final Queue<Integer> requests = new LinkedList<>();

        public int ping(int t) {
            requests.offer(t);
            var startRange = t - THRESHOLD;
            while (!requests.isEmpty() && requests.peek() < startRange) {
                requests.poll();
            }
            return requests.size();
        }
    }
}
