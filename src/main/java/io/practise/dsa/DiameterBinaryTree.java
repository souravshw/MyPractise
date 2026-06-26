package io.practise.dsa;

public class DiameterBinaryTree {

    public static class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) { this.val = val; }
    }

    int max = 0;
    
    // DFS + Height Tracking - O(n)
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    private int maxDepth(TreeNode node) {
        if (node == null) return 0;
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        max = Math.max(max, left + right);
        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        DiameterBinaryTree solver = new DiameterBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("--- Diameter of Binary Tree Demonstration ---");
        System.out.println("Diameter: " + solver.diameterOfBinaryTree(root));
    }
}
