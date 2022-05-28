package com.stack;

import java.util.Stack;

/**
 * 链表来模拟栈
 */
public class LinkedListStackDemo {

    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack(5);
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        stack.push(one);
        stack.push(two);
        stack.push(three);
        stack.push(four);
        stack.push(five);
        stack.push(six);
        System.out.println("遍历栈！");
        stack.list();
        Node pop = stack.pop();
        if (pop != null) {
            System.out.println("取出的元素为:" + pop);
        } else {
            System.out.println("栈空，无元素");
        }
        System.out.println("遍历栈！");
        stack.list();
        System.out.println("执行结束！");
    }
}


class LinkedListStack {
    int maxSize;
    Node head = new Node(-1);

    public LinkedListStack(int maxSize) {
        this.maxSize = maxSize;
    }

    /**
     * 链表中最大个数
     *
     * @return
     */
    public int maxSize() {
        int a = 0;
        Node temp = head.next;
        while (temp != null) {
            a++;
            temp = temp.next;
        }
        return a;
    }

    public boolean isFull() {
        return this.maxSize == maxSize();
    }

    public boolean isEmpty() {
        return head.next == null;
    }

    /**
     * 添加一个元素
     *
     * @param node
     */
    public void push(Node node) {
        if (isFull()) {
            System.out.println("栈满！添加失败！");
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    /**
     * 弹出一个元素
     */
    public Node pop() {
        if (isEmpty()) {
            System.out.println("栈空！");
            return null;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node out = temp;
        Node pre = head;
        while (pre.next != temp) {
            pre = pre.next;
        }
        pre.next = null;
        return out;
    }

    /**
     * 遍历这个栈，从栈顶开始
     */
    public void list() {
        if (isEmpty()) {
            System.out.println("栈为空！");
            return;
        }
        Stack<Node> nodes = new Stack<>();
        Node temp = head.next;
        while (temp != null) {
            nodes.push(temp);
            temp = temp.next;
        }
        while (!nodes.isEmpty()) {
            System.out.println("遍历-->" + nodes.pop());
        }
    }

}


class Node {
    int no;
    Node next;

    public Node(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                '}';
    }
}