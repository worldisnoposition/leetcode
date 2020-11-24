package com.mark.temp;

import com.google.common.collect.Lists;

import java.util.Arrays;

public abstract class Temp {
    public static void main(String[] args) {
        Lists.newArrayList();
        int[] arr = {6, 5, 3, 8, 9, 1, 4};
        quitSort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(System.out::println);

    }

    public static void quitSort(int[] arr, int li, int ri) {
        if (li > ri) {
            return;
        }
        int l = li, r = ri, key = arr[l];
        while (l < r) {
            while (l < r && arr[r] >= key) {
                r--;
            }
            arr[l] = arr[r];
            while (l < r && arr[l] < key) {
                l++;
            }
            arr[r] = arr[l];
        }
        arr[l] = key;
        quitSort(arr, li, l - 1);
        quitSort(arr, l + 1, ri);
    }
}
