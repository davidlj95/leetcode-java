package com.davidlj95.leetcode;

public class ReverseVowelsOfString {
    public static String reverseVowels(String s) {
        var j = s.length() - 1;
        var result = new StringBuilder(s);
        for (int i = 0; i < j; i++) {
            if (!isVowel(s.charAt(i))) {
                continue;
            }
            while (j > i && !isVowel(s.charAt(j))) {
                j--;
            }
            result.setCharAt(i, s.charAt(j));
            result.setCharAt(j, s.charAt(i));
            j--;
        }
        return result.toString();
    }

    private static Boolean isVowel(char c) {
        return switch (c) {
            case 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' -> true;
            default -> false;
        };
    }
}
