package Strings.OrderlyQueue;

import java.util.*;

/*
LeetCode:- 899. Orderly Queue
Link:- https://leetcode.com/problems/orderly-queue/description/
Company: Amazon

You are given a string s and an integer k. You can choose one of the first k letters of s and append it at the end of the string.

Return the lexicographically smallest string you could have after applying the mentioned step any number of moves.

Constraints:

1 <= k <= s.length <= 1000
s consist of lowercase English letters.
 */

public class OrderlyQueue {
    public static class Solution{
        public String orderlyQueue(String s, int k) {
            if (k == 1){
                String result = s;
                int len = s.length();

                for (int i = 1; i < len; i++) {
                    String temp = s.substring(i) + s.substring(0, i);
                    if (temp.compareTo(result) < 0) {
                        result = temp;
                    }
                }

                return result;
            }
            char[] charArr = s.toCharArray();
            Arrays.sort(charArr);
            return new String(charArr);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution s = new Solution();
        System.out.print("Enter the no of cases: ");
        int T = sc.nextInt();

        while (T > 0){
            sc.nextLine();
            System.out.print("Enter the String s: ");
            String S = sc.nextLine();
            System.out.print("Enter the Integer k: ");
            int k = sc.nextInt();
            System.out.println(s.orderlyQueue(S,k));
            T --;
        }
    }
}
