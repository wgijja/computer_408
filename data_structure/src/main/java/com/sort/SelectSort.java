package com.sort;

import java.util.Arrays;

/**
 * 选择排序，思想是：找到位置再交换
 *
 * @author fjh
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 6, 1, 3, 5, 7, 9, 8};
        pra15(arr);
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
                    changeIndex = j;
                }
            }
            if (changeIndex != i) {
                int temp = arr[i];
                arr[i] = arr[changeIndex];
                arr[changeIndex] = temp;
            }
        }
    }

    private static void pra4(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    private static void pra5(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int changeIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[changeIndex]) {
                    changeIndex = j;
                }
            }
            if (changeIndex != i) {
                int temp = arr[i];
                arr[i] = arr[changeIndex];
                arr[changeIndex] = temp;
            }
        }
    }

    private static void pra6(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int changeIdx = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[changeIdx] > arr[j]) {
                    changeIdx = j;
                }
            }
            if (i != changeIdx) {
                int temp = arr[i];
                arr[i] = arr[changeIdx];
                arr[changeIdx] = temp;
            }
        }
    }

    private static void pra7(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int changeIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[changeIdx]) {
                    changeIdx = j;
                }
            }
            if (i != changeIdx) {
                int temp = arr[i];
                arr[i] = arr[changeIdx];
                arr[changeIdx] = temp;
            }
        }
    }

    private static void pra8(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int changeIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[changeIdx]) {
                    changeIdx = j;
                }
            }
            if (changeIdx != i) {
                int temp = arr[i];
                arr[i] = arr[changeIdx];
                arr[changeIdx] = temp;
            }
        }
    }

    private static void pra9(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int idx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[idx]) {
                    idx = j;
                }
            }
            if (idx != i) {
                int temp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = temp;
            }
        }
    }

    private static void pra10(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int idx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[idx] > arr[j]) {
                    idx = j;
                }
            }
            if (idx != i) {
                int temp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = temp;
            }
        }
    }

    private static void pra11(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int idx = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[idx] > arr[j]) {
                    idx = j;
                }
            }
            if (idx != i) {
                int temp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = temp;
            }
        }
    }

    private static void pra12(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int idx = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[idx] > arr[j]) {
                    idx = j;
                }
            }
            if (idx != i) {
                int temp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = temp;
            }
        }
    }

    private static void pra13(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int idx = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[idx] > arr[j]) {
                    idx = j;
                }
            }
            if (idx != i) {
                int temp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = temp;
            }
        }
    }

    private static void pra14(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int idx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[idx] > arr[j]) {
                    idx = j;
                }
            }
            if (idx != i) {
                int temp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = temp;
            }
        }
    }

    private static void pra15(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int idx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[idx]) {
                    idx = j;
                }
            }
            if (idx != i) {
                int temp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = temp;
            }
        }
    }
}
