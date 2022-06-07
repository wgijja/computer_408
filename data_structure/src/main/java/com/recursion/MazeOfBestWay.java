package com.recursion;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class MazeOfBestWay {

    public static void main(String[] args) {

        System.out.println("--------------");
        List<List<String>> ways = getWays();
        System.out.println("共" + ways.size() + "种策略！");
        List<Node> resList = new ArrayList<>();
        for (List<String> way : ways) {
            System.out.println("现在的策略是：" + way);
            int sum = 0;
            int[][] maze = getMaze();
            nextStepForBestWay(maze, 1, 1, way, sum, resList);
            System.out.println("需要走的步数为：" + resList.get(resList.size() - 1));
            System.out.println("走出迷宫的路径：");
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    System.out.print(maze[i][j] + " ");
                }
                System.out.println();
            }
        }
        System.out.println("所有策略需要的步数：");
        System.out.println(resList);
        //获取最优策略
        Integer integer = resList.stream().map(Node::getSum).min((a, b) -> a - b).get();
        System.out.println("最优的策略需要走的步数为:" + integer);
        List<Node> collect = resList.stream().filter(i -> i.getSum() == integer).collect(Collectors.toList());
        System.out.println("最优策略有：");
        System.out.println(collect);

    }

    private static int[][] getMaze() {
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
        return maze;
    }


    /**
     * 求最短路径
     *
     * @param maze    迷宫
     * @param a       下一步的横坐标
     * @param b       下一步的纵会标
     * @param orderBy 顺序的坐标
     * @return 是否可以走通
     */
    public static boolean nextStepForBestWay(int[][] maze, int a, int b, List<String> orderBy, int sum, List<Node> resMap) {
        String str = orderBy.get(0);
        String one = "" + str.charAt(0);
        String two = "" + str.charAt(1);
        String three = "" + str.charAt(2);
        String four = "" + str.charAt(3);
        if (maze[6][6] == 2) {
            //路已找到
            HashMap<String, Integer> map = new HashMap<>();
            resMap.add(new Node(one + two + three + four, sum));
            return true;
        } else {
            //首先要看这个点是否走过，没有走过才走，走过直接返回false
            if (maze[a][b] == 0) {
                sum++;
                maze[a][b] = 2;
                if (nextStepForBestWay(
                        maze,
                        one.equals("上") ? a - 1 : one.equals("下") ? a + 1 : a,
                        one.equals("左") ? b - 1 : one.equals("右") ? b + 1 : b,
                        orderBy,
                        sum,
                        resMap
                )) {
                    return true;
                } else if (nextStepForBestWay(
                        maze,
                        two.equals("上") ? a - 1 : two.equals("下") ? a + 1 : a,
                        two.equals("左") ? b - 1 : two.equals("右") ? b + 1 : b,
                        orderBy,
                        sum,
                        resMap
                )) {
                    return true;
                } else if (nextStepForBestWay(
                        maze,
                        three.equals("上") ? a - 1 : three.equals("下") ? a + 1 : a,
                        three.equals("左") ? b - 1 : three.equals("右") ? b + 1 : b,
                        orderBy,
                        sum,
                        resMap
                )) {
                    return true;
                } else if (nextStepForBestWay(
                        maze,
                        four.equals("上") ? a - 1 : four.equals("下") ? a + 1 : a,
                        four.equals("左") ? b - 1 : four.equals("右") ? b + 1 : b,
                        orderBy,
                        sum,
                        resMap
                )) {
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

    /**
     * 获取所有的路径
     *
     * @return
     */
    public static List<List<String>> getWays() {
        List<List<String>> res = new ArrayList<>();
        List<String> elements = Arrays.asList("上", "下", "左", "右");
        for (int i = 0; i < 4; i++) {
            String one = elements.get(i);
            for (int j = 0; j < 4; j++) {
                String two = elements.get(j);
                for (int k = 0; k < 4; k++) {
                    String three = elements.get(k);
                    for (int l = 0; l < 4; l++) {
                        String four = elements.get(l);
                        if (
                                !one.equals(two) &&
                                        !one.equals(three) &&
                                        !one.equals(four) &&
                                        !two.equals(three) &&
                                        !two.equals(four) &&
                                        !three.equals(four)
                        ) {
                            List<String> strings = new ArrayList<>();
                            strings.add(one + two + three + four);
                            res.add(strings);
                        }
                    }
                }
            }
        }
        return res;
    }

}

@Data
class Node {
    String name;
    int sum;

    public Node(String name, int sum) {
        this.name = name;
        this.sum = sum;
    }
}
