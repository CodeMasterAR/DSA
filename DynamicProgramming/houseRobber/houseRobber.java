package DynamicProgramming.houseRobber;

import java.util.*;

/*
LeetCode:- 198. House Robber
Link:- https://leetcode.com/problems/house-robber/

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected
and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house,
return the maximum amount of money you can rob tonight without alerting the police.

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 400
 */

public class houseRobber {
    public static class Solution{
        public int rob(int[] nums) {
            int n = nums.length;
            return 0;
        }

//        public int solve(){
//
//        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution s = new Solution();
        System.out.println("Enter the no of cases: ");
        int T = sc.nextInt();
        while (T > 0){
            System.out.print("Enter the no of houses: ");
            int n = sc. nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i ++){
                nums[i] = sc.nextInt();
            }
            System.out.println(s.rob(nums));
            T --;
        }
    }
}
