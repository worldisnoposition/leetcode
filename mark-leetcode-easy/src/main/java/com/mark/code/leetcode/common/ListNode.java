package com.mark.code.leetcode.common;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }
    @Override
    public String toString(){
        String result = this.val+",";
        if(next!=null){
            result+=next.toString();
        }
        return result;
    }
}
