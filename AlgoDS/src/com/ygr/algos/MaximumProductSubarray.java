package com.ygr.algos;

/**
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * <p>
 * Example 1:
 * <p>
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 * <p>
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 * -2, 3, -4
 * -3, -1, -1
 * 3, -1, 4
 * -2, 3, -4
 */
public class MaximumProductSubarray {

    public static void main(String[] args) {
        MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();
        System.out.println(maximumProductSubarray.maxProduct(new int[]{-2, 3, -4}));
    }

    public int maxProduct(int[] nums) {
        int[] maxValue = new int[nums.length];
        int[] min = new int[nums.length];
        maxValue[0] = min[0] = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                maxValue[i] = Math.max(nums[i], maxValue[i - 1] * nums[i]);
                min[i] = Math.min(nums[i], min[i - 1] * nums[i]);
            } else {
                maxValue[i] = Math.max(nums[i], min[i - 1] * nums[i]);
                min[i] = Math.min(nums[i], maxValue[i - 1] * nums[i]);
            }
            result = Math.max(result, maxValue[i]);
        }
        return result;
    }
}
