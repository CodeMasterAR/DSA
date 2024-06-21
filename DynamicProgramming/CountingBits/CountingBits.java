package DynamicProgramming.CountingBits;

import java.util.*;

/*
LeetCode:- 338. Counting Bits
Link:- https://leetcode.com/problems/counting-bits/description/

Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n),
ans[i] is the number of 1's in the binary representation of i.

Constraints:

0 <= n <= 105
 */
public class CountingBits {
    public static class Solution{
        public int[] countBits(int n) {
            int[] result = new int[n+1];
            result[0] = 0;
            for (int i = 1; i <= n; i ++){
                if ((i & (i - 1)) == 0){
                    result[i] = 1;
                }
                else{
                    result[i] = result[i & (i-1)] + 1;
                }
            }
            return result;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution s = new Solution();
        System.out.print("Enter the no of cases: ");
        int T = sc.nextInt();
        while (T > 0){
            System.out.print("Enter value of n: ");
            int n = sc.nextInt();
            System.out.println(Arrays.toString(s.countBits(n)));
            T --;
        }
    }
}
