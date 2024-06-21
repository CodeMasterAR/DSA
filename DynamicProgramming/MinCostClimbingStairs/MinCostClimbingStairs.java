package DynamicProgramming.MinCostClimbingStairs;

import java.util.*;

/*
LeetCode:- 746. Min Cost Climbing Stairs
Link:- https://leetcode.com/problems/min-cost-climbing-stairs/description/

You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost,
you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.

Constraints:

2 <= cost.length <= 1000
0 <= cost[i] <= 999
 */

public class MinCostClimbingStairs {
    public static class Solution{
        int[] dp = new int[1001];
        public int minCostClimbingStairs(int[] cost) {

            int n = cost.length;

//            Bottom to Top Approach (Using constant space)
            int step1 = cost[0];
            int step2 = cost[1];
            for (int i = 2; i < n; i ++){
                int currStep = Math.min(step1,step2) + cost[i];
                step1 = step2;
                step2 = currStep;
            }
            return Math.min(step1, step2);

//            Bottom to Top Approach (Using n space)
//            int[] dp = new int[n];
//            dp[0] = cost[0];
//            dp[1] = cost[1];
//            for (int i = 2; i < n; i ++){
//                dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
//            }
//            return Math.min(dp[n - 1], dp[n - 2]);

//            Memoization (Top to Bottom Approach)
//            for (int i = 0; i < 1001; i ++){
//                dp[i] = -1;
//            }
//            return solve(cost, -1);
        }

//        Recursion method and Memoization (Top to Bottom Approach)
        public int solve(int[] cost, int index){
            if (index >= cost.length - 1){
                return 0;
            }
            if (dp[index + 1] != -1){
                return dp[index + 1];
            }
            int takeStep1 = solve(cost, index + 1) + cost[index + 1];
            int takeStep2 = 0;
            if (index + 2 < cost.length){
                takeStep2 = solve(cost, index + 2) + cost[index + 2];
            }
            return dp[index + 1] = Math.min(takeStep1, takeStep2);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution s = new Solution();
        System.out.print("Enter the no of cases: ");
        int T = sc.nextInt();
        while (T > 0){
            System.out.print("Enter the no of steps: ");
            int n = sc.nextInt();
            int[] cost = new int[n];
            System.out.print("Enter the cost of each steps: ");
            for (int i = 0; i < n; i ++){
                cost[i] = sc.nextInt();
            }
            System.out.println(s.minCostClimbingStairs(cost));
            T --;
        }
    }
}
