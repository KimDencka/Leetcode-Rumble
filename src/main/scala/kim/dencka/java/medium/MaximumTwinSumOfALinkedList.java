package kim.dencka.java.medium;

import kim.dencka.java.payloads.ListNode;

public class MaximumTwinSumOfALinkedList {
    public static void main(String[] args) {
        ListNode list = new ListNode(3, new ListNode(2, new ListNode(6, new ListNode(4))));
        System.out.println(pairSum(list));
    }

    public static int pairSum(ListNode head) {
        // find middle;
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reversing second half;
        ListNode next, prev = null;
        while (slow != null) {
            next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        int result = Integer.MIN_VALUE;
        // 'prev' is reversed second half of the list;
        while (prev != null) {
            result = Math.max(result, prev.val + head.val);
            prev = prev.next;
            head = head.next;
        }
        return result;
    }
}
