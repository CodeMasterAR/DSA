package Array.LuckyNumbersinaMatrix;

import java.util.*;

/*
LeetCode:- 1380. Lucky Numbers in a Matrix
Link:- https://leetcode.com/problems/lucky-numbers-in-a-matrix/description/?envType=daily-question&envId=2024-07-19

Given an m x n matrix of distinct numbers, return all lucky numbers in the matrix in any order.

A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.

Constraints:

m == mat.length
n == mat[i].length
1 <= n, m <= 50
1 <= matrix[i][j] <= 105.
All elements in the matrix are distinct.
 */

public class LuckyNumbersinaMatrix {
    public static class Solution {
        public List<Integer> luckyNumbers (int[][] matrix) {
            List<Integer> list = new ArrayList<>();
            return new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution s = new Solution();
        System.out.print("Enter the no of cases: ");
        int T = sc.nextInt();
        while (T > 0){
            System.out.print("Enter the no of rows: ");
            int rows = sc.nextInt();
            System.out.print("Enter the no of columns: ");
            int columns = sc.nextInt();
            int[][] matrix = new int[rows][columns];
            System.out.print("Enter the values of matrix: ");
            for (int i = 0; i < rows; i ++){
                for (int j = 0; j < columns; j ++){
                    matrix[i][j] = sc.nextInt();
                }
            }
            System.out.println("You Matrix: ");
            System.out.print("[");
            for (int i = 0; i < rows; i ++){
                if (i < rows - 1){
                    System.out.print(Arrays.toString(matrix[i]) + ", ");
                    continue;
                }
                System.out.print(Arrays.toString(matrix[i]));
            }
            System.out.println("]");
            T --;
        }
    }
}
