package com.ygr.algos.arrays;

/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * <p>
 * Note: You may not slant the container and n is at least 2.
 * <p>
 * Example:
 * <p>
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 */
public class ContainerWithWater {

    public static void main(String[] args) {
        int nums[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int left = 0;
        int right = nums.length - 1;
        int max = Integer.MIN_VALUE;

        while (left < right) {
            int min = Math.min(nums[left], nums[right]);
            max = Math.max(max, (min * (right - left)));
            if (nums[left] < nums[right]) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println(max);
    }
}
