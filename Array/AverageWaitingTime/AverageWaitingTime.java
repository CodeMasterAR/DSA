package Array.AverageWaitingTime;

import java.util.*;

/*
LeetCode:- 1701. Average Waiting Time
Link:- https://leetcode.com/problems/average-waiting-time/description/?envType=daily-question&envId=2024-07-09

There is a restaurant with a single chef. You are given an array customers, where customers[i] = [arrivali, timei]:

arrivali is the arrival time of the ith customer. The arrival times are sorted in non-decreasing order.
timei is the time needed to prepare the order of the ith customer.
When a customer arrives, he gives the chef his order, and the chef starts preparing it once he is idle.
The customer waits till the chef finishes preparing his order. The chef does not prepare food for more than one
customer at a time. The chef prepares food for customers in the order they were given in the input.

Return the average waiting time of all customers. Solutions within 10-5 from the actual answer are considered accepted.

Constraints:

1 <= customers.length <= 105
1 <= arrivali, timei <= 104
arrivali <= arrivali+1
 */

public class AverageWaitingTime {
    public static class Solution {
        public double averageWaitingTime(int[][] customers) {
            int n = customers.length;
            double sumOfAllAvgWaitingTime = 0;
            int orderCompleteTime = 0;
            for (int i = 0; i < n; i ++){
                orderCompleteTime = (orderCompleteTime < customers[i][0]) ? customers[i][0] : orderCompleteTime;
                orderCompleteTime = orderCompleteTime + customers[i][1];
                sumOfAllAvgWaitingTime += orderCompleteTime - customers[i][0];

            }
            return (double) sumOfAllAvgWaitingTime/n;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution s = new Solution();
        System.out.print("Enter the no of cases: ");
        int T = sc.nextInt();
        while (T > 0){
            System.out.print("Enter the no of customers: ");
            int n = sc.nextInt();
            int[][] customers = new int[n][2];
            System.out.print("Enter the arrival time and waiting time of customer: ");
            for (int i = 0; i < n; i ++){
                customers[i][0] = sc.nextInt();
                customers[i][1] = sc.nextInt();
//                System.out.println();
            }
            System.out.print("Customer array: ");
            System.out.print("[");
            for (int i = 0; i < n; i ++){
                System.out.print(Arrays.toString(customers[i]) + (i == n - 1 ? "" : ", "));
            }
            System.out.println("]");
            System.out.print("Output: ");
            System.out.println(s.averageWaitingTime(customers));
            T --;
        }
    }
}
