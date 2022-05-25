package com.linkedlist;

import lombok.Data;

/**
 * 约瑟夫问题
 */
public class JosephDemo {

    public static void main(String[] args) {
        Joseph joseph = new Joseph();
        joseph.addLast(10);
        joseph.list();
        System.out.println("取出的顺序是：");
        joseph.getOutOrder(2, 3, 10);
    }
}

class Joseph {

    JosephNode first = null;

    /**
     * 添加多少个节点到单向循环链表中
     *
     * @param num
     */
    public void addLast(int num) {

        //head不能动,创建一个临时变量来记录当前最后一个节点
        JosephNode cur = null;
        for (int i = 1; i <= num; i++) {
            //根据编号创建节点
            JosephNode node = new JosephNode(i);
            //第一个节点
            if (i == 1) {
                first = node;
                first.next = first;//形成环形
                cur = first;
            } else {
                cur.next = node;
                node.next = first;
                cur = node;
            }
        }
    }

    /**
     * 遍历单向循环链表
     */
    public void list() {
        if (first == null) {
            System.out.println("链表为空！");
            return;
        }
        JosephNode cur = first;
        while (true) {
            System.out.printf("节点编号为：%d\n", cur.no);
            cur = cur.next;
            if (cur.no == 1) {
                break;
            }
        }
    }

    /**
     * 根据用户输入，获取约瑟夫问题的出链表的节点顺序
     *
     * @param startNum  开始的位置
     * @param eachCount 每次数的个数
     * @param size
     */
    public void getOutOrder(int startNum, int eachCount, int size) {
        if (first == null || startNum < 1 || startNum > size) {
            System.out.println("参数不正确！");
            return;
        }
        //创建另一个辅助变量
        JosephNode helper = first;
        //移动到链表的最后
        while (helper.next != first) {
            helper = helper.next;
        }
        //将两个辅助变量移动到开始的位置
        for (int i = 0; i < startNum - 1; i++) {
            first = first.next;
            helper = helper.next;
        }
        //根据指示移动多少个节点
        while (true) {
            //当first==helper时，即为最后一个
            if (first == helper) {
                System.out.printf("取出的节点是：%d", first.no);
                break;
            }
            for (int i = 0; i < eachCount - 1; i++) {
                first = first.next;
                helper = helper.next;
            }
            System.out.printf("取出的节点是：%d\n", first.no);
            first = first.next;
            helper.next = first;
        }
    }
}

@Data
class JosephNode {
    public int no;

    public JosephNode next;

    public JosephNode(int no) {
        this.no = no;
    }
}