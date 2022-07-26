package com.sort;

import java.util.Arrays;

/**
 * 思想是：把数组分成一个有序列表和一个无序列表，将无序列表中的值插入到有序列表中
 *
 * @author fjh
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 6, 1, 3, 5, 7, 9, 8};
        pra4(arr);
        System.out.println(Arrays.toString(arr));

        //测试一下性能，测试80000条数据执行时间 730ms
        //int[] maxSize = new int[80000];
        //for (int i = 0; i < 80000; i++) {
        //    maxSize[i] = (int) (Math.random() * 80000);
        //}
        //StopWatch stopWatch = StopWatch.createStarted();
        //insertionSort(maxSize);
        //stopWatch.stop();
        //System.out.println("执行花费了：" + stopWatch.getTime(TimeUnit.MILLISECONDS) + "ms");
    }

    /**
     * 插入排序
     *
     * @param arr
     */
    private static void insertionSort(int[] arr) {
        int insertValue, insertIndex;
        for (int i = 1; i < arr.length; i++) {
            //临时存储需要插入的元素
            insertValue = arr[i];
            //记录需要插入的下标，因为总是与前面一个数相比，所以减1
            insertIndex = i - 1;
            //在下标不越界、且待插入元素小于前一个元素的情况下，循环
            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                //将前一个元素后移，不用担心当前元素，因为已经存储在insertValue中
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            //因为insertIndex是前一个下标，如果前一个下标不满足时，则是现在的这个位置，所以要+1
            arr[insertIndex + 1] = insertValue;
        }
    }

    private void practice(int[] arr) {
        //将欲排序的元素分成两组，然后从后一组拿元素在前一组中找到位置并插入
        int insertValue, insertIndex;
        for (int i = 1; i < arr.length; i++) {
            //存储需要插入的元素
            insertValue = arr[i];
            insertIndex = i - 1;
            //在下标不越界，且要插入的元素比前一个元素要小的时候循环
            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            //循环结束后，将insertValue赋值给insertIndex+1的位置上
            arr[insertIndex + 1] = insertValue;
        }
    }

    private void practiceTwo(int[] arr) {
        int insertValue, insertIndex;
        for (int i = 1; i < arr.length; i++) {
            insertValue = arr[i];
            insertIndex = i - 1;
            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = insertValue;
        }
    }

    private static void pra(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertIndex = i - 1;
            int insertValue = arr[i];
            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = insertValue;
        }
    }

    private static void pra2(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertValue = arr[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && arr[insertIndex] > insertValue) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = insertValue;
        }
    }

    private static void pra3(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertIndex = i - 1;
            int insertValue = arr[i];
            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = insertValue;
        }
    }

    private static void pra4(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertValue = arr[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && arr[insertIndex] > insertValue) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = insertValue;
        }
    }
}
