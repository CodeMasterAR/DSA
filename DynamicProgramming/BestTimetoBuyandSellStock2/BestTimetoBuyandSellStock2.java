package DynamicProgramming.BestTimetoBuyandSellStock2;

import java.util.*;

/*
LeetCode:- 122. Best Time to Buy and Sell Stock II
Link:- https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/

You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. \However, you can buy it
then immediately sell it on the same day.

Find and return the maximum profit you can achieve.

Constraints:

1 <= prices.length <= 3 * 104
0 <= prices[i] <= 104
 */
public class BestTimetoBuyandSellStock2 {
    public static class Solution{
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int maxProfit = 0;
            int minPrice = prices[0];
            int[] dp = new int[n];
            for (int i = 1; i < n; i ++){
                if (prices[i] > prices[i - 1]){
                    dp[i] = prices[i] - minPrice;
                }
                else {
                    minPrice = prices[i];
                    maxProfit += dp[i - 1];
                }
            }
            return maxProfit + dp[n - 1];
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution s = new Solution();
        System.out.print("Enter the no of case: ");
        int T = sc.nextInt();
        while (T > 0){
            System.out.print("Enter the no of days: ");
            int n = sc.nextInt();
            int[] prices = new int[n];
            System.out.print("Enter the prices of shares for each day: ");
            for (int i = 0; i < n; i ++){
                prices[i] = sc.nextInt();
            }
            System.out.println(s.maxProfit(prices));
            T --;
        }
    }
}
