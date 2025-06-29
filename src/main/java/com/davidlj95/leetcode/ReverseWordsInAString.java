package com.davidlj95.leetcode;

public class ReverseWordsInAString {
    @SuppressWarnings("unused")
    public static String reverseWords(String s) {
        return trimSeparateAndBuild(s);
    }

    public static String trimSeparateAndBuild(String s) {
        var words = s.trim().replaceAll("\\s+", " ").split(" ");
        var output = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            output.append(words[i]);
            output.append(" ");
        }
        return output.substring(0, output.length() - 1);
    }
}
