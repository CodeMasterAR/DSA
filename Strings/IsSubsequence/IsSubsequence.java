package Strings.IsSubsequence;

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
        /*
        Time complexity:
        length of s: n
        length of t: m
        Worst case of time complexity is O(n + m)
         */

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
        /*
        Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109,
        and you want to check one by one to see if t has its subsequence. In this scenario,
       how would you change your code?
        */
        /*
        For above method if we pass k no of Strings Time complexity will be O(k*(n + m))
         */

//        We optimized above code with extra space complexity
//        Time complexity will be  O(k*n + m)
        public boolean[] isSubsequence(String[] s, String t){
            HashMap<Character, TreeSet<Integer>> map = new HashMap<>();
            int m = t.length();
//            Add all the character with index in map
//            Time complexity O(m)
            for (int i = 0; i < m; i ++){
                if (!map.containsKey(t.charAt(i))) {
                    map.put(t.charAt(i), new TreeSet<>());
                }
                map.get(t.charAt(i)).add(i);
            }
            int k = s.length;
            boolean[] result = new boolean[k];
            for (int i = 0; i < k; i++){
//                result[i] = isSubsequence(s[i], t);   Time complexity: O(k*(n + m))
                    result[i] = solve(s[i], map);   // Time complexity: O(k*n)
            }
            return result;
        }

//        Time complexity is O(n)
        boolean solve(String s, HashMap<Character, TreeSet<Integer>> map){
            int pre = -1;
            int n = s.length();

            for (int i = 0; i < n; i ++){
                char ch = s.charAt(i);
                if (map.containsKey(ch)){
                    Integer upperValue = map.get(ch).higher(pre);
                    if (upperValue == null || upperValue <= pre){
                        return false;
                    }
                    pre = upperValue;
                }
            }
            return true;
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
        System.out.print("Enter the no of strings: ");
        int k = sc.nextInt();
        String[] s = new String[k];
        System.out.print("Enter the strings: ");
        for (int i = 0; i < k; i ++){
            sc.nextLine();
            s[i] = sc.nextLine();
        }
        System.out.print("Enter the String t: ");
        String t = sc.nextLine();
        System.out.print(Arrays.toString(S.isSubsequence(s, t)));
    }
}
