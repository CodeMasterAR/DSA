package SlidingWindow.LongestSubarrayOf1sAfterDeletingOneElement;

import java.util.*;


/*
LeetCode:- 1493. Longest Subarray of 1's After Deleting One Element
Link:- https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description/
Company:- Google, Meta

Given a binary array nums, you should delete one element from it.

Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
 */

public class LongestSubarrayOf1sAfterDeletingOneElement {
    public static class Solution{
        public int longestSubarray(int[] nums) {
            int n = nums.length;
            int i = 0, j = 0, countZeros = 0, maxLength = 0, currentLength = 0;
            while (j < n){
                if (nums[j] == 0){
                    if (countZeros == 0){
                        countZeros ++;
                        j ++;
                    }
                    else {
                        while (nums[i] != 0){
                            i++;
                            currentLength --;
                        }
                        i++;j++;
                    }
                }
                else{
                    currentLength ++;
                    maxLength = Math.max(currentLength, maxLength);
                    j++;
                }
            }
            if (maxLength == n){
                return n - 1;
            }
            return maxLength;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution s = new Solution();
        System.out.print("Enter the no of cases: ");
        int T = sc.nextInt();
        while (T > 0){
            System.out.print("Enter the length of array: ");
            int n = sc.nextInt();
            int[] nums = new int[n];
            System.out.print("Enter the values: ");
            for (int i = 0; i < n; i ++){
                nums[i] = sc.nextInt();
            }
            System.out.println(s.longestSubarray(nums));
            T --;
        }
    }
}
