package kim.dencka.java.easy;

import kim.dencka.java.payloads.ListNode;

class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode list1 = ListNode.fromArray(1, 2, 4);
        ListNode list2 = ListNode.fromArray(1, 3, 4);
        System.out.println(mergeTwoLists(list1, list2)); // [1,1,2,3,4,4]
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode head, temp;

        if (list1.val < list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }

        temp = head;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }

        if (list1 == null) {
            temp.next = list2;
            return head;
        }
        temp.next = list1;
        return head;
    }

}
