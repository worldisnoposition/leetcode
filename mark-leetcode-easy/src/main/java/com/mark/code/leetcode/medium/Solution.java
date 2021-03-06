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
//        System.out.println(solution.generateTrees(3));
        solution.recoverTree(null);
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

    public void recoverTree(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<>();
        recoverTree(root, list);
        list.add(new TreeNode(1));
        list.add(new TreeNode(3));
        list.add(new TreeNode(2));
        list.add(new TreeNode(4));
        if (list.size() > 1) {
            TreeNode last1 = null;
            TreeNode last2 = null;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i + 1).val < list.get(i).val) {
                    last2 = list.get(i + 1);
                    if (last1 == null) {
                        last1 = list.get(i);
                    } else {
                        break;
                    }
                }
            }
            int temp = last2.val;
            last2.val = last1.val;
            last1.val = temp;
        }
    }

    public void recoverTree(TreeNode root, ArrayList<TreeNode> list) {
        if (root != null) {
            if (root.left != null) {
                recoverTree(root.left, list);
            }
            list.add(root);
            if (root.right != null) {
                recoverTree(root.right, list);
            }
        }
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        boolean[] dp = new boolean[s2.length()];
        dp[0] = true;
        for (int i = 0; i <= s1.length(); ++i) {
            for (int j = 0; j <= s2.length(); ++j) {
                int p = i + j - 1;
                if (i > 0) {
                    dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(p);
                }
                if (j > 0) {
                    dp[j] = dp[j] || (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }
        return dp[s3.length()];
    }
}
