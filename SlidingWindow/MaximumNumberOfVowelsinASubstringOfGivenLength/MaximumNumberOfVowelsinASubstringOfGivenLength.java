package SlidingWindow.MaximumNumberOfVowelsinASubstringOfGivenLength;

import java.util.*;
import java.util.function.Predicate;

/*
LeetCode:- 1456. Maximum Number of Vowels in a Substring of Given Length
Link:- https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/
Company:- Microsoft

Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.

Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.
1 <= k <= s.length
 */
public class MaximumNumberOfVowelsinASubstringOfGivenLength {
    public static class Solution{
        public int maxVowels(String s, int k) {
                int i = 0, j = 0, countVowels = 0, n = s.length();
                int maxCount = 0;
                Predicate<Character> isVowel = (ch) -> "aeiou".indexOf(ch) != -1;
                while (j < n){
                    char ch = s.charAt(j);
                    if (isVowel.test(ch)) countVowels ++;
                    if (j - i +  1 == k){
                        maxCount = Math.max(countVowels, maxCount);
                        if (isVowel.test(s.charAt(i)))  countVowels --;
                        i ++;
                    }
                    j ++;
                }
                return maxCount;
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
            System.out.print("Enter the k: ");
            int k = sc.nextInt();
            System.out.println(s.maxVowels(S, k))   ;
            T --;
        }
    }
}
