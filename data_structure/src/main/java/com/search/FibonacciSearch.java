package com.search;

import java.util.Arrays;

/**
 * 斐波那契查找
 *
 * @author fjh
 * @date 2022/7/29 14:32
 */
public class FibonacciSearch {

    public static int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
    }

    /**
     * 返回一个斐波那契数列
     *
     * @return
     */
    public static int[] fib() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 1];
        }
        return f;
    }

    /**
     * 斐波那契查找算法
     *
     * @param arr
     * @param key
     * @return
     */
    public static int fibSearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        //斐波那契分割数值下标
        int k = 0;
        //存储mid值
        int mid = 0;
        int[] f = fib();
        //获取到斐波那契分割数值的下标
        while (high > f[k] - 1) {
            k++;
        }
        //因为f[k] 可以大于查找数组长度，所以构造一个新数组,长度不够的以最后一个元素填充
        int[] temp = Arrays.copyOf(arr, f[k]);
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }
        //现在开始在数组中查找元素
        while (low <= high) {
            mid = low + f[k - 1] - 1;
            if (key < temp[mid]) {
                high = mid + 1;
                //f[k] = f[k-1]+f[k-2]   ==> f[k-1] = f[k-2] +f[k-3]
                k--;
            } else if (key > temp[mid]) {
                low = mid + 1;
                k -= 2;
            } else {
                //需要确定返回的是哪个下标
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }
        return -1;
    }
}
