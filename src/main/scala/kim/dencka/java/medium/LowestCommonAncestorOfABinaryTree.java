package kim.dencka.java.medium;

import kim.dencka.java.payloads.TreeNode;

public class LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(5);
        tree.left.left = new TreeNode(6);
        tree.left.right = new TreeNode(2);
        tree.left.right.left = new TreeNode(7);
        tree.left.right.right = new TreeNode(4);
        tree.right = new TreeNode(1);
        tree.right.left = new TreeNode(0);
        tree.right.right = new TreeNode(8);

        System.out.println(lowestCommonAncestor(tree, tree.left, tree.right));
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root;
        return left == null ? right : left;
    }
}
