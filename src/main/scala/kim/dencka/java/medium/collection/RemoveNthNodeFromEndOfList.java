package kim.dencka.java.medium.collection;

import kim.dencka.java.payloads.ListNode;

class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        ListNode input = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));
        printAll(removeNthFromEnd(input, 2));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) return null;
        int depth = 0;
        ListNode slow = head;

        while (slow != null) {
            depth++;
            slow = slow.next;
        }
        if (depth == n) return head.next;
        if (depth == 2) {
            if (n == 1) {
                head.next = null;
                return head;
            } else {
                return head.next;
            }
        }

        int temp = 0;
        slow = head;
        ListNode fast = head.next;

        while (depth - temp != n) {
            temp++;
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = fast.next;

        return head;
    }

    public static void printAll(ListNode list) {
        while (list != null) {
            System.out.print(list.val + " ");
            list = list.next;
        }
        System.out.println();
    }

}


