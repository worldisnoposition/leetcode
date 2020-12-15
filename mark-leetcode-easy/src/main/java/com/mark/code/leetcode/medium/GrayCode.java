package com.mark.code.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList();
        result.add(0);
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = result.size() - 1; j >= 0; j--) {
                result.add(head + result.get(j));
            }
            head <<= 1;
        }
        return result;
    }
}
