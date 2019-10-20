package com.mark.code.leetcode.medium;

import com.mark.code.leetcode.common.ListNode;
import com.mark.code.leetcode.common.ListNodeUtil;

public class AddTwoNumbers {

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode result = addTwoNumbers.addTwoNumbers_1(ListNodeUtil.createListCode(new int[]{0}),
                ListNodeUtil.createListCode(new int[]{7, 3}));
        System.out.println(result);
        result = addTwoNumbers.addTwoNumbers_1(ListNodeUtil.createListCode(new int[]{1, 1, 5}),
                ListNodeUtil.createListCode(new int[]{1, 1, 5}));
        System.out.println(result);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode first = new ListNode(0);
        ListNode result = first;
        int temp = 0;
        while (l1 != null || l2 != null) {
            ListNode ln = new ListNode(0);
            if (l1 != null) {
                ln.val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                ln.val += l2.val;
                l2 = l2.next;
            }
            if (temp != 0) {
                ln.val += temp;
                temp = 0;
            }
            if (ln.val > 9) {
                temp = 1;
                ln.val = ln.val - 10;
            }
            result.next = ln;
            result = result.next;
        }
        if (temp > 0) {
            result.next = new ListNode(temp);
        }
        return first.next;
    }

    /**
     * 不新建一个list，而是复用入参。
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers_1(ListNode l1, ListNode l2) {
        ListNode result = l1;
        int temp = 0;
        boolean l2Flag = true;
        while (true) {
            if (result != null) {
                if (l2 != null && l2Flag) {
                    result.val += l2.val;
                    l2 = l2.next;
                }
                if (temp != 0) {
                    result.val += temp;
                    temp = 0;
                }
                if (result.val >= 10) {
                    result.val -= 10;
                    temp = 1;
                }
                if (result.next != null) {
                    result = result.next;
                } else if (result.next == null && l2 != null && l2Flag) {
                    result.next = l2;
                    result = result.next;
                    l2Flag = false;
                } else if (temp != 0) {
                    result.next = new ListNode(temp);
                    break;
                } else {
                    break;
                }

            } else {
                break;
            }

        }
        return l1;
    }
}
