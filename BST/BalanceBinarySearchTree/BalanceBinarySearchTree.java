package BST.BalanceBinarySearchTree;

import BST.BSTree;
import BST.BSTree.*;
import java.util.*;

/*
LeetCode:- 1382. Balance a Binary Search Tree
Link:- https://leetcode.com/problems/balance-a-binary-search-tree/description/?envType=daily-question&envId=2024-06-26

Given the root of a binary search tree, return a balanced binary search tree with the same node values.
If there is more than one answer, return any of them.

A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.


Constraints:

The number of nodes in the tree is in the range [1, 104].
1 <= Node.val <= 105
 */

public class BalanceBinarySearchTree {

    public static class Solution{
        public TreeNode balanceBST(TreeNode root) {
            if(root == null){
                return null;
            }
            ArrayList<Integer> treeNodes = new ArrayList<>();
            inorderTraversal(treeNodes, root);
            int n = treeNodes.size();
            return solve(0, n - 1, treeNodes);
        }
        void inorderTraversal(List<Integer> treeNodes, TreeNode node){
            if (node == null){
                return;
            }
            inorderTraversal(treeNodes, node.left);
            treeNodes.add(node.val);
            inorderTraversal(treeNodes, node.right);
        }
        TreeNode  solve(int start, int end, List<Integer> treeNodes){
            if(start > end){
                return null;
            }
            int mid = start + (end - start)/2;
            TreeNode node = new TreeNode(treeNodes.get(mid));
            node.left = solve(start, mid - 1, treeNodes);
            node.right = solve(mid + 1, end, treeNodes);
            return node;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution s = new Solution();
        System.out.print("Enter the no of cases: ");
        int T = sc.nextInt();
        while (T > 0){
            sc.nextLine();
            System.out.print("Enter the nodes as a list (eg., 4,1,6,0,2,5,7,null,null,null,3,null,null,null,8): ");
            String[] nodes = sc.nextLine().split(",");
            BSTree tree = new BSTree();
            System.out.println("Original String: ");
            TreeNode root = tree.buildTree(nodes, tree);
            tree.printTree(root);
            TreeNode balanceBSTRoot = s.balanceBST(root);
            System.out.println("Balance BST: ");
            tree.printTree(balanceBSTRoot);
            T --;
        }
    }
}
