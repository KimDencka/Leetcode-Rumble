package kim.dencka.java.medium;

import kim.dencka.java.payloads.TreeNode;

public class DeleteNodeInABST {
    public static void main(String[] args) {
        TreeNode tree = TreeNode.fromArray(5, 3, 6, 2, 4, null, 7);
        System.out.println(deleteNode(tree, 3)); // [5,4,6,2,null,null,7]
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode min = root.right;
                while (min.left != null) min = min.left;

                root.val = min.val;
                root.right = deleteNode(root.right, min.val);
                return root;
            }
        }
    }

}
