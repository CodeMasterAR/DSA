package Stack.CrawlerLogFolder;

import java.util.*;

/*
LeetCode:- 1598. Crawler Log Folder
Link:- https://leetcode.com/problems/crawler-log-folder/description/?envType=daily-question&envId=2024-07-10

The Leetcode file system keeps a log each time some user performs a change folder operation.

The operations are described below:

"../" : Move to the parent folder of the current folder. (If you are already in the main folder,
remain in the same folder).
"./" : Remain in the same folder.
"x/" : Move to the child folder named x (This folder is guaranteed to always exist).
You are given a list of strings logs where logs[i] is the operation performed by the user at the ith step.

The file system starts in the main folder, then the operations in logs are performed.

Return the minimum number of operations needed to go back to the main folder after the change folder operations.

Constraints:

1 <= logs.length <= 103
2 <= logs[i].length <= 10
logs[i] contains lowercase English letters, digits, '.', and '/'.
logs[i] follows the format described in the statement.
Folder names consist of lowercase English letters and digits.
 */

public class CrawlerLogFolder {
    public static class Solution {
        public int minOperations(String[] logs) {
            Stack<String> log = new Stack<>();
            int n = logs.length;
            for (String str: logs){
                if (str.equals("./") || (str.equals("../") && log.empty())){
                    continue;
                }
                Runnable action = str.equals("../") ? log::pop : () -> log.push(str);
                action.run();
            }
            return log.size();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution s = new Solution();
        System.out.print("Enter the no of cases: ");
        int T = sc.nextInt();
        while (T > 0){
            System.out.print("Enter the no of log: ");
            int n = sc.nextInt();
            sc.nextLine();
            String[] logs = new String[n];
            System.out.print("Enter the logs: ");
            for (int i = 0; i < n; i ++){
                logs[i] = sc.nextLine();
            }
            System.out.println(s.minOperations(logs));
            T --;
        }
    }
}























