package SlidingWindow.GrumpyBookstoreOwner;

import java.util.*;

/*
LeetCode:- 1052. Grumpy Bookstore Owner
Link:- https://leetcode.com/problems/grumpy-bookstore-owner/description/?envType=daily-question&envId=2024-06-21

There is a bookstore owner that has a store open for n minutes. Every minute, some number of customers enter the store.
You are given an integer array customers of length n where customers[i] is the number of the customer that enters
the store at the start of the ith minute and all those customers leave after the end of that minute.

On some minutes, the bookstore owner is grumpy. You are given a binary array grumpy where grumpy[i] is 1
if the bookstore owner is grumpy during the ith minute, and is 0 otherwise.

When the bookstore owner is grumpy, the customers of that minute are not satisfied, otherwise, they are satisfied.

The bookstore owner knows a secret technique to keep themselves not grumpy for minutes consecutive minutes,
but can only use it once.

Return the maximum number of customers that can be satisfied throughout the day.

Constraints:

n == customers.length == grumpy.length
1 <= minutes <= n <= 2 * 104
0 <= customers[i] <= 1000
grumpy[i] is either 0 or 1.
 */
public class GrumpyBookstoreOwner {
    public static class Solution{
        public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
            int n = customers.length;
            int unsatisfied = 0;
            int satisfied = 0;
            for (int i = 0; i < minutes; i ++){
                if (grumpy[i] == 1){
                    unsatisfied += customers[i];
                }
            }
            int maxUnsatisfied = unsatisfied;
            for (int i = 1; i < n - minutes + 1; i ++){
                if (grumpy[i - 1] == 1){
                    unsatisfied -= customers[i - 1];
                }
                if (grumpy[i + minutes - 1] == 1){
                    unsatisfied += customers[i + minutes - 1];
                }
                maxUnsatisfied = Math.max(maxUnsatisfied, unsatisfied);
            }
            for (int i = 0; i < n; i ++){
                if (grumpy[i] == 0){
                    satisfied += customers[i];
                }
            }
            return satisfied + maxUnsatisfied;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution s = new Solution();
        System.out.print("Enter the no of cases: ");
        int T = sc.nextInt();
        while (T  > 0){
            System.out.print("Enter the total minutes: ");
            int n = sc.nextInt();
            int[] customers = new int[n];
            System.out.print("Enter the number of customer per minutes: ");
            for (int i = 0; i < n; i ++){
                customers[i] = sc.nextInt();
            }
            int[] grumpy = new int[n];
            System.out.print("Enter the behaviour of owner: ");
            for (int i = 0; i < n; i ++){
                grumpy[i] = sc.nextInt();
            }
            System.out.print("Enter the consecutive minutes for not grumpy: ");
            int minutes = sc.nextInt();
            System.out.println(s.maxSatisfied(customers, grumpy, minutes));
            T --;
        }
    }
}
