package com.mark.code.leetcode.medium;

import com.mark.code.leetcode.common.ListNode;
import com.mark.code.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        ListNode first = new ListNode(1);
//        first.next = new ListNode(2);
//        first.next.next = new ListNode(3);
//        first.next.next.next = new ListNode(4);
//        first.next.next.next.next = new ListNode(5);
//        ListNode result = solution.reverseBetween(first, 2, 4);
//        System.out.println(result);
//        System.out.println(solution.restoreIpAddresses("25525511135"));
        System.out.println(solution.generateTrees(3));
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

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> list = new LinkedList<>();
        if (start >= end) {
            list.add(null);
            return list;
        }
        for (int i = start; i < end; i++) {
            List<TreeNode> left = generateTrees(start, i - 1);
            List<TreeNode> right = generateTrees(i + 1, end);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = l;
                    treeNode.right = r;
                    list.add(treeNode);
                }
            }
        }
        return list;
    }

    private TreeNode clone(TreeNode treeNode) {
        return null;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        return false;
    }

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
