package com.ygr.algos;

import java.util.Arrays;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * <p>
 * Example:
 * <p>
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 * <p>
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class MaximumSubArray {

    public static void main(String[] args) {
        MaximumSubArray maximumSubArray = new MaximumSubArray();
        maximumSubArray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
    }

    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = ((nums[i - 1] + nums[i]) < nums[i]) ? nums[i] : (nums[i - 1] + nums[i]);
            sum = Math.max(sum, nums[i]);
        }
        return sum;
    }
}
