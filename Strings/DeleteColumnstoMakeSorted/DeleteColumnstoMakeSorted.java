package Strings.DeleteColumnstoMakeSorted;

import java.util.*;

/*
LeetCode:- 944. Delete Columns to Make Sorted
Link:- https://leetcode.com/problems/delete-columns-to-make-sorted/description/
Company: Microsoft

You are given an array of n strings strs, all of the same length.

The strings can be arranged such that there is one on each line, making a grid.

For example, strs = ["abc", "bce", "cae"] can be arranged as follows:
abc
bce
cae
You want to delete the columns that are not sorted lexicographically. In the above example (0-indexed), columns 0 ('a', 'b', 'c')
and 2 ('c', 'e', 'e') are sorted, while column 1 ('b', 'c', 'a') is not, so you would delete column 1.

Return the number of columns that you will delete.

Constraints:

n == strs.length
1 <= n <= 100
1 <= strs[i].length <= 1000
strs[i] consists of lowercase English letters.
 */

public class DeleteColumnstoMakeSorted {
    public static class Solution{
        public int minDeletionSize(String[] strs) {
            int countColumns = 0;
            int len = strs[0].length();
            int n = strs.length;
            for (int i = 0; i < len; i ++){
//                char[] chars = new char[n];
//                char[] temp = new char[n];
                for (int j = 1; j < n; j ++){
                        if (strs[j].charAt(i) < strs[j - 1].charAt(i)){
                            countColumns ++;
                            break;
                        }
//                    chars[j] = strs[j].charAt(i);
//                    temp[j] = strs[j].charAt(i);
                }
//                Arrays.sort(temp);
//                if (!Arrays.equals(chars, temp)){
//                    countColumns ++;
//                }
            }
            return countColumns;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution s = new Solution();
        System.out.print("Enter the no of cases: ");
        int T = sc.nextInt();
        while (T > 0){
            System.out.print("Enter the length of string array: ");
            int n = sc.nextInt();
            sc.nextLine();
            String[] strs = new String[n];
            System.out.print("Enter the strings: ");
            for (int i = 0; i < n; i ++) {
                strs[i] = sc.nextLine();
            }
            System.out.println(s.minDeletionSize(strs));
            T --;
        }
    }
}
