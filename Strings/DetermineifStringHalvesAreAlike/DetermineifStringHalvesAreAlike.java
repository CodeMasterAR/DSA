package Strings.DetermineifStringHalvesAreAlike;

import java.util.*;

/*
LeetCode:- 1704. Determine if String Halves Are Alike
Link:- https://leetcode.com/problems/determine-if-string-halves-are-alike/description/

You are given a string s of even length. Split this string into two halves of equal lengths,
and let a be the first half and b be the second half.

Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U').
Notice that s contains uppercase and lowercase letters.

Return true if a and b are alike. Otherwise, return false.

 Constraints:

2 <= s.length <= 1000
s.length is even.
s consists of uppercase and lowercase letters.
 */

public class DetermineifStringHalvesAreAlike {
    public static class Solution{
        public boolean halvesAreAlike(String s) {
            int n = s.length();
            int countFirstHalf = 0, countSecondHalf = 0;
            for (int i = 0; i < n / 2; i ++){
                countFirstHalf += magicalSwitchCase(s.charAt(i));
                countSecondHalf += magicalSwitchCase(s.charAt(n/2 + i));
            }
            return (countFirstHalf == countSecondHalf);
        }
        public int magicalSwitchCase(char ch){
            switch(Character.toLowerCase(ch)){
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    return 1;
                default:
                    return 0;
            }
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
            System.out.print(s.halvesAreAlike(S));
            T --;
        }
    }
}
