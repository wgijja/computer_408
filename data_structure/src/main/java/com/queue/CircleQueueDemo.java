package com.queue;

import java.util.Scanner;

/**
 * 环形队列
 */
public class CircleQueueDemo {

    public static void main(String[] args) {
//创建队列类
        CircleQueue queue = new CircleQueue(4);
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

class CircleQueue {
    //队列的最大容量
    private int maxSize;
    //队列头元素的位置，初始值为0
    private int front;
    //队列尾元素的位置+1，因为约定队列中预留的有一个空的位置！
    private int rear;
    //队列
    private int[] arrQueue;


    //构造方法
    public CircleQueue(int maxSize) {
        this.front = 0;
        this.rear = 0;//其实可以不用赋值，因为int默认值就是0
        this.maxSize = maxSize;//因为约定有一个空位置，所以队列中的有效值是 maxSize-1
        this.arrQueue = new int[maxSize];
    }

    //是否空队列
    public boolean isEmpty() {
        return front == rear;
    }

    //是否队列满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //新增元素
    public void addQueue(int value) {
        if (isFull()) {
            throw new RuntimeException("队列已满！不可再新增元素！");
        }
        //因为rear本身就是指最后一个元素的后一位，所以应该直接赋值，赋值后向后移动1
        arrQueue[rear] = value;
        //需要考虑front回到前面的位置，所以应该取模
        rear = (rear + 1) % maxSize;
    }

    //取出元素
    public void getValue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空！无元素可取！");
        }
        System.out.printf("取出的元素为：%d\n", arrQueue[front]);
        front = (front + 1) % maxSize;
        System.out.println();
    }

    //显示第一个元素
    public void getHead() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空！");
        }
        System.out.printf("第一个元素为：%d\n", arrQueue[front]);
        System.out.println();
    }

    //显示队列
    public void showArr() {
        if (isEmpty()) {
            System.out.println("现在是一个空队列！");
            return;
        }
        System.out.println("现在的队列为：");
        //应该从front开始遍历，遍历个数为有效数据个数
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arrQueue[%d]=%d\t", i % maxSize, arrQueue[i % maxSize]);
        }
        System.out.println();
    }

    //获取队列中有多少个有效数据
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }
}
