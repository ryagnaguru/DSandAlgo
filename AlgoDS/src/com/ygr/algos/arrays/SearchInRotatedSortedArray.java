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
        System.out.println(mirs.search(new int[]{3, 4, 5, 1, 2}, 3));
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums.length == 1) {
                return 0;
            }
            if (nums[0] < nums[nums.length - 1]) {
                return 0;
            }
            int mid = left + right / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (target > nums[mid]) {
                left = 0;
                right = mid;
            } else {
                left = mid;
                right = nums.length - 1;
            }
        }
        return -1;
    }


//    public int search(int[] nums, int target) {
//        int minIndex = getMinimumIndex(nums);
//        int left = 0;
//        int right = nums.length;
//        if (nums[minIndex] == target) {
//            return minIndex;
//        }
//        if (target <= nums[nums.length - 1]) {
//            left = minIndex;
//            right = nums.length - 1;
//        } else {
//            left = 0;
//            right = minIndex;
//        }
//        while (left <= right) {
//            int mid = (left + right) / 2;
//            if (nums[mid] == target) {
//                return mid;
//            }
//            if (target > nums[right]) {
//                left = 0;
//                right = mid;
//            } else {
//                left = mid + 1;
//                right = nums.length - 1;
//            }
//        }
//
//        return -1;
//    }

    int getMinimumIndex(int... nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums.length == 1) {
                return 0;
            }
            if (nums[0] < nums[nums.length - 1]) {
                return 0;
            }
            int mid = left + right / 2;
            if (nums[mid] < nums[mid - 1]) {
                return mid;
            } else if (nums[mid] > nums[mid + 1]) {
                return mid + 1;
            }
            if (nums[0] > nums[mid]) {
                left = 0;
                right = mid;
            } else {
                left = mid;
                right = nums.length;
            }
        }
        return -1;
    }
}
