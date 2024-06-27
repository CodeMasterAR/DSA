package SlidingWindow.ContainsDuplicate2;

import java.util.*;

/*
LeetCode:- 219. Contains Duplicate II
Link:- https://leetcode.com/problems/contains-duplicate-ii/description/
Company:- Airbnb, Palantir Technologies

Given an integer array nums and an integer k,
return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109
0 <= k <= 105
 */

public class ContainsDuplicate2 {
    public static class Solution{
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            int n = nums.length;

//            Approach 1    Time Complexity O(n^2)
//            for (int i = 0; i < n; i++){int j = i + 1;while (j < n && j <= i + k){if (nums[i] == nums[j]){return true;}j++;}}return false;

//            Approach 2    Time Complexity is O(n)
//            HashMap<Integer, Integer> map = new HashMap<>();for (int i = 0; i < n; i ++){if (map.containsKey(nums[i])){iint ind = map.get(i);if (Math.abs(i - ind) <= k) return true;map.replace(nums[i], i);}else{map.put(nums[i], i);}}return false;

//            Approach 3    Time complexity is O(n)
            Set<Integer> set = new HashSet<>();int i = 0, j = 0;while (j < n){if (Math.abs(j - i) <= k){if (!set.contains(nums[j])) set.add(nums[j]);else return true;j ++;}else {set.remove(nums[i]);i++;}}return false;
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
            System.out.println(s.containsNearbyDuplicate(nums, k));
            T--;
        }
    }
}
