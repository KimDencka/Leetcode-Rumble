package kim.dencka.java.easy;

import kim.dencka.java.payloads.ListNode;

class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode input = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        reverseList(input).printAll();
    }

    // Iterative
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    // Recursive
    public static ListNode reverse(ListNode list, ListNode acc) {
        if (list == null) return acc;
        else return reverse(list.next, new ListNode(list.val, acc));
    }

}
