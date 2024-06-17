package DynamicProgramming.fibonacci;

import java.util.Scanner;

/*
LeetCode:- 509. Fibonacci Number
Link:- https://leetcode.com/problems/fibonacci-number/description/
The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence,
such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n > 1.
Given n, calculate F(n).

Constraints:
0 <= n <= 30
 */
public class fibonacci {
    public static class Solution {
        int[] dp = new int[31];
        public int fib(int n){

            if (n <= 1){
                return n;
            }

//            Using Constant Space
            int a = 0, b = 1, c = 0;
            for (int i = 2; i <= n; i ++){
                c = a + b;
                a = b;
                b = c;
            }
            return c;


//            Memoization
//            dp[1] = 1;
//            for (int i = 2; i <= n; i ++){
//                dp[i] = dp[i - 1] + dp[i - 2];
//            }
//            return dp[n];


//            Recursion method
//            return solve(n);
        }

        //        Recursion method
        public int solve(int n){
            if (n <= 1) {
                return n;
            }
            return solve(n - 1) + solve(n - 2);
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution s = new Solution();
        System.out.println("Enter the  no of cases: " );
        int T = sc.nextInt();

        while (T > 0){
            System.out.print("Enter the num: ");
            int n = sc.nextInt();
            System.out.println(s.fib(n));
            T --;
        }
    }
}
