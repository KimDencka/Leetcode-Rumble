package kim.dencka.java.easy;

import kim.dencka.java.payloads.TreeNode;

class MergeTwoBinaryTrees {
    public static void main(String[] args) {
        TreeNode bt1 = new TreeNode(1);
        TreeNode bt2 = new TreeNode(2);
        bt1.left = new TreeNode(3);
        bt1.left.left = new TreeNode(5);
        bt1.right = new TreeNode(2);
        bt2.left = new TreeNode(1);
        bt2.left.right = new TreeNode(4);
        bt2.right = new TreeNode(3);
        bt2.right.right = new TreeNode(7);

        mergeTrees(bt1, bt2).printAll();

    }

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }

    // Iterative
//    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
//        if (t1 == null) return t2;
//        Stack<TreeNode[]> stack = new Stack<>();
//        stack.push(new TreeNode[]{t1, t2});
//        TreeNode[] t;
//        while (!stack.isEmpty()) {
//            t = stack.pop();
//            if (t[0] == null || t[1] == null) {
//                continue;
//            }
//            t[0].val += t[1].val;
//            if (t[0].left == null) {
//                t[0].left = t[1].left;
//            } else {
//                stack.push(new TreeNode[]{t[0].left, t[1].left});
//            }
//            if (t[0].right == null) {
//                t[0].right = t[1].right;
//            } else {
//                stack.push(new TreeNode[]{t[0].right, t[1].right});
//            }
//        }
//        return t1;
//    }

}

