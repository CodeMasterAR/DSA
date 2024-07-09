package LinkedList.FindtheMinimumandMaximumNumberofNodesBetweenCriticalPoints;

import java.util.*;
import LinkedList.*;

public class FindtheMinimumandMaximumNumberofNodesBetweenCriticalPoints {
    public static class Solution {
        public int[] nodesBetweenCriticalPoints(ListNode head) {
            return new int[]{-1,-1};
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution s = new Solution();
        System.out.print("Enter the no of cases: ");
        int T = sc.nextInt();
        while(T > 0){
            sc.nextLine();
            System.out.print("Enter the node as a list (eg. 1,2,3,4): ");
            String[] nodes = sc.nextLine().split(",");
            SinglyList sl = new SinglyList();
            System.out.println("Original List: ");
            ListNode head = sl.buildList(nodes, sl);
            sl.printList(head);
            System.out.println(Arrays.toString(s.nodesBetweenCriticalPoints(head)));
            T --;
        }
    }
}










