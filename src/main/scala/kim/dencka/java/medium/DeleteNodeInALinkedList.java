package kim.dencka.java.medium;

import kim.dencka.java.payloads.ListNode;

class DeleteNodeInALinkedList {
    public static void main(String[] args) {
        ListNode list = ListNode.fromArray(1, 2, 3, 4, 5);
        ListNode target = list.next.next; // 3
        deleteNode(target);
        System.out.println(list); // [1,2,4,5]
    }

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
