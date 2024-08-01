package Stack.MaximumScoreFromRemovingSubstrings;

import java.util.*;

/*
LeetCode:- 1717. Maximum Score From Removing Substrings
Link:- https://leetcode.com/problems/maximum-score-from-removing-substrings/description/?envType=daily-question&envId=2024-07-12

You are given a string s and two integers x and y. You can perform two types of operations any number of times.

Remove substring "ab" and gain x points.
For example, when removing "ab" from "cabxbae" it becomes "cxbae".
Remove substring "ba" and gain y points.
For example, when removing "ba" from "cabxbae" it becomes "cabxe".
Return the maximum points you can gain after applying the above operations on s.

Constraints:

1 <= s.length <= 105
1 <= x, y <= 104
s consists of lowercase English letters.
 */

public class MaximumScoreFromRemovingSubstrings {
    public static class Solution {
        public int maximumGain(String s, int x, int y) {
            if (x < y) {
                // If y is greater than x, swap the operations to always prioritize the higher point gain
                return maximumGainHelper(s, y, x, 'b', 'a');
            } else {
                return maximumGainHelper(s, x, y, 'a', 'b');
            }
        }

        private int maximumGainHelper(String s, int higherPoints, int lowerPoints, char firstChar, char secondChar) {
            Stack<Character> stack = new Stack<>();
            int maxPoints = 0;

            // First pass to remove the higher points substrings
            for (char ch : s.toCharArray()) {
                if (!stack.isEmpty() && stack.peek() == firstChar && ch == secondChar) {
                    stack.pop();
                    maxPoints += higherPoints;
                } else {
                    stack.push(ch);
                }
            }

            // Second pass to remove the lower points substrings
            Stack<Character> stack2 = new Stack<>();
            while (!stack.isEmpty()) {
                char ch = stack.pop();
                if (!stack2.isEmpty() && stack2.peek() == firstChar && ch == secondChar) {
                    stack2.pop();
                    maxPoints += lowerPoints;
                } else {
                    stack2.push(ch);
                }
            }

            return maxPoints;
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            Solution s = new Solution();
            System.out.print("Enter the number of cases: ");
            int T = sc.nextInt();
            while (T > 0) {
                System.out.print("Enter the points for substring \"ab\": ");
                int x = sc.nextInt();
                System.out.print("Enter the points for substring \"ba\": ");
                int y = sc.nextInt();
                sc.nextLine(); // consume the newline
                System.out.print("Enter the String: ");
                String S = sc.nextLine();
                System.out.print("Output: ");
                System.out.println(s.maximumGain(S, x, y));
                T--;
            }
        }
    }
}