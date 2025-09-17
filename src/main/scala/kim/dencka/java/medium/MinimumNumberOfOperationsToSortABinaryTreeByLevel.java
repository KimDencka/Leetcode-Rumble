package kim.dencka.java.medium;

import kim.dencka.java.payloads.TreeNode;

import java.util.*;

class MinimumNumberOfOperationsToSortABinaryTreeByLevel {
    public static void main(String[] args) {
        TreeNode input = new TreeNode(1);
        input.left = new TreeNode(3);
        input.right = new TreeNode(2);
        input.left.left = new TreeNode(7);
        input.left.right = new TreeNode(6);
        input.right.left = new TreeNode(5);
        input.right.right = new TreeNode(4);

        System.out.println(minimumOperations(input)); // 3
    }

    public static int minimumOperations(TreeNode root) {
        return levelOrderTraversal(root);
    }

    private static int levelOrderTraversal(TreeNode root) {
        int cnt = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> result = new ArrayList<>();
            int len = queue.size();
            while (len-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                    result.add(node.left.val);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    result.add(node.right.val);
                }
            }
            int res = sortingTree(result);
            cnt += res;
        }
        return cnt;
    }

    private static int sortingTree(List<Integer> result) {
        int len = result.size();
        if (len == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < result.size(); i++)
            map.put(result.get(i), i);
        int[] sorted = new int[len];
        for (int i = 0; i < len; i++)
            sorted[i] = result.get(i);
        Arrays.sort(sorted);

        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if (sorted[i] != result.get(i)) {
                cnt++;
                map.put(result.get(i), map.get(sorted[i]));
                result.set(map.get(sorted[i]), result.get(i));
            }

        }
        return cnt;
    }

}
