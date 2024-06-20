package DynamicProgramming.PascalTriangle;

import java.util.*;

/*
LeetCode:- 118. Pascal's Triangle
Link:- https://leetcode.com/problems/pascals-triangle/description/

Given an integer numRows, return the first numRows of Pascal's triangle.

Constraints:

1 <= numRows <= 30
 */

public class PascalTriangle {

    public static class Solution{
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            result.get(0).add(1);
            if (numRows == 1){
                return result;
            }
            for (int i = 1; i < numRows; i ++){
                result.add(new ArrayList<>());
            }
            for (int i = 1; i < numRows; i ++){
                int start = 0, end = result.get(i - 1).size() - 1;
                result.get(i).add(result.get(i - 1).get(start));
                for (int j = start; j < end ; j ++){
                    result.get(i).add(result.get(i-1).get(j) + result.get(i-1).get(j+1));
                }
                result.get(i).add(result.get(i - 1).get(end));
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
            System.out.print("Enter the num of Rows: ");
            int numRows = sc.nextInt();
            System.out.println(s.generate(numRows).toString());
            T --;
        }
    }
}
