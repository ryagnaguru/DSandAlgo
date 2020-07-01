package com.ygr.algos.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {

    public static void main(String[] args) {
        twoSum(9, new int[]{11, 2, 7, 11, 15, -2});
    }

    static void twoSum(int sum, int... arr) {
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            index.put(arr[i], i);
        }
        for (int i = 0; i < arr.length; i++) {
            int diff = sum - arr[i];
            if (index.containsKey(diff) && i != index.get(diff)) {
                System.out.println(i + " & " + index.get(diff));
            }
        }
    }
}
