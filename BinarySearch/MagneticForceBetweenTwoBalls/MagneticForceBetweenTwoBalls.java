package BinarySearch.MagneticForceBetweenTwoBalls;

import java.util.*;

/*
LeetCode:- 1552. Magnetic Force Between Two Balls
Link:- https://leetcode.com/problems/magnetic-force-between-two-balls/description/?envType=daily-question&envId=2024-06-20

In the universe Earth C-137, Rick discovered a special form of magnetic force between two balls if they are put in his new invented basket.
Rick has n empty baskets, the ith basket is at position[i], Morty has m balls and needs to distribute the balls into the baskets
such that the minimum magnetic force between any two balls is maximum.

Rick stated that magnetic force between two different balls at positions x and y is |x - y|.

Given the integer array position and the integer m. Return the required force.

Constraints:

n == position.length
2 <= n <= 105
1 <= position[i] <= 109
All integers in position are distinct.
2 <= m <= position.length
 */
public class MagneticForceBetweenTwoBalls {
    public static class Solution{
        public int maxDistance(int[] position, int m) {
            int n = position.length;
            Arrays.sort(position);
            int minForce = 1, maxForce = position[n - 1];
            int result = 1;
            while (minForce <= maxForce){
                int midForce = minForce + (maxForce - minForce)/2;
                if (possibleToPlace(midForce, position, m)){
                    result = midForce;
                    minForce = midForce + 1;
                }
                else{
                    maxForce = midForce - 1;
                }
            }
            return result;
        }

        public boolean possibleToPlace(int force, int[] position, int m){
            int prev = position[0];
            int countBall = 1;

            for (int i = 0; i < position.length; i ++){
                int curr = position[i];
                if (curr - prev >= force){
                    countBall ++;
                    prev = curr;
                }
                if (countBall == m)
                    break;
            }
            return (countBall == m);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution s = new Solution();
        System.out.print("Enter the no of cases: ");
        int T = sc.nextInt();
        while (T  > 0){
            System.out.print("Enter the no of buckets: ");
            int n = sc.nextInt();
            int[] position = new int[n];
            System.out.print("Enter the position of the buckets: ");
            for (int i = 0; i < n; i++){
                position[i] = sc.nextInt();
            }
            System.out.print("Enter the no of balls: ");
            int  m = sc.nextInt();
            System.out.println(s.maxDistance(position, m));
            T --;
        }
    }
}
