package com.ygr.algos.arrays;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * <p>
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        SearchInRotatedSortedArray mirs = new SearchInRotatedSortedArray();
        System.out.println(mirs.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 1));
    }

    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        if (nums.length == 1)
            if (nums[0] == target) return 0;
            else return -1;

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int start = left;
        left = 0;
        right = nums.length - 1;

        if (nums[start] <= target && nums[right] >= target) {
            left = start;
        } else {
            right = start;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) right = mid + 1;
            else left = mid - 1;
        }
        return -1;
    }
}
