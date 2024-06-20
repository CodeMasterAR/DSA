package DynamicProgramming.LongestUnequalAdjacentGroupsSubsequence;

import java.util.*;

/*
LeetCode:- 2900. Longest Unequal Adjacent Groups Subsequence I
Link:- https://leetcode.com/problems/longest-unequal-adjacent-groups-subsequence-i/description/

You are given a string array words and a binary array groups both of length n, where words[i] is associated with groups[i].

Your task is to select the longest alternating
subsequence
 from words. A subsequence of words is alternating if for any two consecutive strings in the sequence, t
 heir corresponding elements in the binary array groups differ. Essentially,
 you are to choose strings such that adjacent elements have non-matching corresponding bits in the groups array.

Formally, you need to find the longest subsequence of an array of indices [0, 1, ..., n - 1] denoted as [i0, i1, ..., ik-1],
such that groups[ij] != groups[ij+1] for each 0 <= j < k - 1 and then find the words corresponding to these indices.

Return the selected subsequence. If there are multiple answers, return any of them.

Note: The elements in words are distinct.

Constraints:

1 <= n == words.length == groups.length <= 100
1 <= words[i].length <= 10
groups[i] is either 0 or 1.
words consist of distinct strings.
words[i] consists of lowercase English letters.
 */
public class LongestUnequalAdjacentGroupsSubsequence {

    public static class Solution{
        public List<String> getLongestSubsequence(String[] words, int[] groups) {
            List<String> result = new ArrayList<>();
//            List<String> temp = new ArrayList<>();
//            solve(result, temp, words, groups, -1, 0);
            int n = groups.length;
            int bit = groups[0];
            int max = 0;
            int index = 0;
            int[] dp = new int[n];
            int[] preIndex = new int[n];
            for (int i = 0;  i < n; i ++){
                preIndex[i] = -1;
                dp[i] = 1;
            }
            for (int i = 1; i < n; i ++){
                if ((bit^1) == groups[i]) {
                    bit = groups[i];
                    dp[i] = dp[index] + 1;
                    preIndex[i] = index;
                    if (max < dp[i]){
                        max = dp[i];
                        index = i;
                    }
                }
            }
            while (index != -1){
                result.add(0, words[index]);
                index = preIndex[index];
            }
            return result;
        }

//        Recursion Method (Top to Bottom Approach).
//        We can't memoize this code. because we have to return the array.
        public void solve(List<String> result, List<String> temp, String[] words, int[] groups, int bit, int index){
            if (index >= groups.length){
                if (temp.size() > result.size()){
                    result.clear();
                    result.addAll(temp);
                }
                return;
            }
            if (bit == -1 || (bit^1) == groups[index]){
                temp.add(words[index]);
                solve(result, temp, words, groups, groups[index], index + 1);
                temp.remove(temp.size() - 1);
            }
            solve(result, temp, words, groups, bit, index + 1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution s = new Solution();
        System.out.print("Enter the no of cases: ");
        int T = sc.nextInt();
        while(T > 0){
            System.out.print("Enter the length n: ");
            int n = sc.nextInt();
            sc.nextLine();
            int[] groups = new int[n];
            String[] words = new String[n];
            System.out.print("Enter the words: ");
            for (int i = 0; i < n; i ++){
                words[i] = sc.nextLine();
            }
            System.out.print("Enter the group division: ");
            for (int i = 0; i < n; i ++){
                groups[i] = sc.nextInt();
            }
            System.out.println(s.getLongestSubsequence(words, groups).toString());
            T --;
        }
    }
}
