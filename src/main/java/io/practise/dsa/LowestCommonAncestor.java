package io.practise.dsa;

public class LowestCommonAncestor {

    public static class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) { this.val = val; }
    }

    // Recursive DFS - O(n)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return (left != null) ? left : right;
    }

    public static void main(String[] args) {
        LowestCommonAncestor solver = new LowestCommonAncestor();
        TreeNode root = new TreeNode(3);
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);
        root.left = p;
        root.right = q;

        System.out.println("--- Lowest Common Ancestor Demonstration ---");
        TreeNode lca = solver.lowestCommonAncestor(root, p, q);
        System.out.println("LCA Val: " + lca.val);
    }
}
