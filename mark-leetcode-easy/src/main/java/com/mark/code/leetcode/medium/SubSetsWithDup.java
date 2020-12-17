package com.mark.code.leetcode.medium;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

public class SubSetsWithDup {
    public static void main(String[] args) {
        SubSetsWithDup s = new SubSetsWithDup();
        int[] num = {1,2,2,3};
        s.subsetsWithDup(num);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums); //排序
        getAns(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void getAns(int[] nums, int start, ArrayList<Integer> temp, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            //仅仅在i==start时不跳过，也就是让重复数字可以被考虑，却不会再i>start时被多次重复的计算
            //第二个条件 和上个数字相等就跳过
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            getAns(nums, i + 1, temp, ans);
            temp.remove(temp.size() - 1);
        }
    }

}
