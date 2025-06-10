package com.davidlj95.leetcode;

import java.util.LinkedList;

public class NearestExitFromEntranceInMaze {
    public static int nearestExit(char[][] maze, int[] entrance) {
        var m = maze.length;
        var n = maze[0].length;

        var nextPositions = new LinkedList<int[]>();
        nextPositions.offer(entrance);
        maze[entrance[0]][entrance[1]] = '+';
        var directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        var steps = 0;
        while (!nextPositions.isEmpty()) {
            steps++;
            var options = nextPositions.size();
            for (int i = 0; i < options; i++) {
                var position = nextPositions.poll();
                for (var direction : directions) {
                    @SuppressWarnings("DataFlowIssue") var x = position[0] + direction[0];
                    var y = position[1] + direction[1];

                    // Discard when can't move there
                    if (x < 0 || x >= m || y < 0 || y >= n || maze[x][y] != '.') continue;

                    // Arrived to the exit!
                    if (x == 0 || x == m - 1 || y == 0 || y == n - 1) return steps;

                    maze[x][y] = '+';
                    nextPositions.offer(new int[]{x, y});
                }
            }
        }
        return -1;
    }
}
