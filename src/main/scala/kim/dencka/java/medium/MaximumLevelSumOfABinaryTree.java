package kim.dencka.java.medium;

import kim.dencka.java.payloads.TreeNode;

import java.util.Arrays;

public class MaximumLevelSumOfABinaryTree {
    public static void main(String[] args) {
        TreeNode tree = TreeNode.fromArray(1, 7, 0, 7, -8, null, null);
        System.out.println(maxLevelSum(tree)); // 2
    }

    public static int maxLevelSum(TreeNode root) {
        int[] sums = new int[100];
        Arrays.fill(sums, Integer.MIN_VALUE);

        bfs(root, sums, 1);

        int level = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < sums.length; i++) {
            if (sums[i] > max) {
                level = i;
                max = sums[i];
            }
        }

        return level;
    }

    public static void bfs(TreeNode tree, int[] sums, int level) {
        if (tree == null) return;

        if (sums[level] == Integer.MIN_VALUE) {
            sums[level] = tree.val;
        } else {
            sums[level] += tree.val;
        }

        bfs(tree.left, sums, level + 1);
        bfs(tree.right, sums, level + 1);
    }

//    public static int maxLevelSum(TreeNode root) {
//        Queue<TreeNode> queue = new ArrayDeque<>();
//        queue.offer(root);
//
//        int resultLevel = 1, level = 0, max = Integer.MIN_VALUE;
//        while (!queue.isEmpty()) {
//            level++;
//            int size = queue.size();
//            int sum = 0;
//            for (int i = 0; i < size; i++) {
//                TreeNode node = queue.poll();
//                sum += node.val;
//                if (node.left != null) queue.offer(node.left);
//                if (node.right != null) queue.offer(node.right);
//            }
//            if (sum > max) resultLevel = level;
//            max = Math.max(max, sum);
//        }
//
//        return resultLevel;
//    }
}
