package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BTree{
    private TreeNode root;
    private BTree tree;

    public BTree(){}
    public BTree(TreeNode root){
        this.root = root;
    }

    public static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
        TreeNode() {}
        public TreeNode(int val) { this.val = val; }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Helper method to build tree in level order
    public TreeNode buildTree(String[] nodes, BTree tree){
        if (nodes == null || nodes.length == 0 || nodes[0].equals("null")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        this.tree = tree;
        tree.root = root;
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
        return tree.root;
    }

    // Helper method to print the tree in level order
    public String printTree(TreeNode root) {
        if (root == null) {
            return "null";
        }

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current == null) {
                sb.append("null, ");
            } else {
                sb.append(current.val).append(", ");
                queue.add(current.left);
                queue.add(current.right);
            }
        }

        String input = sb.toString();
        String toTrim = ", null";

        // Loop to remove the trailing ", null" substrings
        while (input.endsWith(toTrim + ", ") || input.endsWith(toTrim)) {
            input = input.endsWith(toTrim + ", ") ? input.substring(0, input.length() - (toTrim + ", ").length())
                    : input.substring(0, input.length() - toTrim.length());
        }

        // Remove the final comma and space if present
        if (input.endsWith(", ")) {
            input = input.substring(0, input.length() - 2);
        }

        // Return the trimmed string
        return input;
    }

}
