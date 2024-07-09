package Math.FindtheWinneroftheCircularGame;

import java.util.*;

/*
LeetCode:- 1823. Find the Winner of the Circular Game
Link:- https://leetcode.com/problems/find-the-winner-of-the-circular-game/description/?envType=daily-question&envId=2024-07-08

There are n friends that are playing a game. The friends are sitting in a circle and are numbered from 1 to n
in clockwise order. More formally, moving clockwise from the ith friend brings you to the (i+1)th friend
for 1 <= i < n, and moving clockwise from the nth friend brings you to the 1st friend.

The rules of the game are as follows:

1. Start at the 1st friend.
2. Count the next k friends in the clockwise direction including the friend you started at.
The counting wraps around the circle and may count some friends more than once.

3. The last friend you counted leaves the circle and loses the game.
4. If there is still more than one friend in the circle, go back to step 2 starting from the friend
immediately clockwise of the friend who just lost and repeat.

5. Else, the last friend in the circle wins the game.

Given the number of friends, n, and an integer k, return the winner of the game.
Constraints:

1 <= k <= n <= 500
 */
public class FindtheWinneroftheCircularGame {
    public static class Solution {
        public int findTheWinner(int n, int k) {
            boolean[] loosers = new boolean[n];
            int friend = 1, tern = k;
            while (n > 1){
                if (!loosers[friend - 1] && tern == 1){
                    loosers[friend - 1] = true;
                    tern = k;
                    n -= 1;
                }
                else if (loosers[friend - 1]){
                    if (friend == loosers.length){
                        friend = 1;
                    }
                    else{
                        friend += 1;
                    }
                    continue;
                }
                else{
                    tern -= 1;
                }
                if (friend == loosers.length){
                    friend = 1;
                }
                else{
                    friend += 1;
                }
            }
            for (int i = 0; i < loosers.length; i ++){
                if (!loosers[i]){
                    friend = i + 1;
                    break;
                }
            }
            return friend;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution s = new Solution();
        System.out.print("Enter the no of cases: ");
        int T = sc.nextInt();
        while (T > 0){
            System.out.print("Enter the no of friends: ");
            int n = sc.nextInt();
            System.out.print("Enter the timer: ");
            int k = sc.nextInt();
            System.out.println(s.findTheWinner(n,k));
            T --;
        }
    }
}











