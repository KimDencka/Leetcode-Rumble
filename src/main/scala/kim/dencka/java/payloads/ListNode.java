package kim.dencka.java.payloads;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    // Use with direct call; e.g. node.printAll();
    public void printAll() {
        printAll(this);
    }

    // Use for nullable ListNodes; e.g. ListNode.printAll(node);
    public static void printAll(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

}
