package kim.dencka.java.payloads;

import java.util.*;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        List<String> values = new ArrayList<>();
        ListNode curr = this;
        while (curr != null) {
            values.add(String.valueOf(curr.val));
            curr = curr.next;
        }
        return "[" + String.join(",", values) + "]";
    }

    public static ListNode fromArray(int... arr) {
        if (arr == null || arr.length == 0) return null;

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int val : arr) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof TreeNode)) return false;
        return this.toString().equals(obj.toString());
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }
}
