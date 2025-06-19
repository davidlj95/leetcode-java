package com.davidlj95.leetcode;

// https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/ (1456)
public class MaximumNumberOfVowelsInSubstringOfGivenLength {
    @SuppressWarnings("unused")
    public static int maxVowels(String s, int k) {
        return loopKThenMoveWindow(s, k);
    }

    // Own solution
    public static int loopKThenMoveWindow(String s, int k) {
        var maxVowels = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                maxVowels++;
            }
        }
        var vowels = maxVowels;
        for (int i = k; i < s.length(); i++) {
            if (isVowel(s.charAt(i - k))) {
                vowels--;
            }
            if (isVowel(s.charAt(i))) {
                vowels++;
            }
            if (vowels > maxVowels) maxVowels = vowels;
            if (maxVowels == k) break;
        }
        return maxVowels;
    }

    private static Boolean isVowel(char c) {
        return switch (c) {
            case 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' -> true;
            default -> false;
        };
    }

    // After looking at faster solutions
    public static int optimized(String s, int k) {
        var isVowel = new int[128];
        isVowel['a']++;
        isVowel['e']++;
        isVowel['i']++;
        isVowel['o']++;
        isVowel['u']++;

        var chars = s.toCharArray();

        var vowels = 0;
        for (int i = 0; i < k; i++) {
            vowels += isVowel[chars[i]];
        }
        var maxVowels = vowels;
        for (int i = k; i < chars.length; i++) {
            vowels -= isVowel[chars[i - k]];
            vowels += isVowel[chars[i]];
            if (vowels > maxVowels) maxVowels = vowels;
        }
        return maxVowels;
    }
}
