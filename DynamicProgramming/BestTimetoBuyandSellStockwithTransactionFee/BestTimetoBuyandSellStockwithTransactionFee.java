package DynamicProgramming.BestTimetoBuyandSellStockwithTransactionFee;

import java.util.*;

/*
LeetCode:- 714. Best Time to Buy and Sell Stock with Transaction Fee
Link:- https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/

You are given an array prices where prices[i] is the price of a given stock on the ith day,
and an integer fee representing a transaction fee.

Find the maximum profit you can achieve. You may complete as many transactions as you like,
but you need to pay the transaction fee for each transaction.

Note:

You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
The transaction fee is only charged once for each stock purchase and sale.

Constraints:

1 <= prices.length <= 5 * 104
1 <= prices[i] < 5 * 104
0 <= fee < 5 * 104
 */

public class BestTimetoBuyandSellStockwithTransactionFee {
    public static class Solution{
        public int maxProfit(int[] prices, int fee) {
            int n = prices.length;
            int[] dp = new int[n];
            int minPrice = prices[0];
            int maxProfit = 0;
            for (int i = 1; i < n; i ++){
                if (prices[i] < prices[i - 1] && (prices[i - 1] - minPrice - fee) > 0){
                    minPrice = prices[i];
                    maxProfit += dp[i - 1];
                }
                else {
                    dp[i] = Math.max(0,prices[i] - minPrice - fee);
                }
            }
            return  maxProfit + dp[n - 1];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution s = new Solution();
        System.out.print("Enter the no of cases: ");
        int T = sc.nextInt();
        while (T > 0){
            System.out.print("Enter the no of days: ");
            int n = sc.nextInt();
            int[] prices = new int[n];
            System.out.print("Enter the price of share each day: ");
            for (int i = 0; i < n; i ++){
                prices[i] = sc.nextInt();
            }
            System.out.print("Enter the transaction Fee: ");
            int fee = sc.nextInt();
            System.out.println(s.maxProfit(prices, fee));
            T --;
        }
    }
}
