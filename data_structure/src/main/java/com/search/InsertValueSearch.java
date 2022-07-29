package com.search;

/**
 * 插值查找算法
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }
        int resIdx = insertValSearchPra(arr, 0, arr.length - 1, 100);
        System.out.println("查找的下标为：" + resIdx);
    }

    private static int insertValueSearch(int[] arr, int left, int right, int findValue) {
        //findValue < arr[0] || findValue > arr[arr.length - 1] 不仅是为了效率，也是为了防止求mid时越界
        if (left > right || findValue < arr[0] || findValue > arr[arr.length - 1]) {
            return -1;
        }
        //求出Mid  自适应的一种写法
        int mid = left + (right - left) * (findValue - arr[left]) / (arr[right] - arr[left]);
        int midValue = arr[mid];
        if (findValue > midValue) {
            return insertValueSearch(arr, mid + 1, right, findValue);
        } else if (findValue < mid) {
            return insertValueSearch(arr, left, mid - 1, findValue);
        } else {
            return mid;
        }
    }

    private static int insertValSearchPra(int[] arr, int left, int right, int findValue) {
        if (left > right || findValue < arr[0] || findValue > arr[arr.length - 1]) {
            return -1;
        }
        int mid = left + (right - left) * (findValue - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if (findValue > midVal) {
            return insertValSearchPra(arr, mid + 1, right, findValue);
        } else if (findValue < midVal) {
            return insertValSearchPra(arr, left, mid - 1, findValue);
        } else {
            return mid;
        }
    }

}
