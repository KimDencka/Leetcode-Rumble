package kim.dencka.java.medium;

import kim.dencka.java.payloads.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        TreeNode tree = TreeNode.fromArray(new Integer[]{1, 2, 3, 4, null, null, null, 5});
        System.out.println(rightSideView(tree)); // [1, 3, 4, 5]
    }

    // BFS
    public static List<Integer> rightSideView(TreeNode root) {
        if (root == null) return List.of();
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                TreeNode cur = queue.poll();
                if (i == curSize - 1) result.add(cur.val);
                if (cur.left != null) queue.offer(cur.left); // first left
                if (cur.right != null) queue.offer(cur.right); // then right
            }
        }

        return result;
    }

    // DFS
//    public static List<Integer> rightSideView(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        dfs(root, result, 0);
//        return result;
//    }
//
//    public static void dfs(TreeNode tree, List<Integer> result, int level) {
//        if (tree == null) return;
//
//        // if this is our first time at this level, add the current node
//        if (level == result.size()) result.add(tree.val);
//
//        // first right, then left
//        dfs(tree.right, result, level + 1);
//        dfs(tree.left, result, level + 1);
//    }

}
