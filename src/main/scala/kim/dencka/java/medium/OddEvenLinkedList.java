package kim.dencka.java.medium;

import kim.dencka.java.payloads.ListNode;

public class OddEvenLinkedList {
    public static void main(String[] args) {
        ListNode list = ListNode.fromArray(1, 2, 3, 4, 5);
        System.out.println(oddEvenList(list)); // [1,3,5,2,4]
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return head;
        ListNode evenHead = head.next;
        ListNode even = head.next;
        ListNode odd = head;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
