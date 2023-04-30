package kim.dencka.java.medium.collection;

import kim.dencka.java.payloads.ListNode;

class SwapNodesInPairs {
    public static void main(String[] args) {
        ListNode input = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8, new ListNode(9)))))))));
        printAll(swapPairs(input));
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newNode = head.next;
        head.next = swapPairs(head.next.next);
        newNode.next = head;
        return newNode;
    }


    private static void printAll(ListNode list) {
        while (list != null) {
            if (list.next != null) {
                System.out.print(list.val + " -> ");
            } else {
                System.out.println(list.val);
            }
            list = list.next;
        }
    }
}
