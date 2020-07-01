package com.ygr.algos.arrays;

/**
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * <p>
 * Example:
 * <p>
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.
 * <p>
 * Note: Please solve it without division and in O(n).
 * <p>
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class ProductOfArray {

    public static void main(String[] args) {
        ProductOfArray productOfArray = new ProductOfArray();
        int[] ints = productOfArray.productExceptSelf(new int[]{1, 6, 8, 1, 6, 4});
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
    }

    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0] = 1;
        right[nums.length - 1] = 1;

        for (int i = 1; i < nums.length; i++) {
            left[i] = nums[i - 1] * left[i - 1];
            System.out.println(left[i]);
        }

        for (int j = nums.length - 2; j >= 0; j--) {
            right[j] = nums[j + 1] * right[j + 1];
            System.out.println(right[j]);
        }

        for (int k = 0; k < nums.length; k++) {
            res[k] = left[k] * right[k];
            System.out.println(res[k]);
        }
        return res;
    }

}
