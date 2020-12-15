package com.mark.code.leetcode.medium;

import com.mark.code.leetcode.common.ListNode;

public class Partition {
    public static void main(String[] args) {
        Partition partition = new Partition();
        ListNode first = new ListNode(1);
        ListNode head = first;
        int[] ints = {4, 3, 2, 5, 2};
        for (int i : ints) {
            head.next = new ListNode(i);
            head = head.next;
        }
        System.out.println(partition.partition(first, 3));
    }

    public ListNode partition(ListNode head, int x) {
        ListNode before_head = new ListNode(0);
        ListNode after_head = new ListNode(0);
        ListNode before = before_head;
        ListNode after = after_head;
        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        after.next = null;
        before.next = after_head.next;
        return before_head.next;
    }
}
