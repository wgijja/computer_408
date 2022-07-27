package com.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分查找(需要有序）
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 8, 77, 89, 100, 100, 100, 100, 200};
        int res = binarySearch(arr, 0, arr.length - 1, 100);
        System.out.println("单个查找的元素下标为：" + res);
        System.out.println("查找多个值的下标为：" + binarySearchList(arr, 0, arr.length - 1, 100));

    }

    /**
     * 返回一个数的
     *
     * @param arr
     * @param left
     * @param right
     * @param findValue
     * @return
     */
    private static int binarySearch(int[] arr, int left, int right, int findValue) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (arr[mid] > findValue) {
            return binarySearch(arr, left, mid - 1, findValue);
        } else if (arr[mid] < findValue) {
            return binarySearch(arr, mid + 1, right, findValue);
        } else {
            return mid;
        }
    }

    /**
     * 找到一个数了就左右两边找
     *
     * @param arr
     * @param left
     * @param right
     * @param findValue
     * @return
     */
    public static List<Integer> binarySearchList(int[] arr, int left, int right, int findValue) {
        if (left > right) {
            return new ArrayList<>();
        }
        int mid = (left + right) / 2;
        if (findValue < arr[mid]) {
            return binarySearchList(arr, left, mid - 1, findValue);
        } else if (findValue > arr[mid]) {
            return binarySearchList(arr, mid + 1, right, findValue);
        } else {
            List<Integer> resList = new ArrayList<>();
            resList.add(mid);
            int tempIdx = mid - 1;
            while (tempIdx >= 0 && arr[tempIdx] == findValue) {
                resList.add(tempIdx);
                tempIdx--;
            }
            tempIdx = mid + 1;
            while (tempIdx < arr.length && arr[tempIdx] == findValue) {
                resList.add(tempIdx);
                tempIdx++;
            }
            return resList;
        }
    }
}
