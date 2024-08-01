package BinaryTree.DeleteNodesAndReturnForest;

import java.util.*;

import BinaryTree.BTree;
import BinaryTree.BTree.TreeNode;
import BinaryTree.BTree.*;
import com.sun.source.tree.Tree;

/*
LeetCode:- 1110. Delete Nodes And Return Forest
Link:- https://leetcode.com/problems/delete-nodes-and-return-forest/description/?envType=daily-question&envId=2024-07-17

Given the root of a binary tree, each node in the tree has a distinct value.

After deleting all nodes with a value in to_delete, we are left with a forest
(a disjoint union of trees).

Return the roots of the trees in the remaining forest. You may return the result in any
order.

Constraints:

The number of nodes in the given tree is at most 1000.
Each node has a distinct value between 1 and 1000.
to_delete.length <= 1000
to_delete contains distinct values between 1 and 1000.
 */

public class DeleteNodesAndReturnForest {
    public static class Solution {
        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            HashSet<Integer> set = new HashSet<>();
            for (int val : to_delete) {
                set.add(val);
            }

            List<TreeNode> list = new ArrayList<>();
            if (!set.contains(root.val)) {
                list.add(root);
            }

            delNodesHelper(root, set, list);
            return list;
        }

        private TreeNode delNodesHelper(TreeNode node, HashSet<Integer> set, List<TreeNode> list) {
            if (node == null) {
                return null;
            }

            node.left = delNodesHelper(node.left, set, list);
            node.right = delNodesHelper(node.right, set, list);

            if (set.contains(node.val)) {
                if (node.left != null) {
                    list.add(node.left);
                }
                if (node.right != null) {
                    list.add(node.right);
                }
                return null; // Deleting the current node by returning null
            }

            return node;
        }
    }


    public static void printAllComponents(List<TreeNode> list){
        System.out.print("[");
        for (int i = 0; i < list.size(); i ++){
            BTree tree = new BTree();
            if (i < list.size() - 1){
                System.out.print("[" + tree.printTree(list.get(i)) + "], ");
                continue;
            }
            System.out.print("[" + tree.printTree(list.get(i)) + "]");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution s = new Solution();
        System.out.print("Enter the no of cases: ");
        int T = sc.nextInt();
        while (T > 0){
            sc.nextLine();
            System.out.print("Enter the nodes in (eg. 1,2,4,null,3): ");
            String[] nodes = sc.nextLine().split(",");
            BTree tree = new BTree();
            TreeNode root =  tree.buildTree(nodes, tree);
            System.out.print("Enter the number of nodes you want to delete: ");
            int n = sc.nextInt();
            int[] to_delete = new int[n];
            System.out.print("Enter the nodes to delete: ");
            for (int i = 0; i < n; i ++){
                to_delete[i] = sc.nextInt();
            }
            List<TreeNode> list = s.delNodes(root, to_delete);
            printAllComponents(list);
            T --;
        }
    }
}
