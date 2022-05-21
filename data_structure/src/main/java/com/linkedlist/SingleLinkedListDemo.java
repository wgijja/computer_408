package com.linkedlist;

import java.util.Stack;

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
        //singleLinkedList.delete(twoTwo);
        Node twoD = new Node(7, "小猪", "小阿猪");
        //singleLinkedList.delete(twoD);
        singleLinkedList.show();
        System.out.println("链表的有效节点个数为：" + singleLinkedList.getLength(singleLinkedList.getHead()));
        int index = 3;
        System.out.println("倒数第" + index + "个节点为：" + singleLinkedList.getLastIndexOfNode(singleLinkedList.getHead(), index));
        //singleLinkedList.trans(singleLinkedList.getHead());
        //System.out.println("翻转之后的链表为：");
        //singleLinkedList.show();
        //从头到尾打印链表
        singleLinkedList.reversePrint(singleLinkedList.getHead());
    }

}

class SingleLinkedList {

    public Node getHead() {
        return head;
    }

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
            System.out.printf("未找到编号 %d 的节点\n", node.num);
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

    /**
     * 获取单链表有效节点的个数
     *
     * @return
     */
    public int getLength(Node head) {
        int size = 0;
        Node temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            } else {
                size++;
            }
            temp = temp.next;
        }
        return size;
    }

    /**
     * 获取单链表倒数第n个节点
     *
     * @return
     */
    public Node getLastIndexOfNode(Node head, int index) {
        //先判断链表是否有值
        if (head.next == null) {
            return null;
        }
        int size = getLength(head);
        Node temp = head.next;
        for (int i = 0; i < size - index; i++) {
            temp = temp.next;
        }
        if (size == 0 || index > size) {
            return null;
        }
        return temp;
    }

    /**
     * 链表的反转
     *
     * @return
     */
    public void trans(Node head) {
        //如果链表为空，或者链表只有一个节点则无需反转
        if (head.next == null || head.next.next == null) {
            return;
        }
        //定义一个临时的头节点
        Node tempHead = new Node(0, "", "");
        //辅助变量帮助遍历链表
        Node tempNode = head.next;
        //当前节点的下一个节点
        Node currNext;
        while (true) {
            if (tempNode == null) {
                break;
            }
            //先暂时保存当前节点的下一个节点
            currNext = tempNode.next;
            tempNode.next = tempHead.next;
            tempHead.next = tempNode;
            tempNode = currNext;
        }
        head.next = tempHead.next;
    }

    /**
     * 从尾到头打印单链表---利用栈,如果用上面的反转会破坏单链表
     *
     * @param head
     */
    public void reversePrint(Node head) {
        if (head.next == null) {
            return;
        }
        Node curr = head.next;
        Stack<Node> stack = new Stack<>();
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
        while (!stack.empty()) {
            System.out.println(stack.pop());
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