package Strings.DetectCapital;

import java.util.*;

/*
LeetCode:- 520. Detect Capital
Link:- https://leetcode.com/problems/detect-capital/description/
Company: Google

We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital, like "Google".
Given a string word, return true if the usage of capitals in it is right.


Constraints:

1 <= word.length <= 100
word consists of lowercase and uppercase English letters.
 */

public class DetectCapital {
    public static class Solution{
        public boolean detectCapitalUse(String word) {

//            Approach 1
//            return (case1(word) || case2(word)|| case2(word.substring(1)));

            //            Approach 2
            int n = word.length();
            int countCapital = 0;
            for (int i = 0; i < n; i ++){
                if (Character.isUpperCase(word.charAt(i))){
                    countCapital ++;
                }
            }
            if (countCapital == n || countCapital == 0 || (countCapital == 1 && Character.isUpperCase(word.charAt(0)))){
                return true;
            }
            return false;
        }
        public boolean case1(String word){
            for (int i = 0; i < word.length(); i ++){
                if (Character.isLowerCase(word.charAt(i))){
                    return false;
                }
            }
            return true;
        }
        public boolean case2(String word){
            for (int i = 0; i < word.length(); i ++){
                if(Character.isUpperCase((word.charAt(i)))){
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution s = new Solution();
        System.out.print("Enter the no of cases: ");
        int T = sc.nextInt();
        while (T > 0){
            sc.nextLine();
            System.out.print("Enter the word: ");
            String word = sc.nextLine();
            System.out.println(s.detectCapitalUse(word));
            T --;
        }
    }
}
