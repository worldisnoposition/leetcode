package com.mark.code.leetcode.hard;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MinWindow {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        MinWindow minWindow = new MinWindow();
        String a = minWindow.minWindow2(s, t);
        System.out.println(a);
    }

    Map<Character, Integer> ori = new HashMap();
    Map<Character, Integer> cnt = new HashMap();

    public String minWindow1(String s, String t) {
        int l = 0, r = -1;
        for (char c : t.toCharArray()) {
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int sLen = s.length();
        while (r < sLen) {
            r++;
            if (r < sLen && ori.containsKey(s.charAt(r))) {
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check() && l <= r) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                if (ori.containsKey(s.charAt(l))) {
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    private boolean check() {
        Iterator iter = ori.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }

    public String minWindow2(String s, String t) {
        char[] have = new char[128];
        char[] need = new char[128];
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        int l = 0, r = 0, minLength = Integer.MAX_VALUE, count = 0, start = 0;
        //窗口的有边是r，左边是l
        while (r < s.length()) {
            char cRight = s.charAt(r);
            //如果need中没定位到，则略过去
            if (need[cRight] == 0) {
                r++;
                continue;
            }
            //have里（s里）多的就不管了，只计算少于need的，一旦加到相等，就不再计算了
            if (have[cRight] < need[cRight]) {
                count++;
            }
            have[cRight]++;
            r++;

            while (count == t.length()) {
                if (r - l < minLength) {
                    minLength = r - l;
                    start = l;
                }
                char cLeft = s.charAt(l);
                if (need[cLeft] == 0) {
                    l++;
                    continue;
                }
                if (have[cLeft] == need[cLeft]) {
                    count--;
                }
                have[cLeft]--;
                l++;
            }
        }
        if (minLength == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(start, start + minLength);
    }
}
