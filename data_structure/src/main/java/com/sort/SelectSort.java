package com.sort;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class SelectSort {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 6, 1, 3, 5, 7, 9, 8};
        pra3(arr);
        System.out.println(Arrays.toString(arr));

        //测试一下性能，测试80000条数据执行时间 3S
        //int[] maxSize = new int[80000];
        //for (int i = 0; i < 80000; i++) {
        //    maxSize[i] = (int) (Math.random() * 80000);
        //}
        //StopWatch stopWatch = StopWatch.createStarted();
        //selectSort(maxSize);
        //stopWatch.stop();
        //System.out.println("执行花费了：" + stopWatch.getTime(TimeUnit.SECONDS) + "秒");

    }

    /**
     * 选择排序
     *
     * @param arr
     */
    private static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            //假定第i位是最小的。
            int minTemp = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minTemp]) {
                    minTemp = j;
                }
            }
            if (i != minTemp) {
                int temp = arr[i];
                arr[i] = arr[minTemp];
                arr[minTemp] = temp;
            }
        }
    }

    private static void pra(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            if (index != i) {
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }
    }

    private static void pra2(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int insertIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[insertIndex]) {
                    insertIndex = j;
                }
            }
            if (insertIndex != i) {
                int temp = arr[i];
                arr[i] = arr[insertIndex];
                arr[insertIndex] = temp;
            }
        }
    }

    private static void pra3(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int changeIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[changeIndex] > arr[j]) {
                    changeIndex = j ;
                }
            }
            if (changeIndex != i){
                int temp = arr[i];
                arr[i]= arr[changeIndex];
                arr[changeIndex] = temp;
            }
        }
    }
}
