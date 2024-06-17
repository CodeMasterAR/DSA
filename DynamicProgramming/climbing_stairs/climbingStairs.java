package DynamicProgramming.climbing_stairs;
import java.util.Scanner;

/*
LeetCode:- 70. Climbing Stairs
Link:- https://leetcode.com/problems/climbing-stairs/description/

You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Constraints:
1 <= n <= 45
 */

public class climbingStairs {
    public static class Solution{
        int[] dp = new int[46];
        public  int climbStairs(int n) {
            if (n <= 2) {
                return n;
            }

//            Constant space
            int a = 1;
            int b = 2;
            int c = 0;
            for (int i = 3; i <= n; i ++){
                c = a + b;
                a = b;
                b = c;
            }
            return c;


//            Memoization
//            dp[1] = 1;
//            dp[2] = 2;
//            for (int i = 3; i <= n; i ++){
//                dp[i] = dp[i - 1] + dp[i - 2];
//            }
//            return dp[n];

//            Recursion
//            return solve(n);
        }
        public int solve(int n) {
            if (n <= 2){
                return n;
            }
            return solve(n - 1) + solve(n - 2);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution s = new Solution();
        System.out.println("Enter the no of cases: ");
        int T = sc.nextInt();
        while (T > 0){
            System.out.print("Enter the number of steps:  ");
            int n = sc.nextInt();
            System.out.println(s.climbStairs(n));
            T --;
        }
    }
}
