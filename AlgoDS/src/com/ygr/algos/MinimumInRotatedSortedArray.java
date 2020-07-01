package com.ygr.algos;

import java.util.Arrays;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * <p>
 * Find the minimum element.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,4,5,1,2]
 * Output: 1
 * Example 2:
 * <p>
 * Input: [4,5,6,7,0,1,2]
 * Output: 0
 */
public class MinimumInRotatedSortedArray {

    public static void main(String[] args) {
        MinimumInRotatedSortedArray mirs = new MinimumInRotatedSortedArray();
        System.out.println(mirs.findMin(new int[]{2, 3, 4, 5, 1}));
    }

    public int findMin(int[] nums) {
        while (nums.length != 0) {
            if (nums.length == 1) {
                return nums[0];
            }
            if (nums[0] < nums[nums.length - 1]) {
                return nums[0];
            }
            int mid = nums.length / 2;
            if (nums[mid] < nums[mid - 1]) {
                return nums[mid];
            } else if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[0] > nums[mid]) {
                nums = Arrays.copyOfRange(nums, 0, mid);
            } else {
                nums = Arrays.copyOfRange(nums, mid, nums.length);
            }
        }
        return -1;
    }
}
