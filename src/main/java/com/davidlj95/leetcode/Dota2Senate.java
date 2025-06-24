package com.davidlj95.leetcode;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/dota2-senate/ (649)
public class Dota2Senate {
    public static String predictPartyVictory(String senate) {
        return doubleQueue(senate);
    }

    public static String doubleQueue(String senate) {
        Queue<Integer> radiants = new LinkedList<>();
        Queue<Integer> dires = new LinkedList<>();
        var n = senate.length();
        for (var i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                radiants.offer(i);
            } else {
                dires.offer(i);
            }
        }
        while (!radiants.isEmpty() && !dires.isEmpty()) {
            var radiant = radiants.poll();
            var dire = dires.poll();
            //noinspection DataFlowIssue
            if (dire < radiant) {
                dires.offer(dire + n);
            } else {
                radiants.offer(radiant + n);
            }
        }
        return radiants.isEmpty() ? "Dire" : "Radiant";
    }
}
