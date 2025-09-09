package kim.dencka.java.easy;

import kim.dencka.java.payloads.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {
    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(3);
        tree1.left.left = new TreeNode(0);
        tree1.left.right = new TreeNode(1);
        tree1.right = new TreeNode(2);
        tree1.right.left = new TreeNode(1);

        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.left.left = new TreeNode(0);
        tree2.left.right = new TreeNode(0);
        tree2.right = new TreeNode(3);
        tree2.right.left = new TreeNode(1);
        tree2.right.right = new TreeNode(1);

        System.out.println(leafSimilar(tree1, tree2)); // false
    }


    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafs1 = new ArrayList<>();
        List<Integer> leafs2 = new ArrayList<>();

        getLeafs(root1, leafs1);
        getLeafs(root2, leafs2);

        return leafs1.equals(leafs2);
    }

    public static void getLeafs(TreeNode tree, List<Integer> leafs) {
        if (tree.left == null && tree.right == null) leafs.add(tree.val);
        if (tree.left != null) getLeafs(tree.left, leafs);
        if (tree.right != null) getLeafs(tree.right, leafs);
    }
}
