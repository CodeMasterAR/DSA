package DynamicProgramming.BestTimetoBuyandSellStock;

import java.util.*;

/*
LeetCode:- 121. Best Time to Buy and Sell Stock
Link:- https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Constraints:

1 <= prices.length <= 105
0 <= prices[i] <= 104
 */

public class BestTimetoBuyandSellStock {
    public static class Solution{
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int[] dp = new int[n];
            int maxProfit = Integer.MIN_VALUE;
            for (int i = 0; i < n; i ++){
                for (int j = 0; j < i; j ++){
                    if (prices[j] < prices[i]){
                        dp[i] = Math.max(dp[i], prices[i] - prices[j]);
                    }
                }
                maxProfit = Math.max(maxProfit, dp[i]);
            }
            return maxProfit;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution s = new Solution();
        System.out.print("Enter the no of cases: ");
        int T = sc.nextInt();
        while(T > 0){
            System.out.print("Enter the no of days: ");
            int n = sc.nextInt();
            int[] prices = new int[n];
            System.out.print("Enter the stock Price per day: ");
            for (int i = 0; i < n; i ++){
                prices[i] = sc.nextInt();
            }
            System.out.println(s.maxProfit(prices));
            T --;
        }
    }
}
