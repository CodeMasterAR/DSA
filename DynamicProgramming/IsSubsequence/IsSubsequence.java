package DynamicProgramming.IsSubsequence;

import java.util.*;

/*
LeetCode:- 392. Is Subsequence
Link:- https://leetcode.com/problems/is-subsequence/description/

Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from
the original string by deleting some (can be none) of the characters without disturbing
the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

Constraints:

0 <= s.length <= 100
0 <= t.length <= 104
s and t consist only of lowercase English letters.

 */

public class IsSubsequence {
    public static class Solution{
        public boolean isSubsequence(String s, String t) {
            int i = 0, j = 0;
            while (i < s.length() && j < t.length()){
                if (s.charAt(i) == t.charAt(j)){
                    i ++;
                }
                j ++;
            }
            return (i == s.length());
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution S = new Solution();
        System.out.print("Enter the no of cases: ");
        int T = sc.nextInt();
        sc.nextLine();
        while (T > 0){
            System.out.print("Enter the s: ");
            String s = sc.nextLine();
            System.out.print("Enter the t: ");
            String t = sc.nextLine();
            System.out.println(S.isSubsequence(s, t));
            T --;
        }
    }
}
