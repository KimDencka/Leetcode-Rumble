package kim.dencka.java.easy;

import kim.dencka.java.payloads.ListNode;

class MiddleOfTheLinkedList {
    public static void main(String[] args) {
        ListNode input = ListNode.fromArray(1, 2, 3, 4, 5);
        System.out.println(middleNode(input)); // [3,4,5]
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

}