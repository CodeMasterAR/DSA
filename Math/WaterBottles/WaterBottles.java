package Math.WaterBottles;

import java.util.*;

/*
LeetCodeL:- 1518. Water Bottles
Link:- https://leetcode.com/problems/water-bottles/description/?envType=daily-question&envId=2024-07-07

There are numBottles water bottles that are initially full of water.
You can exchange numExchange empty water bottles from the market with one full water bottle.

The operation of drinking a full water bottle turns it into an empty bottle.

Given the two integers numBottles and numExchange, return the maximum number of water bottles you can drink.

Constraints:

1 <= numBottles <= 100
2 <= numExchange <= 100
 */

public class WaterBottles {
    public static class Solution {
        public int numWaterBottles(int numBottles, int numExchange) {
            int consumed = 0;
            while (numBottles >= numExchange){
                consumed += numExchange;
                numBottles = numBottles - numExchange + 1;
            }
            return consumed + numBottles;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution s = new Solution();
        System.out.print("Enter the no of cases: ");
        int T = sc.nextInt();
        while (T > 0){
            System.out.print("Enter the numBottle: ");
            int numBottle = sc.nextInt();
            System.out.print("Enter the numExchange ");
            int numExchange = sc.nextInt();
            System.out.println(s.numWaterBottles(numBottle, numExchange));
            T --;
        }
    }
}
