package BinaryTree.CreateBinaryTreeFromDescriptions;

import java.util.*;

import BinaryTree.BTree;
import BinaryTree.BTree.*;

/*
LeetCode:- 2196. Create Binary Tree From Descriptions
Link:- https://leetcode.com/problems/create-binary-tree-from-descriptions/description/?envType=daily-question&envId=2024-07-15

You are given a 2D integer array descriptions where descriptions[i] = [parenti, childi, isLefti] indicates that
parenti is the parent of childi in a binary tree of unique values. Furthermore,

If isLefti == 1, then childi is the left child of parenti.
If isLefti == 0, then childi is the right child of parenti.
Construct the binary tree described by descriptions and return its root.

The test cases will be generated such that the binary tree is valid.

Constraints:

1 <= descriptions.length <= 104
descriptions[i].length == 3
1 <= parenti, childi <= 105
0 <= isLefti <= 1
The binary tree described by descriptions is valid.
 */

public class CreateBinaryTreeFromDescriptions {
    public static class Solution {
        public TreeNode createBinaryTree(int[][] descriptions) {
            Map<Integer, TreeNode> nodeMap = new HashMap<>();
            Set<Integer> childNodes = new HashSet<>();

            for (int[] description : descriptions) {
                int parentVal = description[0];
                int childVal = description[1];
                boolean isLeft = description[2] == 1;

                TreeNode parentNode = nodeMap.getOrDefault(parentVal, new TreeNode(parentVal));
                TreeNode childNode = nodeMap.getOrDefault(childVal, new TreeNode(childVal));

                if (isLeft) {
                    parentNode.left = childNode;
                } else {
                    parentNode.right = childNode;
                }

                nodeMap.put(parentVal, parentNode);
                nodeMap.put(childVal, childNode);
                childNodes.add(childVal);
            }

            TreeNode root = null;
            for (int nodeVal : nodeMap.keySet()) {
                if (!childNodes.contains(nodeVal)) {
                    root = nodeMap.get(nodeVal);
                    break;
                }
            }

            return root;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution s = new Solution();
        System.out.print("Enter the no of case: ");
        int T = sc.nextInt();
        while (T > 0){
            System.out.print("Enter the no of child node: ");
            int n = sc.nextInt();
            int[][] descriptions = new int[n][3];
            for(int i = 0; i < n; i++){
                System.out.print("Enter the node val, child val, and side val (i.e 12 18 1 or 12 18 0): ");
                descriptions[i][0] = sc.nextInt();
                descriptions[i][1] = sc.nextInt();
                descriptions[i][2] = sc.nextInt();
            }
            System.out.print("[");
            for (int i = 0; i < n; i ++){
                System.out.print(Arrays.toString(descriptions[i]) + (i < n - 1 ? ", " : ""));
            }
            System.out.println("]");
            TreeNode root = s.createBinaryTree(descriptions);
            System.out.print("Output: ");
            BTree tree = new BTree();
            tree.printTree(root);
            T --;
        }
    }
}
