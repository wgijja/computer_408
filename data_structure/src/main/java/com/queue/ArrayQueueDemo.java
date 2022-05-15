package com.queue;

import java.util.Scanner;

/**
 * 用数组实现队列-有缺陷版（满队列后还能再加元素）
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {
        //创建队列类
        ArrayQueue queue = new ArrayQueue(3);
        Scanner scanner = new Scanner(System.in);
        boolean tag = true;
        while (tag) {
            System.out.println("请输入操作编码：a=新增，g=取出，h=显示第一个元素，s=显示队列，e=退出程序");
            char choice = scanner.next().charAt(0);
            switch (choice) {
                case 'a':
                    System.out.println("请输入需要新增的元素~");
                    try {
                        queue.addQueue(scanner.nextInt());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':
                    try {
                        queue.getValue();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        queue.getHead();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 's':
                    queue.showArr();
                    break;
                case 'e':
                    tag = false;
                    break;
                default:
                    System.out.println("请输入正确的操作编码！");
                    break;
            }
        }
        scanner.close();
        System.out.println("程序已正常退出~");
    }
}

/**
 * 队列类
 */
class ArrayQueue {

    //队列的最大容量
    private int maxSize;
    //队列头的前一个位置
    private int front;
    //队列尾的位置
    private int rear;
    //队列
    private int[] arrQueue;

    //构造方法
    public ArrayQueue(int maxSize) {
        this.front = -1;
        this.rear = -1;
        this.maxSize = maxSize;
        this.arrQueue = new int[maxSize];
    }

    //是否空队列
    public boolean isEmpty() {
        return front == rear;
    }

    //是否队列满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //新增元素
    public void addQueue(int value) {
        if (isFull()) {
            throw new RuntimeException("队列已满！不可再新增元素！");
        }
        rear++;
        arrQueue[rear] = value;
    }

    //取出元素
    public void getValue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空！无元素可取！");
        }
        front++;
        System.out.printf("取出的元素为：%d\n", arrQueue[front]);
        arrQueue[front] = 0;
        System.out.println();
    }

    //显示第一个元素
    public void getHead() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空！");
        }
        System.out.printf("第一个元素为：%d\n", arrQueue[front+1]);
        System.out.println();
    }

    //显示队列
    public void showArr() {
        for (int i : arrQueue) {
            System.out.printf("%d\t", i);
        }
        System.out.println();
    }
}
