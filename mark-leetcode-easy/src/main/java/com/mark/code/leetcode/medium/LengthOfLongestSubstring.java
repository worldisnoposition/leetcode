package com.mark.code.leetcode.medium;

import sun.security.util.Length;

import java.util.List;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        LengthOfLongestSubstring l = new LengthOfLongestSubstring();
        int a = l.lengthOfLongestSubstring_1("abcacbb");
        System.out.println(a);
    }

    public int lengthOfLongestSubstring(String s) {
        //自己只能想到3重循环，太渣了，不考虑。
        return 0;
    }


    /**
     * 这个方案是抄袭来的
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring_1(String s) {
        int i, j, maxm;
        int[] seen = new int[128];
        for(i = 0; i < seen.length; i++) {
            seen[i] = -1;
        }
        i = j = maxm = 0;
        while(j < s.length()) {
            int l = s.charAt(j);
            if (seen[l] >= i) {
                //i标记了从j往前多少位之内没有重复的，一旦重复了，从上一个重复的位置+1计算
                //seen[l]的值必须小于等于i，不然代表着i到j之间有重复数据，i需要重置。
                i = seen[l] + 1;
            }
            seen[l] = j;
            j++;
            maxm = Math.max(maxm, j - i);
            System.out.println(maxm);
            System.out.println(j+"-"+i);
            System.out.println(l);
            System.out.println("==============");
        }
        return maxm;
    }
}
