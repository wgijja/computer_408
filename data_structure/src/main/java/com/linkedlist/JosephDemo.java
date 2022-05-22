package com.linkedlist;

import lombok.Data;

/**
 * 约瑟夫问题
 */
public class JosephDemo {

    public static void main(String[] args) {
        Joseph joseph = new Joseph();
        joseph.addLast(33);
        joseph.list();
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
            if (cur.no == 1){
                break;
            }
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