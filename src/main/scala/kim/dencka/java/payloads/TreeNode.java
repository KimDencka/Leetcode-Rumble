package kim.dencka.java.payloads;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    // Use with direct call; e.g. treeNode.printAll();
    public void printAll() {
        printAll(this);
    }

    // Use for nullable ListNodes; e.g. TreeNode.printAll(node);
    public static void printAll(TreeNode tree) {
        if (tree != null) {
            System.out.println(tree.val);
            printAll(tree.left);
            printAll(tree.right);
        }
    }
}
