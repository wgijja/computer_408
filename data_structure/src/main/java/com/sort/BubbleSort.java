package com.sort;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 6, 1, 3, 5, 7, 8, 9};
        bubbleSort(arr);
        int[] arr2 = new int[]{2, 4, 6, 1, 3, 5, 7, 8, 9};
        bubbleSortGood(arr2);
    }

    /**
     * 未优化的冒泡排序
     *
     * @param arr
     */
    private static void bubbleSort(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count++;
            for (int j = 0; j < arr.length - 1; j++) {
                int temp = arr[j];
                int pre = arr[j];
                int end = arr[j + 1];
                if (pre > end) {
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.printf("循环一共执行了%d次\n", count);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /**
     * 优化的冒泡排序
     *
     * @param arr
     */
    private static void bubbleSortGood(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            boolean change = false;
            count++;
            for (int j = 0; j < arr.length - 1; j++) {
                int temp = arr[j];
                int pre = arr[j];
                int end = arr[j + 1];
                if (pre > end) {
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    change = true;
                }
            }
            if (!change) {
                break;
            }
        }
        System.out.printf("循环一共执行了%d次\n", count);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
