package com.davidlj95.leetcode;

// https://leetcode.com/problems/greatest-common-divisor-of-strings/ (1071)
public class GreatestCommonDivisorOfStrings {
    @SuppressWarnings("unused")
    public static String gcdOfStrings(String str1, String str2) {
        return commonDivisorThenMultiply(str1, str2);
    }

    // Own
    public static String commonDivisorThenMultiply(String str1, String str2) {
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

    // LeetCode's editorial bruteforce
    public static String bruteForce(String str1, String str2) {
        var gcd = str1.length() > str2.length() ? str2 : str1;
        while (!gcd.isEmpty()) {
            if (str1.length() % gcd.length() == 0 && str2.length() % gcd.length() == 0) {
                var ratioStr1 = str1.length() / gcd.length();
                var ratioStr2 = str2.length() / gcd.length();
                if (gcd.repeat(ratioStr1).equals(str1) && gcd.repeat(ratioStr2).equals(str2)) {
                    return gcd;
                }
            }
            gcd = gcd.substring(0, gcd.length() - 1);
        }
        return "";
    }
}
