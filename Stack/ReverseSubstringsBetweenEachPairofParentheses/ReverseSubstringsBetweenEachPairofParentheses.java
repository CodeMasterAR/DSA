package Stack.ReverseSubstringsBetweenEachPairofParentheses;

import java.util.*;

/*
LeetCode:- 1190. Reverse Substrings Between Each Pair of Parentheses
Link:- https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/description/?envType=daily-question&envId=2024-07-11

You are given a string s that consists of lower case English letters and brackets.

Reverse the strings in each pair of matching parentheses, starting from the innermost one.

Your result should not contain any brackets.

Constraints:

1 <= s.length <= 2000
s only contains lower case English characters and parentheses.
It is guaranteed that all parentheses are balanced.
 */

public class ReverseSubstringsBetweenEachPairofParentheses {
    public static class Solution {
        public String reverseParentheses(String s) {
            Stack<StringBuilder> str = new Stack<>();
            for (int i = 0; i < s.length(); i ++) {
                char ch = s.charAt(i);
                if (str.empty()){
                    str.push(new StringBuilder());
                }
                if (ch == '(') {
                    str.push(new StringBuilder());
                    continue;
                } else if (ch == ')') {
                    StringBuilder topStr = str.pop().reverse();
                    str.peek().append(topStr);
                    continue;
                }
                str.peek().append(ch);

            }
            return str.peek().toString();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution s = new Solution();
        System.out.print("Enter the no of cases: ");
        int T = sc.nextInt();
        while (T > 0){
            sc.nextLine();
            System.out.print("Enter the String: ");
            String str = sc.nextLine();
            System.out.println(s.reverseParentheses(str));
            T --;
        }
    }
}
