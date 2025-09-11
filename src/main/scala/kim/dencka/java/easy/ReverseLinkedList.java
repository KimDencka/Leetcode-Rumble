package kim.dencka.java.easy;

import kim.dencka.java.payloads.ListNode;

class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode input = ListNode.fromArray(1, 2, 3, 4, 5);
        System.out.println(reverseList(input)); // [5,4,3,2,1]
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
