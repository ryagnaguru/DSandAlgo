package com.ygr.algos.DynamicProgramming;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 * <p>
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 45
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        int n = 6;
        int steps[] = new int[n + 1];
        steps[0] = 1;
        steps[1] = 1;
        for (int i = 2; i <= n; i++) {
            steps[i] = steps[i - 1] + steps[i - 2];
        }
        System.out.println(steps[n - 1]);
    }
}
