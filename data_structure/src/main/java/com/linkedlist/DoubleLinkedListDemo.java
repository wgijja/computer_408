package com.linkedlist;

public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        DoubleNode one = new DoubleNode(1, "猫", "小猫");
        DoubleNode two = new DoubleNode(2, "狗", "小狗");
        DoubleNode three = new DoubleNode(3, "龙", "小龙");
        DoubleNode four = new DoubleNode(4, "鸡", "小鸡");
        System.out.println("添加之前的链表：");
        doubleLinkedList.show(doubleLinkedList.getHead());
        doubleLinkedList.addLast(one);
        doubleLinkedList.addLast(two);
        doubleLinkedList.addLast(three);
        doubleLinkedList.addLast(four);
        System.out.println("添加之后的链表：");
        doubleLinkedList.show(doubleLinkedList.getHead());
        DoubleNode newThree = new DoubleNode(4, "鸭", "小鸭");
        doubleLinkedList.updateNode(newThree);
        System.out.println("修改之后的链表：");
        doubleLinkedList.show(doubleLinkedList.getHead());
        doubleLinkedList.deleteNode(newThree);
        System.out.println("删除之后的链表：");
        doubleLinkedList.show(doubleLinkedList.getHead());
    }
}

class DoubleLinkedList {

    DoubleNode head = new DoubleNode(0, "", "");

    /**
     * 获取头节点
     */
    public DoubleNode getHead() {
        return head;
    }

    /**
     * 遍历
     */
    public void show(DoubleNode head) {
        if (head.next == null) {
            System.out.println("数组为空！");
        }
        DoubleNode temp = head;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    /**
     * 尾部添加
     *
     * @param newNode
     */
    public void addLast(DoubleNode newNode) {
        DoubleNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.pre = temp;
    }

    /**
     * 修改一个节点的内容
     */
    public void updateNode(DoubleNode newNode) {
        boolean find = false;
        DoubleNode temp = head;
        while (temp != null) {
            if (temp.num == newNode.num) {
                find = true;
                break;
            }
            temp = temp.next;
        }
        if (find) {
            temp.name = newNode.name;
            temp.nickName = newNode.nickName;
        } else {
            System.out.println("未找到该节点！修改失败。");
        }
    }

    /**
     * 删除某个节点
     *
     * @param node
     */
    public void deleteNode(DoubleNode node) {
        DoubleNode temp = head.next;
        boolean find = false;
        while (temp != null) {
            if (temp.num == node.num) {
                find = true;
                break;
            }
            temp = temp.next;
        }
        if (find) {
            temp.pre.next = temp.next;
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        }
    }

}

class DoubleNode {

    public int num;

    public String name;

    public String nickName;

    public DoubleNode next;

    public DoubleNode pre;

    public DoubleNode() {
    }

    public DoubleNode(int num, String name, String nickName) {
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