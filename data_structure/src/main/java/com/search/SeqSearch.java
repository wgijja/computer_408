package com.search;

public class SeqSearch {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 9, 11, -1, 34, 89};
        int res = seqSearch(arr, 11);
        System.out.println("查找的元素下标为：" + res);
    }

    /**
     * 线性查找
     * 逐一比对，对比是否是相同的值
     */
    private static int seqSearch(int[] arr, int findValue) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == findValue) {
                return i;
            }
        }
        return -1;
    }
}
