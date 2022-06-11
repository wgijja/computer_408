package com.recursion;

/**
 * 8皇后问题
 */
public class Queen {

    //多少个皇后
    int max = 8;
    //存放位置的数组
    int[] arr = new int[max];
    //多少种摆法
    int count;

    public static void main(String[] args) {
        Queen queen = new Queen();
        queen.check(0);
        System.out.printf("一共有%d种解法!", queen.count);
    }

    /**
     * 放置皇后
     *
     * @param n 第几个皇后
     */
    public void check(int n) {
        if (n == max) {
            count++;
            printArray();
            return;
        }
        for (int i = 0; i < max; i++) {
            arr[n] = i;
            if (judgeRepeat(n)) {
                //如果不冲突
                check(n + 1);
            }
            //如果冲突，则回溯
        }
    }


    /**
     * 判断是否冲突
     *
     * @param n 第几个皇后
     */
    public boolean judgeRepeat(int n) {
        for (int i = 0; i < n; i++) {
            if (arr[n] == arr[i] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 打印数组
     */
    public void printArray() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
