package com.ygr.algos.arrays;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * <p>
 * Note that you cannot sell a stock before you buy one.
 * <p>
 * Example 1:
 * <p>
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Not 7-1 = 6, as selling price needs to be larger than buying price.
 * Example 2:
 * <p>
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class BuyAndSellStocks {

    public static void main(String[] args) {
        BuyAndSellStocks buyAndSellStocks = new BuyAndSellStocks();
//        buyAndSellStocks.findBuyAndSell(new int[]{7, 1, 5, 3, 6, 4});
        buyAndSellStocks.findBuyAndSell(new int[]{2, 4, 1});
    }

    int findBuyAndSell(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            } else if (arr[i] - min > max) {
                max = arr[i] - min;
            }
        }
        return max;
    }
}
