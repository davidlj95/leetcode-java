package com.davidlj95.leetcode;

// https://leetcode.com/problems/reverse-vowels-of-a-string/ (345)
public class ReverseVowelsOfString {
    public static String reverseVowels(String s) {
        var result = s.toCharArray();
        var j = result.length - 1;
        for (int i = 0; i < j; i++) {
            if (!isVowel(result[i])) {
                continue;
            }
            while (j > i && !isVowel(result[j])) {
                j--;
            }
            char tmp = result[i];
            result[i] = result[j];
            result[j] = tmp;
            j--;
        }
        return String.valueOf(result);
    }

    private static Boolean isVowel(char c) {
        return switch (c) {
            case 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' -> true;
            default -> false;
        };
    }
}
