package com.sort;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class ShellSort {

    public static void main(String[] args) {

        int[] arr = new int[]{2, 4, 6, 1, 3, 5, 7, 9, 8};
        praG(arr);
        System.out.println(Arrays.toString(arr));


        //测试一下性能，测试80000条数据执行时间 9s
        //  int[] maxSize = new int[80000];
        //for (int i = 0; i < 80000; i++) {
        //    maxSize[i] = (int) (Math.random() * 80000);
        //}
        //StopWatch stopWatch = StopWatch.createStarted();
        //shellSort(maxSize);
        //stopWatch.stop();
        //System.out.println("交换法执行花费了：" + stopWatch.getTime(TimeUnit.SECONDS) + "s");


        //测试一下性能，测试80000条数据执行时间 9s
        //int[] maxSize2 = new int[80000];
        //for (int i = 0; i < 80000; i++) {
        //    maxSize2[i] = (int) (Math.random() * 80000);
        //}
        //StopWatch stopWatch2 = StopWatch.createStarted();
        //shellSortGood(maxSize2);
        //stopWatch2.stop();
        //System.out.println("位移法执行花费了：" + stopWatch2.getTime(TimeUnit.MILLISECONDS) + "ms");
    }

    /**
     * 希尔排序(交换式）
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

    /**
     * 希尔排序（移位法）
     *
     * @param arr
     */
    public static void shellSortGood(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (temp < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
        }
    }

    private void shellSort2(int[] arr) {
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

    private void shellSortGood2(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (temp < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
        }
    }

    private void practiceShellOne(int[] arr) {
        //gap就是步长
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

    private void practiceShellGood2(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                //使用插入排序
                int insertIndex = i;
                int insertValue = arr[i];
                while (insertIndex - gap >= 0 && insertValue < arr[insertIndex - gap]) {
                    arr[insertIndex] = arr[insertIndex - gap];
                    insertIndex -= gap;
                }
                arr[insertIndex] = insertValue;
            }
        }
    }

    private static void pra(int[] arr) {
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

    private static void praG(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                //使用插入排序
                int insertIndex = i;
                int insertValue = arr[insertIndex];
                while (insertIndex - gap >= 0 && insertValue < arr[insertIndex - gap]) {
                    arr[insertIndex] = arr[insertIndex - gap];
                    insertIndex -= gap;
                }
                arr[insertIndex] = insertValue;
            }
        }
    }

}
