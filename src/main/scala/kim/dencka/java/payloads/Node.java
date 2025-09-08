package kim.dencka.java.payloads;

public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }

    // Use with direct call; e.g. node.printAll();
    public void printAll() {
        printAll(this);
    }

    // Use for nullable ListNodes; e.g. Node.printAll(node);
    public static void printAll(Node tree) {
        if (tree != null) {
            System.out.println(tree.val);
            printAll(tree.left);
            printAll(tree.right);
            printAll(tree.next);
        }
    }
}
