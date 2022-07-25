package com.sort;

import java.util.Arrays;

/**
 * 基数排序，桶排序的扩展，思想是：把数据按位数大小分到10个桶中进行排序
 *
 * @author fjh
 * @date 2022/7/25 17:42
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 6, 1, 3, 5, 7, 9, 8};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void radixSort(int[] arr) {
        //找出数组中的最大值
        int maxValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }
        //最大值的位数
        int maxLength = (maxValue + "").length();
        //二维数组表示10个桶
        int[][] bucket = new int[10][arr.length];
        //一维数组表示每个桶中记录的数据个数
        int[] bucketElementCounts = new int[10];
        //根据位数循环排序
        for (int i = 0, k = 1; i < maxLength; i++, k *= 10) {
            //根据位数将数据拆分到桶中去
            for (int j = 0; j < arr.length; j++) {
                int bucketIndex = arr[j] / k % 10;
                bucket[bucketIndex][bucketElementCounts[bucketIndex]] = arr[j];
                bucketElementCounts[bucketIndex]++;
            }
            //取出来放到数组中
            int index = 0;
            for (int j = 0; j < bucketElementCounts.length; j++) {
                if (bucketElementCounts[j] != 0) {
                    for (int l = 0; l < bucketElementCounts[j]; l++) {
                        arr[index] = bucket[j][l];
                        index++;
                    }
                    bucketElementCounts[j] = 0;
                }
            }
        }
    }
}
