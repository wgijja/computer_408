package com.sort;

import java.util.Arrays;

/**
 * @author 范剑虹
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9};
        heapSort4(arr);
        System.out.println("排序后的数组为：" + Arrays.toString(arr));
    }

    /**
     * 首先需要进行一次数组转大顶堆，然后将结果开始：交换位置、剩下的元素组成大顶堆、交换位置 这样循环.....
     *
     * @param arr
     */
    private static void heapSort(int[] arr) {
        //第一次将数组转成大顶堆 (arr.length/2 - 1)代表非叶子节点的下标
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            toHeap(arr, i, arr.length);
        }
        //将第一次的大顶堆的根节点放到数组最后的位置  然后再将剩下的数组继续变成大顶堆 再交换......循环
        //i>0 是因为i代表未排序数组最后一个下标 所以只需要排序到下标1
        for (int i = arr.length - 1; i > 0; i--) {
            //交换 下标0是最大的值
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            //再将剩下的数组转成大顶堆以便下次循环交换位置时是剩下的元素依然为大顶堆
            //0是最后一个非叶子节点 i是数组的最后一个下标
            toHeap(arr, 0, i);
        }
    }

    /**
     * 将数组转换成大顶堆数组
     *
     * @param arr    待转数组
     * @param i      非叶子节点的下标
     * @param length 待排序数组元素个数
     */
    private static void toHeap(int[] arr, int i, int length) {
        //将当前非叶子节点缓存，因为是大顶堆，所以可能会交换元素
        int temp = arr[i];
        //循环当前节点的叶子节点是否需要交换位置  左叶子节点=2*当前节点+1 右叶子节点=左叶子节点+1
        for (int k = i * 2 + 1; k < length; k = i * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                //将k指向右子节点
                k++;
            }
            //看叶子节点和非叶子节点大小来决定是否要交换位置
            if (temp < arr[k]) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        //此时i可能已指向k 即已交换位置 所以需要将之前缓存的元素放到叶子节点上
        arr[i] = temp;
    }

    private static void heapSort2(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            toHeap2(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            toHeap2(arr, 0, i);
        }
    }

    private static void toHeap2(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int j = i * 2 + 1; j < length; j = i * 2 + 1) {
            if (j + 1 < length && arr[j] < arr[j + 1]) {
                j++;
            }
            if (temp < arr[j]) {
                arr[i] = arr[j];
                i = j;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }

    private static void heapSort3(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            toHeap3(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            toHeap3(arr, 0, i);
        }
    }

    private static void toHeap3(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int j = 2 * i + 1; j < length; j = 2 * i + 1) {
            if (j + 1 < length && arr[j] < arr[j + 1]) {
                j++;
            }
            if (temp < arr[j]) {
                arr[i] = arr[j];
                i = j;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }

    private static void heapSort4(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            toHeap4(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            toHeap4(arr, 0, i);
        }
    }

    private static void toHeap4(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int j = 2 * i + 1; j < length; j = 2 * i + 1) {
            if (j + 1 < length && arr[j] < arr[j + 1]) {
                j++;
            }
            if (temp < arr[j]) {
                arr[i] = arr[j];
                i = j;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }
}
