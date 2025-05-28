package com.davidlj95.leetcode;

// https://leetcode.com/problems/greatest-common-divisor-of-strings/ (1071)
public class GreatestCommonDivisorOfStrings {
    public static String gcdOfStrings(String str1, String str2) {
        String[] divisors = {getDivisor(str1), getDivisor(str2)};

        if (!divisors[0].equals(divisors[1])) return "";
        var commonDivisor = divisors[0];
        if (commonDivisor.isEmpty()) return "";

        var shortestStringLength = Math.min(str1.length(), str2.length());
        var gcd = commonDivisor;
        var nextDivisorMultiple = gcd + commonDivisor;
        while (nextDivisorMultiple.length() <= shortestStringLength) {
            if (str1.length() % nextDivisorMultiple.length() == 0 && str2.length() % nextDivisorMultiple.length() == 0) {
                gcd = nextDivisorMultiple;
            }
            nextDivisorMultiple += commonDivisor;
        }
        return gcd;
    }

    private static String getDivisor(String str) {
        if (str.isEmpty()) return "";
        if (str.length() == 1) return str;
        var pattern = new StringBuilder();

        for (var i = 0; i < str.length(); i++) {
            pattern.append(str.charAt(i));
            var j = i + 1;
            while (j < str.length() && j + pattern.length() <= str.length() && str.substring(j, j + pattern.length()).contentEquals(pattern)) {
                j += pattern.length();
            }
            if (j == str.length()) return pattern.toString();
        }
        return str;
    }
}
