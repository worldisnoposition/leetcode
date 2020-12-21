package com.mark.code.leetcode.medium;

import com.mark.code.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.List;

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
        System.out.println(solution.restoreIpAddresses("25525511135"));
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode first = new ListNode(-1);
        first.next = head;
        ListNode listNode = new ListNode(-1);
        ListNode firstNode = new ListNode(-1);
        ListNode last = first;
        ListNode startFirst = null;
        int i = 0;
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

    List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        restoreIpAddresses(s, 0, new StringBuilder(), 4);
        return result;
    }

    public void restoreIpAddresses(String s, int i, StringBuilder sb, int count) {
        if (i < s.length() && count <= 4 && count >= 0) {
            restoreIpAddresses(s, i + 1, new StringBuilder(sb).append(s.charAt(i)).append("."), count - 1);
            if (s.charAt(i) != '0' && (i + 1 < s.length())) {
                restoreIpAddresses(s, i + 2, new StringBuilder(sb).append(s.substring(i, i + 2)).append("."), count - 1);
            }
            if ((i + 2 < s.length()) && ((s.charAt(i) == '1') || (s.charAt(i) == '2' && s.charAt(i + 1) <= '4') || ((s.charAt(i) == '2' && s.charAt(i + 1) == '5' && s.charAt(i + 2) <= '5')))) {
                restoreIpAddresses(s, i + 3, new StringBuilder(sb).append(s.substring(i, i + 3)).append("."), count - 1);
            }
        } else if (i == s.length() && count == 0) {
            result.add(sb.substring(0, sb.length() - 1));
        }
    }
}
