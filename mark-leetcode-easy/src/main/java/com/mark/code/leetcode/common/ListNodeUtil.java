package com.mark.code.leetcode.common;

public class ListNodeUtil {
    public static void main(String[] args) {
        System.out.println(createListCode(new int[]{2, 4, 3}));
        System.out.println(createListCode(new int[]{5, 6, 4}));
    }

    public static ListNode createListCode(int[] args) {
        ListNode first = new ListNode(0);
        //注意这行
        ListNode now = first;
        for (int node : args) {
            ListNode ln = new ListNode(node);
            now.next = ln;
            now = now.next;
        }
        return first.next;
    }

}
