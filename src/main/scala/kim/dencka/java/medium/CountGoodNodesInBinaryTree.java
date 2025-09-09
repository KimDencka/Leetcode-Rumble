package kim.dencka.java.medium;

import kim.dencka.java.payloads.TreeNode;

public class CountGoodNodesInBinaryTree {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(1);
        tree.left.left = new TreeNode(3);
        tree.right = new TreeNode(4);
        tree.right.left = new TreeNode(1);
        tree.right.right = new TreeNode(5);

        System.out.println(goodNodes(tree)); // 4
    }

    public static int goodNodes(TreeNode root) {
        return findGoodNodes(root, Integer.MIN_VALUE);
    }

    public static int findGoodNodes(TreeNode tree, int max) {
        if (tree == null) return 0;
        int good = tree.val >= max ? 1 : 0;
        max = Math.max(max, tree.val);

        return findGoodNodes(tree.left, max) + findGoodNodes(tree.right, max) + good;
    }
}
