package BST;


import java.util.LinkedList;
import java.util.Queue;

public class BSTree {

    public TreeNode root;
    private BSTree tree;

    public BSTree(){}

    public BSTree(TreeNode root) {
        this.root = root;
    }

    public static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
        TreeNode() {}
        public TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Helper method to build the tree from the input array
    public TreeNode buildTree(String[] nodes, BSTree tree) {
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
    public void printTree(TreeNode root) {
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
