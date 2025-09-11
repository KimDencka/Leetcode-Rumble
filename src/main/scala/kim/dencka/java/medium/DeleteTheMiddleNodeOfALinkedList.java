package kim.dencka.java.medium;

import kim.dencka.java.payloads.ListNode;

public class DeleteTheMiddleNodeOfALinkedList {
    public static void main(String[] args) {
        ListNode list = ListNode.fromArray(1, 2, 3, 4, 5);
        System.out.println(deleteMiddle(list)); // [1,2,4,5]
    }

    public static ListNode deleteMiddle(ListNode head) {
        if (head.next == null) return null;
        ListNode slow = head, fast = head.next.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
