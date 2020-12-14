package com.mark.code.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

public class IsScramble {
    public static void main(String[] args) {
        IsScramble isScramble = new IsScramble();
        System.out.println(isScramble.isScramble("great", "rgeat"));
    }

    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        int[] letters = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            letters[s1.charAt(i)]++;
            letters[s2.charAt(i)]--;
        }
        for (int letter : letters) {
            if (letter != 0) {
                return false;
            }
        }
        for (int i = 1; i < s1.length(); i++) {
            boolean flag = (isScramble(s1.substring(0, i), s2.substring(0, i))
                    && isScramble(s1.substring(i), s2.substring(i)))
                    || (isScramble(s1.substring(0, i), s2.substring(s1.length() - i))
                    && isScramble(s1.substring(i), s2.substring(0, s2.length() - i)));
            if (flag) {
                return true;
            }
        }
        return false;
    }
}
