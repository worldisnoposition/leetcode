package com.mark.code.leetcode.medium;

public class NumDecodes {
    public static void main(String[] args) {
        NumDecodes numDecodes = new NumDecodes();
        System.out.println(numDecodes.numDecodings("27"));
    }

    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) < '7')) {
                if (s.charAt(i) == '0') {
                    dp[i + 1] = dp[i - 1];
                } else {
                    dp[i + 1] = dp[i - 1] + dp[i];
                }
            } else if (s.charAt(i) == '0') {
                return 0;
            } else {
                dp[i + 1] = dp[i];
            }
        }
        return dp[s.length()];
    }
}
