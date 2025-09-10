package kim.dencka.java.medium;

import kim.dencka.java.payloads.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PathSumIII {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(10);
        tree.left = new TreeNode(5);
        tree.left.left = new TreeNode(3);
        tree.left.left.left = new TreeNode(3);
        tree.left.left.right = new TreeNode(-2);
        tree.left.right = new TreeNode(2);
        tree.left.right.right = new TreeNode(1);
        tree.right = new TreeNode(-3);
        tree.right.right = new TreeNode(11);

        System.out.println(pathSum(tree, 8)); // 3
    }

    public static int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0L, 1);
        return dfs(root, 0, targetSum, prefixSumCount);
    }

    public static int dfs(TreeNode tree, long currentSum, int targetSum, Map<Long, Integer> prefixSumCount) {
        if (tree == null) return 0;

        currentSum += tree.val;
        int count = prefixSumCount.getOrDefault(currentSum - targetSum, 0);

        prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);

        count += dfs(tree.left, currentSum, targetSum, prefixSumCount);
        count += dfs(tree.right, currentSum, targetSum, prefixSumCount);

        prefixSumCount.put(currentSum, prefixSumCount.get(currentSum) - 1);
        if (prefixSumCount.get(currentSum) == 0) {
            prefixSumCount.remove(currentSum);
        }
        return count;
    }

//    int counter = 0;
//    public int pathSum(TreeNode root, int targetSum) {
//        if (root == null) return 0;
//
//        helper(root, targetSum, 0);
//        pathSum(root.left, targetSum);
//        pathSum(root.right, targetSum);
//
//        return counter;
//    }
//
//    public void helper(TreeNode tree, int targetSum, int currentSum) {
//        if (tree == null) return;
//
//        currentSum += tree.val;
//        if (currentSum == targetSum) counter++;
//
//        helper(tree.left, targetSum, currentSum);
//        helper(tree.right, targetSum, currentSum);
//    }
}
