package BinarySearch.MinimumNumberOfDaysToMake_m_Bouquets;

import java.util.*;

/*
LeetCode:- 1482. Minimum Number of Days to Make m Bouquets
Link:- https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/?envType=daily-question&envId=2024-06-19

You are given an integer array bloomDay, an integer m and an integer k.

You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.

The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.

Return the minimum number of days you need to wait to be able to make m bouquets from the garden.
If it is impossible to make m bouquets return -1.

Constraints:

bloomDay.length == n
1 <= n <= 105
1 <= bloomDay[i] <= 109
1 <= m <= 106
1 <= k <= n
 */

public class MinimumNumberOfDaysToMake_m_Bouquets {

    public static class Solution{

        public int minDays(int[] bloomDay, int m, int k) {
            int n = bloomDay.length;
            int minDay = -1;
            int max = bloomDay[0];
            for (int i = 1; i < n; i ++){
                max = Math.max(max, bloomDay[i]);
            }
            int start = 1, end = max ;
            while (start <= end){
                int mid = start + (end - start) / 2;
                if (canMakeBouq(bloomDay, mid, k) >= m){
                    minDay = mid;
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
            return minDay;
        }

        public int canMakeBouq(int[] bloomDay, int mid, int k){
            int bouqCount              = 0;
            int consecutive_count = 0;
            for (int i = 0; i < bloomDay.length; i ++){
                if (bloomDay[i] <= mid){
                    consecutive_count ++;
                }
                else{
                    consecutive_count = 0;
                }
                if (consecutive_count == k){
                    bouqCount ++;
                    consecutive_count = 0;
                }
            }
            return bouqCount;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution s = new Solution();
        System.out.print("Enter the no of cases: ");
        int T = sc.nextInt();
        while (T > 0){
            System.out.print("Enter the no of flowers: ");
            int n = sc.nextInt();
            int[] bloomDay = new int[n];
            System.out.print("Enter the bloom day of all flowers: ");
            for (int i = 0; i < n; i ++){
                bloomDay[i] = sc.nextInt();
            }
            System.out.print("Enter the no of bouquets: ");
            int m = sc.nextInt();
            System.out.print("Enter the no of adjacent flowers: ");
            int k = sc.nextInt();
            System.out.println(s.minDays(bloomDay,m,k));
            T--;
        }
    }
}
