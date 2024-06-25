package BST.BinarySearchTreetoGreaterSumTree;

import com.sun.source.tree.Tree;

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

    public static class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }

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
                TreeNode root = buildTree(nodes);
                System.out.println("Original BST:");
                printTree(root);
                TreeNode gstRoot = s.bstToGst(root);
                System.out.println("Greater Sum Tree:");
                printTree(gstRoot);
                T--;
            }
        }

        // Helper method to build the tree from the input array
        private static TreeNode buildTree(String[] nodes) {
            if (nodes == null || nodes.length == 0 || nodes[0].equals("null")) {
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int i = 1;
            while (!queue.isEmpty() && i < nodes.length) {
                TreeNode current = queue.poll();
                if (i < nodes.length && !nodes[i].equals("null")) {
                    current.left = new TreeNode(Integer.parseInt(nodes[i]));
                    queue.add(current.left);
                }
                i++;
                if (i < nodes.length && !nodes[i].equals("null")) {
                    current.right = new TreeNode(Integer.parseInt(nodes[i]));
                    queue.add(current.right);
                }
                i++;
            }
            return root;
        }

        // Helper method to print the tree in level order
        private static void printTree(TreeNode root) {
            if (root == null) {
                System.out.println("null");
                return;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode current = queue.poll();
                if (current == null) {
                    System.out.print("null ");
                } else {
                    System.out.print(current.val + " ");
                    queue.add(current.left);
                    queue.add(current.right);
                }
            }
            System.out.println();
        }
    }
}
