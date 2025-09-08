package kim.dencka.java.medium;

import kim.dencka.java.payloads.ListNode;

class SwapNodesInPairs {
    public static void main(String[] args) {
        ListNode input = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8, new ListNode(9)))))))));
        swapPairs(input).printAll();
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newNode = head.next;
        head.next = swapPairs(head.next.next);
        newNode.next = head;
        return newNode;
    }

}
