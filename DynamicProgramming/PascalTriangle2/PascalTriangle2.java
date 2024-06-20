package DynamicProgramming.PascalTriangle2;

import java.util.*;

/*
LeetCode:- 119. Pascal's Triangle II
Link:- https://leetcode.com/problems/pascals-triangle-ii/description/

Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

Constraints:

0 <= rowIndex <= 33
 */

public class PascalTriangle2 {
    public static class Solution{
        public List<Integer> getRow(int rowIndex) {
            List<Integer> result = new ArrayList<>();
            result.add(1);
            if (rowIndex == 0){
                return result;
            }
            for (int i = 1; i <= rowIndex; i ++){
                int start = 0, end = result.size() - 1;
                for (int j = start; j < end; j ++){
                    result.add(result.get(j) + result.get(j + 1));
                }
                result.add(1);
                for (int j = 0; j <= i - 2; j ++){
                    result.remove(0);
                }
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
            System.out.print("Enter the rowIndex: ");
            int rowIndex = sc.nextInt();
            System.out.println(s.getRow(rowIndex).toString());
            T --;
        }
    }
}
