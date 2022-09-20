package kim.dencka.java.easy.collection;

class MiddleOfTheLinkedList {
    public static void main(String[] args) {
        ListNode input = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));
        printAll(middleNode(input));
    }

    public static ListNode middleNode(ListNode head) {
        ListNode list = head;
        int depth = 0;
        while (list != null) {
            depth++;
            list = list.next;
        }
        depth = depth / 2;
        while (depth > 0) {
            head = head.next;
            depth--;
        }
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

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}