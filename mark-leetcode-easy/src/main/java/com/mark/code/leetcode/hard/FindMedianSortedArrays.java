package com.mark.code.leetcode.hard;

import java.util.Arrays;

/**
 * 时间复杂度logm+n的时间内找到2个数组中间的数字，如果是偶数长度则取平均数。
 * 这个题我觉得出的一般，因为时间复杂度为n的和logn的拉不开差距。我还是图方便用了时间复杂度为n的了
 */
public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int[] temp = new int[len];
        int j = 0;
        for (int i : nums1) {
            temp[j++] = i;
        }
        for (int i : nums2) {
            temp[j++] = i;
        }
        Arrays.sort(temp);
        return len % 2 == 0 ? (temp[len / 2] + temp[len / 2 + 1] + 0.0d) / 2 : temp[len / 2];

    }
}
//a1 a2 b1 b2
//a1 b1 a2 b2
//a1 b1 b2 a2
//b1 a1 a2 b2
//b1 a1 b2 a2
//b1 b2 a1 a2

//切点x num[x] num[x-1]

/**
 * 抄袭的一个时间复杂度为logn的代码，自己改成了伪代码，
 * <p>
 * 长的数组放后面
 * <p>
 * h=从短数组的长度开始
 * l=从0开始
 * 循环
 * x= h+l的一半
 * y= (总长+1)/2 - x
 * 如果x，y左边的都比右边的小
 * 成功返回
 * 如果x左边比y右边大
 * (l+(h+l)/2-1)/2
 * =(l+1.5l-1)/2   h长，所以相当于x向左移动,同时y往右
 * 如果x左边比y右边小
 * ((h+l)/2-1+h)/2
 * =(1.5h+0.5l-1)/2     h长，所以相当于x向右移动,同时y往左
 */