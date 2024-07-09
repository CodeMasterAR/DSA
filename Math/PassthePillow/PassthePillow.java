package Math.PassthePillow;

import java.util.*;

/*
LeetCode:- 2582. Pass the Pillow
Link:- https://leetcode.com/problems/pass-the-pillow/description/?envType=daily-question&envId=2024-07-06

There are n people standing in a line labeled from 1 to n. The first person in the line is holding a pillow initially.
Every second, the person holding the pillow passes it to the next person standing in the line.
Once the pillow reaches the end of the line, the direction changes, and people continue passing
the pillow in the opposite direction.

For example, once the pillow reaches the nth person they pass it to the n - 1th person,
then to the n - 2th person and so on.

Given the two positive integers n and time, return the index of the person holding the pillow after time seconds.

Constraints:

2 <= n <= 1000
1 <= time <= 1000
 */

public class PassthePillow {
    public static class Solution{
        public int passThePillow(int n, int time)
        {
            return ((time / (n-1)) % 2 == 0) ? (time % (n-1)) + 1 : n - (time % (n-1));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution s = new Solution();
        System.out.print("Enter the no of cases: ");
        int T = sc.nextInt();
        while (T > 0){
            System.out.print("Enter the no of people: ");
            int n = sc.nextInt();
            System.out.print("Enter the time: ");
            int t = sc.nextInt();
            System.out.println(s.passThePillow(n,t));
            T --;
        }
    }
}
