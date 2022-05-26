package com.stack;

/**
 * @author fjh
 * @date 2022/5/26 8:35
 */
public class ArrayStackDemo {

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        System.out.println("取出的元素为：" + stack.pop());
        stack.push(74);
        stack.push(44);
        stack.push(87);
        stack.push(6);
        stack.push(7);
        stack.push(9);
        stack.list();
        System.out.println("取出的元素为：" + stack.pop());
        stack.list();
    }
}

class ArrayStack {

    /**
     * 栈的大小
     */
    private int maxSize;

    /**
     * 数组
     */
    private int[] stack;

    /**
     * 栈顶
     */
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    /**
     * 是否栈满
     *
     * @return
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * 是否栈空
     *
     * @return
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 新增元素
     *
     * @param value
     */
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满，新增失败！");
            return;
        }
        top++;
        stack[top] = value;
    }

    /**
     * 获取一个元素
     *
     * @return
     */
    public int pop() {
        if (isEmpty()) {
            System.out.println("栈为空！");
            return -999;
        }
        int temp = stack[top];
        top--;
        return temp;
    }

    /**
     * 从栈顶开始遍历栈
     */
    public void list() {
        if (isEmpty()) {
            System.out.println("栈为空！");
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }
}
