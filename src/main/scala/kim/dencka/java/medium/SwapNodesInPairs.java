package kim.dencka.java.medium;

import kim.dencka.java.payloads.ListNode;

class SwapNodesInPairs {
    public static void main(String[] args) {
        ListNode input = ListNode.fromArray(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println(swapPairs(input)); // [2,1,4,3,6,5,8,7,9]
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newNode = head.next;
        head.next = swapPairs(head.next.next);
        newNode.next = head;
        return newNode;
    }

}
