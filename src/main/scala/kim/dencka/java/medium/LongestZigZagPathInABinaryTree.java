package kim.dencka.java.medium;

import kim.dencka.java.payloads.TreeNode;

public class LongestZigZagPathInABinaryTree {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.right = new TreeNode(1);
        tree.right.left = new TreeNode(1);
        tree.right.right = new TreeNode(1);
        tree.right.right.left = new TreeNode(1);
        tree.right.right.left.right = new TreeNode(1);
        tree.right.right.left.right.right = new TreeNode(1);
        tree.right.right.right = new TreeNode(1);

        System.out.println(longestZigZag(tree)); // 3
    }

    static int pathLength = 0;

    public static int longestZigZag(TreeNode root) {
        dfs(root, true, 0);
        return pathLength;
    }

    public static void dfs(TreeNode tree, boolean goLeft, int steps) {
        if (tree == null) return;

        pathLength = Math.max(pathLength, steps);
        if (goLeft) {
            dfs(tree.left, false, steps + 1);
            dfs(tree.right, true, 1);
        } else {
            dfs(tree.left, false, 1);
            dfs(tree.right, true, steps + 1);
        }
    }
}
