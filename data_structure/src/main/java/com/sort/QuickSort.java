package com.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 6, 1, 3, 5, 7, 9, 8};
        quickSort2(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 快速排序
     *
     * @param arr
     */
    private static void quickSort(int[] arr, int left, int right) {
        //记录左下标，右下标
        int l = left;
        int r = right;
        //计算得出中轴的值
        int pivot = arr[(l + r) / 2];
        //定义一个临时变量用于交换
        int temp;
        //开始循环并交换
        while (l < r) {
            //在中轴的左边开始找，找大于或等于pivot的值
            while (arr[l] < pivot) {
                l++;
            }
            //在中轴的右边开始找，找小于或等于Pivot的值
            while (arr[r] > pivot) {
                r--;
            }
            //如果左下标大于等于右下标，则表示左边的值已都小于等于pivot，右边的值都大于等于pivot
            if (l >= r) {
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            //如果交换完后，发现arr[l]==pivot,则r向前移一位,因为arr[l]是换过来的，所以操作的是r
            if (arr[l] == pivot) {
                r--;
            }
            //如果交换完后，发现arr[r]==pivot,则l向后移一位,因为arr[r]是换过来的，所以操作的是l
            if (arr[r] == pivot) {
                l++;
            }
        }
        //如果 l == r ,则必须 l++ r-- ,否则会栈溢出
        if (l == r) {
            l++;
            r--;
        }
        //向左递归
        if (left < r) {
            quickSort(arr, left, r);
        }
        //向右递归
        if (right > l) {
            quickSort(arr, l, right);
        }
    }

    public static void quickSort2(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(l + r) / 2];
        int temp;
        while (l < r) {
            while (arr[l] < pivot) {
                l++;
            }
            while (arr[r] > pivot) {
                r--;
            }
            if (l >= r) {
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if (arr[l] == pivot) {
                r--;
            }
            if (arr[r] == pivot) {
                l++;
            }
        }
        if (l == r) {
            l++;
            r--;
        }
        if (left < r) {
            quickSort2(arr, left, r);
        }
        if (right > l) {
            quickSort2(arr, l, right);
        }
    }

    public static void quickSort3(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(l + r) / 2];
        int temp;
        while (l < r) {
            while (arr[l] < pivot) {
                l++;
            }
            while (arr[r] > pivot) {
                r--;
            }
            if (l >= r) {
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //交换过后需要判断有没有到中轴位置
            if (arr[l] == pivot) {
                r--;
            }
            if (arr[r] == pivot) {
                l++;
            }
        }
        //判断l和r是否相等，以免死循环
        if (l == r) {
            l++;
            r--;
        }
        //再判断是否要继续递归
        if (left < r) {
            quickSort3(arr, left, r);
        }
        if (right > l) {
            quickSort3(arr, l, right);
        }
    }
}
