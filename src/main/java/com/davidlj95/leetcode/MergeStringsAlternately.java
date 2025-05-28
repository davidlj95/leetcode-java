package com.davidlj95.leetcode;

// https://leetcode.com/problems/merge-strings-alternately (1768)
public class MergeStringsAlternately {
    @SuppressWarnings("unused")
    public static String mergeAlternately(String word1, String word2) {
        return commonAndThenRest(word1, word2);
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
        if (word1.length() > commonLength) {
            result.append(word1.substring(commonLength));
        }
        if (word2.length() > commonLength) {
            result.append(word2.substring(commonLength));
        }
        return result.toString();
    }
}
