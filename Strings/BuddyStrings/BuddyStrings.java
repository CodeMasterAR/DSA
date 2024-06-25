package Strings.BuddyStrings;

import java.util.*;

/*
LeetCode:- 859. Buddy Strings
Link:- https://leetcode.com/problems/buddy-strings/description/
Company: Google and Meta

Given two strings s and goal, return true if you can swap two letters in s so the result is equal to goal, otherwise, return false.

Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at s[i] and s[j].

For example, swapping at indices 0 and 2 in "abcd" results in "cbad".

Constraints:

1 <= s.length, goal.length <= 2 * 104
s and goal consist of lowercase letters.
 */

public class BuddyStrings {
    public static class Solution{
        public boolean buddyStrings(String s, String goal) {
            int n = s.length();
            int m = goal.length();
            if (n != m){
                return false;
            }
            if (s.equals(goal)){
                return checkFrequency(s);
            }
            List<Integer> index = new ArrayList<>();
            for (int i = 0; i < n; i ++) {
                if (s.charAt(i) != goal.charAt(i)){
                    index.add(i);
                }
            }
            int swap = index.size();
            if (swap == 2){
                StringBuilder sb = new StringBuilder(s);
                sb.setCharAt(index.get(0), s.charAt(index.get(1)));
                sb.setCharAt(index.get(1), s.charAt(index.get(0)));
                return goal.equals(sb.toString());
            }
            return false;
        }

        public boolean checkFrequency(String s){
            int[] alphabet = new int[26];
            for (int i = 0; i < s.length(); i ++){
                int ind = s.charAt(i) - 'a';
                if (alphabet[ind] == 1){
                    return true;
                }
                alphabet[ind] ++;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution s = new Solution();
        System.out.print("Enter the no of cases: ");
        int T = sc.nextInt();
        while (T > 0){
            sc.nextLine();
            System.out.print("Enter the string: ");
            String S = sc.nextLine();
            System.out.print("Enter the goal: ");
            String goal = sc.nextLine();
            System.out.println(s.buddyStrings(S, goal));
            T --;
        }
    }
}
