package com.davidlj95;

// https://leetcode.com/problems/merge-strings-alternately (1768)
public class MergeStringsAlternately {
    public static void main(String[] args) {
        System.out.println("Merge strings alternately:");
        System.out.println("=========================");
        String[][] TEST_CASES = {{"abc", "pqr"}, {"ab", "pqrs"}, {"abcd", "pq"}};
        System.out.printf("%s | %s%n", "byLoopAndCheck", "commonThenAddRest");
        for (var testCase : TEST_CASES) {
            System.out.printf(
                    "%s | %s\n",
                    MergeStringsAlternately.byLoopAndCheck(testCase[0], testCase[1]),
                    MergeStringsAlternately.commonAndThenRest(testCase[0], testCase[1])
            );
        }
    }

    public static String byLoopAndCheck(String word1, String word2) {
        var result = new StringBuilder();
        var maxLength = Math.max(word1.length(), word2.length());
        for (var i = 0; i < maxLength; i++) {
            if (i < word1.length()) {
                result.append(word1.charAt(i));
            }
            if (i < word2.length()) {
                result.append(word2.charAt(i));
            }

        }
        return result.toString();
    }

    public static String commonAndThenRest(String word1, String word2) {
        var result = new StringBuilder();
        var commonLength = Math.min(word1.length(), word2.length());
        for (var i = 0; i < commonLength; i++) {
            result.append(word1.charAt(i)).append(word2.charAt(i));
        }
        if(word1.length() > commonLength) {
            result.append(word1.substring(commonLength));
        }
        if(word2.length() > commonLength) {
            result.append(word2.substring(commonLength));
        }
        return result.toString();
    }
}
