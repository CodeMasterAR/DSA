package BinarySearch.MostProfitAssigningWork;

import java.util.*;
import java.util.Arrays;
import java.util.PriorityQueue;

/*
LeetCode:- 826. Most Profit Assigning Work
Link:- https://leetcode.com/problems/most-profit-assigning-work/description/?envType=daily-question&envId=2024-06-18

You have n jobs and m workers. You are given three arrays: difficulty, profit, and worker where:

difficulty[i] and profit[i] are the difficulty and the profit of the ith job, and
worker[j] is the ability of jth worker (i.e., the jth worker can only complete a job with difficulty at most worker[j]).
Every worker can be assigned at most one job, but one job can be completed multiple times.

For example, if three workers attempt the same job that pays $1, then the total profit will be $3. If a worker cannot
complete any job, their profit is $0.

Return the maximum profit we can achieve after assigning the workers to the jobs.

Constraints:

n == difficulty.length
n == profit.length
m == worker.length
1 <= n, m <= 104
1 <= difficulty[i], profit[i], worker[i] <= 105
 */

public class MostProfitAssigningWork {

    public static class Solution{

        public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

            int result = 0;
//            Approach 1 Using Binary Search

            int n = difficulty.length;
            int[][] pair = new int[n][2];
            for (int i = 0; i < n; i ++){
                pair[i][0] = difficulty[i];
                pair[i][1] = profit[i];
            }

            Arrays.sort(pair, (a,b)-> Integer.compare(a[0], b[0]));

            int farMaxProfit= pair[0][1];
            for (int i = 1; i < n; i ++){
                if (farMaxProfit > pair[i][1]){
                    pair[i][1] = farMaxProfit;
                }
                else {
                    farMaxProfit = pair[i][1];
                }
            }

            int m = worker.length;

            for (int i = 0; i < m; i ++){
                int profitGain = binarySearch(pair, worker[i]);
//                System.out.println(profitGain);
                result +=profitGain;
            }


//            Approach 2 using MaxHeap
            /*
            int n = difficulty.length;
            int m = worker.length;
            Arrays.sort(worker);
            for (int i = 0; i < m/2; i ++){
                int temp = worker[i];
                worker[i] = worker[m - 1 - i];
                worker[m - 1 - i] = temp;
            }

            PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[0] - a[0]);

            for (int i = 0; i < n; i ++){
                maxHeap.offer(new int[]{profit[i], difficulty[i]});
            }

            int i = 0;
            while (i < m && !maxHeap.isEmpty()){
                if (worker[i] < maxHeap.peek()[1]){
                    maxHeap.poll();
                }
                else{
                    result += maxHeap.peek()[0];
                    i++;
                }
            }
            */
            return result;
        }

        public int binarySearch(int[][] pair, int target){
            int start = 0, end = pair.length - 1;
            while (start <= end){
                int mid = start + (end - start)/2;

                if (target < pair[mid][0]){
                    end = mid - 1;
                }
                else if (target > pair[mid][0]){
                    start = mid + 1;
                }
                else{
                    return pair[mid][1];
                }
            }
            if (end < 0) {
                return 0;
            }
            return pair[end][1];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution s = new Solution();
        System.out.print("Enter the no of cases: ");
        int T = sc.nextInt();
        while (T > 0){
            System.out.print("Enter the no of jobs: ");
            int n = sc.nextInt();
            System.out.print("Enter the no of workers: ");
            int m = sc.nextInt();
            int[] difficulty = new int[n];
            int[] profit = new int[n];
            int[] worker = new int[m];
            System.out.print("Enter the difficulty of jobs: ");
            for (int i = 0; i < n; i ++){
                difficulty[i] = sc.nextInt();
            }
            System.out.print("Enter the profit from jobs: ");
            for (int i = 0; i < n; i ++){
                profit[i] = sc.nextInt();
            }
            System.out.print("Enter the worker ability: ");
            for (int i = 0; i < m; i ++){
                worker[i] = sc.nextInt();
            }
            System.out.println(s.maxProfitAssignment(difficulty, profit, worker));
            T --;
        }
    }
}
