package Strings.DetermineifTwoStringsAreClose;

import java.util.*;

/*
LeetCode:- 1657. Determine if Two Strings Are Close
Link:- https://leetcode.com/problems/determine-if-two-strings-are-close/description/
Company: Google, Adobe, Morgan Stanley, Microsoft, Uber, Atlassian

Two strings are considered close if you can attain one from the other using the following operations:

Operation 1: Swap any two existing characters.
For example, abcde -> aecdb
Operation 2: Transform every occurrence of one existing character into another existing character,
and do the same with the other character.
For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
You can use the operations on either string as many times as necessary.

Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.
 */

public class DetermineifTwoStringsAreClose {
    public static class Solution{
        public boolean closeStrings(String w1, String w2) {
            int n = w1.length();
            int m = w2.length();
            if (m != n){
                return false;
            }
            int[] freq1 = new int[26];
            int[] freq2 = new int[26];
            for (int i = 0; i < m; i ++){
                int ind1 = w1.charAt(i) - 'a';
                int ind2 = w2.charAt(i) - 'a';

                freq1[ind1] ++;
                freq2[ind2] ++;
            }
            for (int i = 0; i < 26; i ++){
                if (freq1[i] != 0 && freq2[i] != 0) continue;
                if (freq1[i] == 0 && freq2[i] == 0) continue;
                return false;
            }
            Arrays.sort(freq1);
            Arrays.sort(freq2);

            return Arrays.equals(freq1, freq2);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution s = new Solution();
        System.out.print("Enter the no of cases: ");
        int T = sc.nextInt();
        while (T > 0){
            sc.nextLine();
            System.out.print("Enter the word1: ");
            String word1 = sc.nextLine();
            System.out.print("Enter the word2: ");
            String word2 = sc.nextLine();
            System.out.print(s.closeStrings(word1, word2));
            T --;
        }
    }
}
