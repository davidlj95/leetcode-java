package com.davidlj95.leetcode;

// https://leetcode.com/problems/can-place-flowers/ (605)
public class CanPlaceFlowers {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        var availableFlowerbeds = 0;
        for (var i = 0; i < flowerbed.length; i++) {
            var previousFlowerbed = (i - 1) < 0 ? 0 : flowerbed[i - 1];
            var nextFlowerbed = (i + 1) >= flowerbed.length ? 0 : flowerbed[i + 1];
            if (previousFlowerbed == 0 && flowerbed[i] == 0 && nextFlowerbed == 0) {
                flowerbed[i] = 1;
                availableFlowerbeds++;
            }
        }
        return n <= availableFlowerbeds;
    }
}
