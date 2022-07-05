package com.sort;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {

        int[] arr = new int[]{2, 4, 6, 1, 3, 5, 7, 9, 8};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 希尔排序
     *
     * @param arr
     */
    public static void shellSort(int[] arr) {
        //tag就是步长
        int temp;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
    }
}
