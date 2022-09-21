package kim.dencka.java.medium.tree;

import kim.dencka.java.payloads.Node;

class PopulatingNextRightPointersInEachNode {
    // KIM_INFO NOT SOLVED IN SCALA

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);

        printAll(connect(node));
    }

    private static Node getNextRight(Node root) {
        if (root == null) return null;
        while (root != null) {
            if (root.left != null) return root.left;
            if (root.right != null) return root.right;
            root = root.next;
        }
        return null;
    }

    public static Node connect(Node root) {
        if (root == null) return null;

        if (root.left != null)
            root.left.next = root.right;

        if (root.right != null)
            root.right.next = getNextRight(root.next);

        root.left = connect(root.left);
        root.right = connect(root.right);
        return root;
    }

    // Iterative
//    public static Node connect(Node root) {
//        if (root == null) return null;
//        Queue<Node> queue = new LinkedList<>();
//        queue.add(root);
//
//        Node cur;
//        while (!queue.isEmpty()) {
//            cur = queue.poll();
//            if (cur.left != null) {
//                queue.add(cur.left);
//                queue.add(cur.right);
//            }
//            cur.next = queue.peek();
//        }
//
//        for (Node n = root; n != null; n = n.right) {
//            n.next = null;
//        }
//        return root;
//    }

    public static void printAll(Node tree) {
        if (tree != null) {
            System.out.println(tree.val);
            printAll(tree.left);
            printAll(tree.right);
            printAll(tree.next);
        }
    }
}
