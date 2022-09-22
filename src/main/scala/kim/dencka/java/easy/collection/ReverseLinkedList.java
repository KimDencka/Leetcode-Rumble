package kim.dencka.java.easy.collection;

import kim.dencka.java.payloads.ListNode;

class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode input = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        printAll(reverseList(input));
    }

    public static ListNode reverseList(ListNode head) {
        // Iterative
        ListNode res = null, list = null;
        while (head != null) {
            res = new ListNode(head.val, list);
            list = res;
            head = head.next;
        }
        return res;

//        return reverse(head, null);
    }
    // Recursive
    public static ListNode reverse(ListNode list, ListNode acc) {
        if (list == null) return acc;
        else return reverse(list.next, new ListNode(list.val, acc));
    }

    private static void printAll(ListNode list) {
        while (list != null) {
            System.out.print(list.val + " ");
            list = list.next;
        }
        System.out.println();
    }
}
