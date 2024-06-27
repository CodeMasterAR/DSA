package SlidingWindow.KRadiusSubarrayAverages;

import java.util.*;

/*
LeetCode:- 2090. K Radius Subarray Averages
Link:- https://leetcode.com/problems/k-radius-subarray-averages/description/
Company: Amazon

You are given a 0-indexed array nums of n integers, and an integer k.

The k-radius average for a subarray of nums centered at some index i with the radius k is the average of
all elements in nums between the indices i - k and i + k (inclusive). If there are less than k elements before or after the index i,
then the k-radius average is -1.

Build and return an array avgs of length n where avgs[i] is the k-radius average for the subarray centered at index i.

The average of x elements is the sum of the x elements divided by x, using integer division. The integer division truncates toward zero,
which means losing its fractional part.

For example, the average of four elements 2, 3, 1, and 5 is (2 + 3 + 1 + 5) / 4 = 11 / 4 = 2.75, which truncates to 2.

Constraints:

n == nums.length
1 <= n <= 105
0 <= nums[i], k <= 105
 */

public class KRadiusSubarrayAverages {
    public static class Solution{
        public int[] getAverages(int[] nums, int k) {
            int n = nums.length;

            // If k is 0, the averages are the same as the original array
            if (k == 0) return nums;

            // Initialize the result array with -1
            int[] result = new int[n];
            for (int i = 0; i < n; i++) {
                result[i] = -1;
            }

            // If the array length is less than the required window size, return the initialized result
            if (n < 2 * k + 1) return result;

            int left = 0, right = 2 * k;
            long window = 0;

            // Compute the sum of the first window
            for (int j = left; j <= right; j++) {
                window += nums[j];
            }

            int count = 2 * k + 1;
            int i = k;

            // Calculate the average for the first window
            result[i] = (int) (window / count);
            i++;
            right++;

            // Slide the window across the array
            while (right < n) {
                window += nums[right] - nums[left];
                result[i] = (int) (window / count);
                i++;
                right++;
                left++;
            }

            return result;
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
            System.out.print("Enter the value of k: ");
            int k = sc.nextInt();
            System.out.println(Arrays.toString(s.getAverages(nums, k)));
            T --;
        }
    }
}
