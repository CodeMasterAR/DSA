package Strings.RepeatedSubstringPattern;

import java.util.*;

/*
LeetCode:- 459. Repeated Substring Pattern
Link:- https://leetcode.com/problems/repeated-substring-pattern/description/

Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.

Constraints:

1 <= s.length <= 104
s consists of lowercase English letters.
 */
public class RepeatedSubstringPattern {
    public static class Solution{

//        Total time complexity is O(2√n)*O(2n) ≈ O(√n*n)
        public boolean repeatedSubstringPattern(String s) {
            int n = s.length();

//            Outer loop run for 2√n times
            for (int i = n/2; i > 0; i --){
                if (n % i != 0){continue;}
                StringBuilder sb = new StringBuilder();
                int times = n / i;
                String subString = s.substring(0, i); // This inbuilt function runs for O(n) time.
                while (times > 0){  // This loop runs for n / i times
                    sb.append(subString);
                    times --;
                }
                if (s.equals(sb.toString())){return true;}
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
            System.out.println(s.repeatedSubstringPattern(S));
            T --;
        }
    }
}
