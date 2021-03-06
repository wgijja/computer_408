package com.sort;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * 归并排序 思想是分治，分成两边都是有序序列的数据，再从两边比较放入到中转数组中，最后拷贝回原数组
 * 左边数组索引，右边数组索引，中转数组索引
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{8, 4, 5, 7, 1, 3, 6, 2};
        //归并排序需要额外的空间
        int[] temp = new int[arr.length];
        mergeSortPra2(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));

        //int[] maxSize = new int[80000000];
        //for (int i = 0; i < 80000000; i++) {
        //    maxSize[i] = (int) (Math.random() * 80000000);
        //}
        //StopWatch stopWatch = StopWatch.createStarted();
        //mergeSortPractice(maxSize, 0, arr.length - 1, temp);
        //stopWatch.stop();
        //System.out.println("执行花费了：" + stopWatch.getTime(TimeUnit.MICROSECONDS) + "ms");
    }


    /**
     * 分+合
     *
     * @param arr   原始数组
     * @param left  最左边的索引
     * @param right 最右边的索引
     * @param temp  中转数组
     */
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            //中间索引
            int mid = (left + right) / 2;
            //向左递归分解
            mergeSort(arr, left, mid, temp);
            //向右递归分解
            mergeSort(arr, mid + 1, right, temp);
            //合并
            merge(arr, left, mid, right, temp);
        }
    }


    /**
     * 合并的方法
     *
     * @param arr   原数组
     * @param left  左边有序序列初始索引
     * @param mid   中间索引
     * @param right 右边有序序列最大下标
     * @param temp  做中转的数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        //左边有序序列的初始索引
        int i = left;
        //右边有序序列的初始索引
        int j = mid + 1;
        //中转数组的当前需要插入位置下标
        int t = 0;
        //第一步，把左右两边有序的数据填充到中转数组中
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                i++;
            } else {
                temp[t] = arr[j];
                j++;
            }
            t++;
        }
        //第二步，把剩余的元素填充到中转数组中
        while (i <= mid) {
            temp[t] = arr[i];
            i++;
            t++;
        }
        while (j <= right) {
            temp[t] = arr[j];
            j++;
            t++;
        }
        //第三步，把中转数组的元素拷贝到原始数组中,并不是拷所有
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            tempLeft++;
            t++;
        }
    }

    private static void mergeSortPractice(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSortPractice(arr, left, mid, temp);
            mergeSortPractice(arr, mid + 1, right, temp);
            mergePractice(arr, left, mid, right, temp);
        }
    }

    private static void mergePractice(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[t] = arr[i];
                i++;
            } else {
                temp[t] = arr[j];
                j++;
            }
            t++;
        }
        //把剩下的转到中转数组中
        while (i <= mid) {
            temp[t] = arr[i];
            i++;
            t++;
        }
        while (j <= right) {
            temp[t] = arr[j];
            j++;
            t++;
        }
        //把数据从temp拷贝到原数组
        int tempLeft = left;
        t = 0;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            tempLeft++;
            t++;
        }
    }

    private static void mergeSortPra2(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSortPra2(arr, left, mid, temp);
            mergeSortPra2(arr, mid + 1, right, temp);
            mergePra2(arr, left, mid, right, temp);
        }

    }

    private static void mergePra2(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        //把左右其中一边全部加到中转表
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[t] = arr[i];
                i++;
            } else {
                temp[t] = arr[j];
                j++;
            }
            t++;
        }
        //把剩下的加入中转表
        while (i <= mid) {
            temp[t] = arr[i];
            i++;
            t++;
        }
        while (j <= right) {
            temp[t] = arr[j];
            j++;
            t++;
        }
        //把中转数组中的数据拷贝回原数组
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            tempLeft++;
            t++;
        }
    }

}
