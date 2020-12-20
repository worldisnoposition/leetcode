package com.mark.code.leetcode.easy;

import lombok.experimental.Wither;

import javax.xml.ws.WebFault;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 第1题
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * 从数组里找到2个相加等于target的数
 */
@Wither
public class TwoSum {
    public static void main(String[] args) throws Throwable {
//        Object
        Thread t = new Thread();
        Thread.yield();
        ReentrantLock lock  = new ReentrantLock();
        lock.lock();
        TwoSum o = new TwoSum();
        o.finalize();
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            int temp = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == temp) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }

    /**
     * 更优化的做法，把参数放到map里，那么只需一次循环
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum_1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            Integer j = map.get(temp);
            if (j != null) {
                return new int[]{j, i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
