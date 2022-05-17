package com.linkedlist;

/**
 * @author fjh
 * @date 2022/5/17 0:11
 * <p>
 * 链表
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        Node one = new Node(1, "猫", "阿猫");
        Node two = new Node(2, "狗", "阿狗");
        Node three = new Node(3, "猪", "阿猪");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //无序
        //singleLinkedList.add(one);
        //singleLinkedList.add(three);
        //singleLinkedList.add(two);
        //求序
        singleLinkedList.addOrderly(three);
        singleLinkedList.addOrderly(two);
        singleLinkedList.addOrderly(one);
        singleLinkedList.show();
    }
}

class SingleLinkedList {

    //初始化一个头节点
    private Node head = new Node(0, "", "");

    /**
     * 新增方法
     *
     * @param node
     */
    public void add(Node node) {
        //注意 头节点不能动，所以需要一个辅助指针
        Node temp = head;
        while (true) {
            if (temp.next == null) {
                temp.next = node;
                break;
            } else {
                temp = temp.next;
            }
        }
    }

    /**
     * 顺序增加
     *
     * @param node
     */
    public void addOrderly(Node node) {
        //还是一样的，头节点不能动，所以需要一个辅助指针
        Node temp = head;
        //循环并判断
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.num > node.num) {
                break;
            }
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;

    }

    /**
     * 遍历
     */
    public void show() {
        //注意 头节点不能动，所以需要一个辅助指针
        Node temp = head;
        while (true) {
            if (temp.next == null) {
                System.out.println(temp);
                break;
            } else {
                System.out.println(temp);
                temp = temp.next;
            }
        }
    }

    @Override
    public String toString() {
        return "SingleLinkedList{" +
                "head=" + head +
                '}';
    }
}


class Node {
    public int num;
    public String name;

    private String nickName;

    public Node next;

    public Node() {
    }

    public Node(int num, String name, String nickName) {
        this.num = num;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Node{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}