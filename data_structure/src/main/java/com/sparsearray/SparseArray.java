package com.sparsearray;


/**
 * 二维数组->稀疏数组实现思路：
 * 1）获取二维数组中有效值的个数 sum
 * 2）根据 sum 创建稀疏数组
 * 3）循环二维数组将有效值设置进稀疏数组中
 *
 * 稀疏数组->二维数组实现思路
 * 1）根据稀疏数组第一行数据创建原数组
 * 2）遍历稀疏数组给二维数组设置值
 */
public class SparseArray {

    public static void main(String[] args) {
        System.out.println("====================二维数组->稀疏数组========================");
        int row = 9;
        int col = 9;
        //定义一个原数组
        int[][] origin = new int[row][col];
        origin[2][3] = 1;
        origin[4][1] = 2;
        origin[6][5] = 1;
        System.out.println("原始的数组------》");
        for (int[] ints : origin) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }
        //获取原数组中的有效值个数
        int count = 0;
        for (int[] ints : origin) {
            for (int anInt : ints) {
                if (anInt != 0) {
                    count++;
                }
            }
        }
        System.out.println("有效值个数为：" + count);
        //创建稀疏数组
        int[][] sparseArray = new int[count + 1][3];
        //设置第一行的信息
        sparseArray[0][0] = row;
        sparseArray[0][1] = col;
        sparseArray[0][2] = count;
        //设置有效值行的信息
        int sparseRow = 0;
        for (int i = 1; i < origin.length; i++) {
            int[] ints = origin[i];
            for (int y = 0; y < ints.length; y++) {
                int value = origin[i][y];
                if (value != 0) {
                    sparseRow++;
                    sparseArray[sparseRow][0] = i;
                    sparseArray[sparseRow][1] = y;
                    sparseArray[sparseRow][2] = value;
                }
            }
        }
        System.out.println("得到的稀疏数组为------------>");
        for (int[] ints : sparseArray) {
            System.out.printf("%d\t%d\t%d\t\n", ints[0], ints[1], ints[2]);
        }
        System.out.println("====================稀疏数组->二维数组=========================");

        //根据稀疏数组第一行数据创建原数组
        int[][] toOrigin = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            toOrigin[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        System.out.println("转回来的二维数组为--------------->");
        for (int[] ints : toOrigin) {
            for (int j = 0; j < toOrigin.length; j++) {
                System.out.printf("%d\t", ints[j]);
            }
            System.out.println();
        }

    }
}
