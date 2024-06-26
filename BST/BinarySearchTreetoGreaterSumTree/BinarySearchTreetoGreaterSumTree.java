package BST.BinarySearchTreetoGreaterSumTree;

import BST.Tree;
import BST.Tree.*;
import java.util.*;

/*
LeetCode:- 1038. Binary Search Tree to Greater Sum Tree
Link:- https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/description/?envType=daily-question&envId=2024-06-25

Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus the sum of all keys greater than the original key in BST.

As a reminder, a binary search tree is a tree that satisfies these constraints:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

Constraints:

The number of nodes in the tree is in the range [1, 100].
0 <= Node.val <= 100
All the values in the tree are unique.
 */

public class BinarySearchTreetoGreaterSumTree {

    public static class Solution {

        public TreeNode bstToGst(TreeNode root) {
            int[] sum = {0};
            solve(root,sum);
            return root;
        }

        public void solve(TreeNode node, int[] sum){
            if (node == null){
                return;
            }
            solve(node.right, sum);
            sum[0] += node.val;
            node.val =  sum[0];
            solve(node.left, sum);
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            Solution s = new Solution();
            System.out.print("Enter the no of cases: ");
            int T = sc.nextInt();
            while (T > 0){
                sc.nextLine(); // consume newline
                System.out.print("Enter the nodes as a list (e.g., 4,1,6,0,2,5,7,null,null,null,3,null,null,null,8): ");
                String[] nodes = sc.nextLine().split(",");
                Tree tree = new Tree();
                System.out.println("Original BST:");
                TreeNode root = tree.buildTree(nodes, tree);
                tree.printTree(root);
                TreeNode gstRoot = s.bstToGst(root);
                System.out.println("Greater Sum Tree:");
                tree.printTree(gstRoot);
                T--;
            }
        }

    }
}
