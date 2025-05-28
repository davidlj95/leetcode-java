package com.davidlj95.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/ (1431)
public class KidsWithGreatestNumberOfCandies {
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        return oldFashionButMorePerformant(candies, extraCandies);
    }

    // Own
    public static List<Boolean> streamy(int[] candies, int extraCandies) {
        @SuppressWarnings("OptionalGetWithoutIsPresent") var maxNumberOfCandies = Arrays.stream(candies).max().getAsInt();
        return Arrays.stream(candies).mapToObj(candy -> candy + extraCandies >= maxNumberOfCandies).toList();
    }

    // Checking out faster submissions on LeetCode
    public static List<Boolean> oldFashionButMorePerformant(int[] candies, int extraCandies) {
        var maxNumberOfCandies = 0;
        for (int candy : candies) {
            maxNumberOfCandies = Math.max(maxNumberOfCandies, candy);
        }
        var result = new ArrayList<Boolean>(candies.length);
        for (int candy : candies) {
            result.add(candy + extraCandies >= maxNumberOfCandies);
        }
        return result;
    }
}
