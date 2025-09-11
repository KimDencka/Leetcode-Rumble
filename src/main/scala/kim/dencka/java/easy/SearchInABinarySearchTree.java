package kim.dencka.java.easy;

import kim.dencka.java.payloads.TreeNode;

public class SearchInABinarySearchTree {
    public static void main(String[] args) {
        TreeNode tree = TreeNode.fromArray(new Integer[]{4, 2, 7, 1, 3});
        searchBST(tree, 2).printAll(); // [2,1,3]
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;

        if (root.val > val) {
            return searchBST(root.left, val);
        } else if (root.val < val) {
            return searchBST(root.right, val);
        } else {
            return root;
        }
    }
}
