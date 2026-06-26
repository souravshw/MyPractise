package io.practise.dsa;

public class InvertBinaryTree {

    public static class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) { this.val = val; }
    }

    // Optimized - Recursive - O(n)
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public static void main(String[] args) {
        InvertBinaryTree solver = new InvertBinaryTree();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);

        System.out.println("--- Invert Binary Tree Demonstration ---");
        System.out.println("Root left before invert: " + root.left.val);
        solver.invertTree(root);
        System.out.println("Root left after invert: " + root.left.val);
    }
}
