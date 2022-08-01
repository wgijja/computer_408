package com.sort;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * 基数排序，桶排序的扩展，思想是：把数据按位数大小分到10个桶中进行排序
 *
 * @author fjh
 * @date 2022/7/25 17:42
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] arr = new int[]{53, 3, 542, 748, 14, 214};
        radixPra5(arr);
        System.out.println(Arrays.toString(arr));

        //测试一下性能，测试80000条数据执行时间 9s
        //int[] maxSize = new int[8000000];
        //for (int i = 0; i < 8000000; i++) {
        //    double random = Math.random();
        //    double v = random * 8000000;
        //    maxSize[i] = (int) (v);
        //}
        //StopWatch stopWatch = StopWatch.createStarted();
        //radixSort(maxSize);
        //stopWatch.stop();
        //System.out.println("执行花费了：" + stopWatch.getTime(TimeUnit.MILLISECONDS) + "ms");
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

    private static void radixSortPractice(int[] arr) {
        int maxValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }
        int maxLength = (maxValue + "").length();
        int[][] bucket = new int[10][arr.length];
        int[] bucketElementCount = new int[10];
        for (int i = 0, j = 1; i < maxLength; i++, j *= 10) {
            for (int value : arr) {
                int num = value / j % 10;
                bucket[num][bucketElementCount[num]] = value;
                bucketElementCount[num]++;
            }
            int index = 0;
            for (int k = 0; k < bucketElementCount.length; k++) {
                if (bucketElementCount[k] != 0) {
                    for (int l = 0; l < bucketElementCount[k]; l++) {
                        arr[index] = bucket[k][l];
                        index++;
                    }
                    bucketElementCount[k] = 0;
                }
            }
        }
    }

    private static void radixPra1(int[] arr) {
        //找最大数
        int maxValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }
        //位数
        int maxLength = (maxValue + "").length();
        int[][] bucket = new int[10][arr.length];
        int[] everyElement = new int[10];
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //取出来放到桶中
            for (int value : arr) {
                int num = value / n % 10;
                bucket[num][everyElement[num]] = value;
                everyElement[num]++;
            }
            int index = 0;
            for (int j = 0; j < everyElement.length; j++) {
                if (everyElement[j] != 0) {
                    for (int k = 0; k < everyElement[j]; k++) {
                        arr[index] = bucket[j][k];
                        index++;
                    }
                    everyElement[j] = 0;
                }
            }
        }
    }

    private static void radixPra2(int[] arr) {
        int maxValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }
        int maxLength = (maxValue + "").length();
        int[][] bucket = new int[10][arr.length];
        int[] counts = new int[10];
        for (int i = 0, j = 1; i < maxLength; i++, j *= 10) {
            for (int value : arr) {
                int num = value / j % 10;
                bucket[num][counts[num]] = value;
                counts[num]++;
            }
            int t = 0;
            for (int index = 0; index < counts.length; index++) {
                if (counts[index] != 0) {
                    for (int k = 0; k < counts[index]; k++) {
                        arr[t] = bucket[index][k];
                        t++;
                    }
                    counts[index] = 0;
                }
            }
        }
    }

    private static void radixPra3(int[] arr) {
        int maxValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }
        int maxLength = (maxValue + "").length();
        int[][] bucket = new int[10][arr.length];
        int[] counts = new int[10];
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int value : arr) {
                int bit = value / n % 10;
                bucket[bit][counts[bit]] = value;
                counts[bit]++;
            }
            int index = 0;
            for (int num = 0; num < counts.length; num++) {
                if (counts[num] != 0) {
                    for (int j = 0; j < counts[num]; j++) {
                        arr[index] = bucket[num][j];
                        index++;
                    }
                    counts[num] = 0;
                }
            }
        }
    }

    private static void radixPra4(int[] arr) {
        int maxVal = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxVal) {
                maxVal = arr[i];
            }
        }
        int maxLength = (maxVal + "").length();
        int[][] bucket = new int[10][arr.length];
        int[] counts = new int[10];
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int val : arr) {
                int bit = val / n % 10;
                bucket[bit][counts[bit]] = val;
                counts[bit]++;
            }
            int index = 0;
            for (int t = 0; t < counts.length; t++) {
                if (counts[t] != 0) {
                    for (int j = 0; j < counts[t]; j++) {
                        arr[index] = bucket[t][j];
                        index++;
                    }
                    counts[t] = 0;
                }
            }
        }
    }

    private static void radixPra5(int[] arr) {
        int max = arr[0];
        for (int val : arr) {
            if (max < val) {
                max = val;
            }
        }
        int maxLength = (max + "").length();
        int[][] bucket = new int[10][arr.length];
        int[] counts = new int[10];
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int val : arr) {
                int bit = val / n % 10;
                bucket[bit][counts[bit]] = val;
                counts[bit]++;
            }
            int index = 0;
            for (int num = 0; num < counts.length; num++) {
                if (counts[num] != 0) {
                    for (int size = 0; size < counts[num]; size++) {
                        arr[index] = bucket[num][size];
                        index++;
                    }
                    counts[num] = 0;
                }
            }
        }
    }
}
