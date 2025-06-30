package com.davidlj95.leetcode;

// https://leetcode.com/problems/reverse-words-in-a-string/ (151)
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

    public static String loopAndPrepend(String s) {
        var SPACE = ' ';
        var chars = s.toCharArray();
        var output = new StringBuilder();
        int lastWordStart = -1;
        for (var i = 0; i < chars.length; i++) {
            var ch = chars[i];
            if (ch == SPACE) {
                if (lastWordStart == -1) continue;
                output.insert(0, SPACE).insert(0, s.substring(lastWordStart, i));
                lastWordStart = -1;
                continue;
            }
            if (lastWordStart == -1) lastWordStart = i;
        }
        if (lastWordStart != -1) output.insert(0, SPACE).insert(0, s.substring(lastWordStart));
        return output.substring(0, output.length() - 1);
    }
}
