package com.mark.code.leetcode.medium;

import com.mark.code.leetcode.common.ListNode;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode first = new ListNode(1);
        first.next = new ListNode(2);
        first.next.next = new ListNode(3);
        first.next.next.next = new ListNode(4);
        first.next.next.next.next = new ListNode(5);
        ListNode result = solution.reverseBetween(first, 2, 4);
        System.out.println(result);
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode first = new ListNode(-1);
        first.next = head;
        ListNode listNode = new ListNode(-1);
        ListNode firstNode = new ListNode(-1);
        ListNode last = first;
        ListNode startFirst = null;
        int i=0;
        boolean start = true;
        while (head != null) {
            i++;
            ListNode cur = head;
            if (start) {
                if (i == m) {
                    ListNode temp = new ListNode(cur.val);
                    temp.next = listNode.next;
                    listNode.next = temp;
                    startFirst = last;
                    firstNode = temp;
                    start = false;
                }
            } else {
                ListNode temp = new ListNode(cur.val);
                temp.next = listNode.next;
                listNode.next = temp;
                if (i == n) {
                    startFirst.next = listNode.next;
                    firstNode.next = head.next;
                    break;
                }
            }
            last = head;
            head = head.next;

        }
        return first.next;
    }
}
