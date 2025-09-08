package kim.dencka.java.medium;

import kim.dencka.java.payloads.ListNode;

class DeleteNodeInALinkedList {
    public static void main(String[] args) {
        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        list.printAll();
        deleteNode(list.next.next);
        list.printAll();
    }

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
