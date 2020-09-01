package com.ygr.algos.DynamicProgramming;

import java.util.Arrays;

/**
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * Example 1:
 * <p>
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 * <p>
 * Input: coins = [2], amount = 3
 * Output: -1
 */
public class CoinChange {
    public static void main(String[] args) {
        int coins[] = {1, 2, 5};
        int sum = 3;
        Arrays.sort(coins);
        int dp[] = new int[sum + 1];
        Arrays.fill(dp, sum + 1);
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[(i - coins[j])] + 1, dp[i]);
                }
            }
        }
        System.out.println(dp[sum] > sum ? -1 : dp[sum]);
    }
}
