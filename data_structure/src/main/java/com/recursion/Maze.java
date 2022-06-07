package com.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 使用递归解决迷宫找路径问题
 */
public class Maze {

    public static void main(String[] args) {
        //定义一个二维数据表示迷宫
        int row = 8;
        int col = 8;
        int[][] maze = new int[row][col];
        //将墙建越来
        for (int i = 0; i < row; i++) {
            maze[i][0] = 1;
            maze[i][col - 1] = 1;
        }
        for (int i = 0; i < col; i++) {
            maze[0][i] = 1;
            maze[row - 1][i] = 1;
        }
        //障碍物
        maze[3][1] = 1;
        maze[3][2] = 1;

        System.out.println("建好墙的迷宫：");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
        //设置起始点
        nextStep(maze, 1, 1);

        System.out.println("走出迷宫的路径：");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 走动的方法
     * 约定好走到右下角即为成功
     *
     * @param maze 迷宫
     * @param a    下一步的横坐标
     * @param b    下一步的纵会标
     * @return 是否可以走通
     */
    public static boolean nextStep(int[][] maze, int a, int b) {
        if (maze[6][6] == 2) {
            //路已找到
            return true;
        } else {
            //首先要看这个点是否走过，没有走过才走，走过直接返回false
            if (maze[a][b] == 0) {
                maze[a][b] = 2;
                // 约定 下->右->左->上 这样走
                if (nextStep(maze, a + 1, b)) {
                    return true;
                } else if (nextStep(maze, a, b + 1)) {
                    return true;
                } else if (nextStep(maze, a, b - 1)) {
                    return true;
                } else if (nextStep(maze, a - 1, b)) {
                    return true;
                } else {
                    maze[a][b] = 3;
                    return false;
                }
            }
            //如果不等于0即可能为 1、2、3，都应该直接返回false
            return false;
        }
    }
}
