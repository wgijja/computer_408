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
        singleLinkedList.addOrderly(one);
        singleLinkedList.show();
        Node twoTwo = new Node(2, "小猪", "小阿猪");
        singleLinkedList.update(twoTwo);
        singleLinkedList.show();
        singleLinkedList.delete(twoTwo);
        Node twoD = new Node(7, "小猪", "小阿猪");
        singleLinkedList.delete(twoD);
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
        //定义一个标识，判断节点是否存在
        boolean flag = false;
        //循环并判断
        while (true) {
            if (temp.next == null) {
                break;
            } else if (temp.next.num > node.num) {
                break;
            } else if (temp.next.num == node.num) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("准备插入的数据的编号 %d 已经存在，不能插入\n", node.num);
        } else {
            node.next = temp.next;
            temp.next = node;
        }

    }

    /**
     * 修改
     *
     * @param node
     */
    public void update(Node node) {
        Node temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                System.out.println("链表为空，无法修改");
                break;
            }
            if (temp.num == node.num) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = node.name;
            temp.nickName = node.nickName;
        } else {
            System.out.printf("未找到编号 %d 的节点！", node.num);
        }
    }

    /**
     * 删除节点
     */
    public void delete(Node node) {
        Node temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.num == node.num) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("未找到编号 %d 的节点", node.num);
        }
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

    public String nickName;

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