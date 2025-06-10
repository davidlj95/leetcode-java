package com.davidlj95.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.FieldSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NearestExitFromEntranceInMazeTest {
    @SuppressWarnings("unused")
    static final TestCase[] TEST_CASES = {
            new TestCase(new char[][]{new char[]{'+', '+', '.', '+'}, new char[]{'.', '.', '.', '+'}, new char[]{'+', '+', '+', '.'}}, new int[]{1, 2}, 1),
            new TestCase(new char[][]{new char[]{'+', '.'}}, new int[]{0, 1}, -1),
            new TestCase(new char[][]{new char[]{'+', '.', '+', '+', '+', '+', '+'}, new char[]{'+', '.', '+', '.', '.', '.', '+'}, new char[]{'+', '.', '+', '.', '+', '.', '+'}, new char[]{'+', '.', '.', '.', '+', '.', '+'}, new char[]{'+', '+', '+', '+', '+', '+', '.'}}, new int[]{0, 1}, -1),
            new TestCase(new char[][]{new char[]{'+', '.', '+', '+', '+', '+', '+'}, new char[]{'+', '.', '+', '.', '.', '.', '+'}, new char[]{'+', '.', '+', '.', '+', '.', '+'}, new char[]{'+', '.', '.', '.', '.', '.', '+'}, new char[]{'+', '+', '+', '+', '.', '+', '.'}}, new int[]{0, 1}, 7)
    };

    @ParameterizedTest()
    @FieldSource("TEST_CASES")
    void nearestExit(TestCase testCase) {
        assertEquals(testCase.expected, NearestExitFromEntranceInMaze.nearestExit(testCase.maze, testCase.entrance));
    }

    record TestCase(char[][] maze, int[] entrance, int expected) {
    }
}