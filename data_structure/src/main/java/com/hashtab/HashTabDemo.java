package com.hashtab;

import java.util.Scanner;

/**
 * 使用hash表管理雇员
 */
public class HashTabDemo {

    public static void main(String[] args) {
        HashTab hashTab = new HashTab(7);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add:添加雇员");
            System.out.println("list:遍历雇员");
            System.out.println("find:找雇员");
            System.out.println("exit:退出");
            String next = scanner.next();
            switch (next) {
                case "add":
                    System.out.println("请输入编号！");
                    int num = scanner.nextInt();
                    System.out.println("请输入名字！");
                    String name = scanner.next();
                    hashTab.add(new Employ(num, name));
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("请输入员工ID");
                    int i = scanner.nextInt();
                    hashTab.findById(i);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }

        }
    }

}

class HashTab {

    private int size;
    private EmployLinkedList[] array;

    public HashTab(int size) {
        this.size = size;
        //初始化链表
        array = new EmployLinkedList[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = new EmployLinkedList();
        }
    }

    /**
     * 根据id取hash值
     *
     * @param num
     * @return
     */
    public int hashFun(int num) {
        return num % size;
    }

    public void add(Employ employ) {
        int num = employ.num;
        int index = hashFun(num);
        array[index].add(employ);
    }

    public void list() {
        for (int i = 0; i < array.length; i++) {
            array[i].list(i);
        }
    }

    public void findById(int id) {
        Employ byId = array[hashFun(id)].findById(id);
        if (byId == null) {
            System.out.println("未找到该员工!");
        } else {
            System.out.println("员工的信息为：" + byId);
        }
    }

}

class Employ {
    public int num;
    public String name;
    public Employ next;

    public Employ(int num, String name) {
        this.num = num;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employ{" +
                "num=" + num +
                ", name='" + name + '\'' +
                '}';
    }
}

class EmployLinkedList {
    public Employ head;

    public void add(Employ employ) {
        if (head == null) {
            head = employ;
        } else {
            Employ cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = employ;
        }
    }

    public void list(int i) {
        if (head == null) {
            System.out.println("链表" + i + "为空！");
        } else {
            System.out.print("链表" + i + "下的雇员为：");
            Employ cur = head;
            System.out.print(head);
            while (cur.next != null) {
                System.out.print("==>" + cur.next);
                cur = cur.next;
            }
            System.out.println();
        }
    }

    public Employ findById(int id) {
        Employ cur = head;
        if (head == null) {
            return null;
        }
        if (cur.num == id) {
            return head;
        }
        while (cur.next != null) {
            if (cur.next.num == id) {
                cur = cur.next;
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
}
