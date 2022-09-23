package kim.dencka.java.easy.collection;

import kim.dencka.java.payloads.ListNode;

class MiddleOfTheLinkedList {
    public static void main(String[] args) {
        ListNode input = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));
        printAll(middleNode(input));
    }

    // Two Pointers
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null) {
            if (fast.next.next == null) {
                return slow.next;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //Iterative
//    public static ListNode middleNode(ListNode head) {
//        ListNode list = head;
//        int depth = 0;
//        while (list != null) {
//            depth++;
//            list = list.next;
//        }
//        depth = depth / 2;
//        while (depth > 0) {
//            head = head.next;
//            depth--;
//        }
//        return head;
//    }

    private static void printAll(ListNode list) {
        while (list != null) {
            System.out.print(list.val + " ");
            list = list.next;
        }
        System.out.println();
    }
}