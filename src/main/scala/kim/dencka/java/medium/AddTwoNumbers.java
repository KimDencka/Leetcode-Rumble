package kim.dencka.java.medium;

import kim.dencka.java.payloads.ListNode;

class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 =
                new ListNode(9,
                        new ListNode(9,
                                new ListNode(9,
                                        new ListNode(9,
                                                new ListNode(9,
                                                        new ListNode(9,
                                                                new ListNode(9)))))));

        ListNode l2 =
                new ListNode(9,
                        new ListNode(9,
                                new ListNode(9,
                                        new ListNode(9))));

        addTwoNumbers(l1, l2).printAll();
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode tail = result;
        int mem = 0;

        while (l1 != null || l2 != null) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;

            int sum = mem + x + y;
            mem = sum / 10;

            tail.next = new ListNode(sum % 10);
            tail = tail.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (mem != 0) tail.next = new ListNode(mem);

        return result.next;
    }

}

