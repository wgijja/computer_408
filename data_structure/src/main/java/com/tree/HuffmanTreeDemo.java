package com.tree;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author 范剑虹
 * @date 2022-11-15 22:12
 */
public class HuffmanTreeDemo {

    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        HuffManNode huffManNode = createHuffmanTree(arr);
        huffManNode.preList();
    }

    public static HuffManNode createHuffmanTree(int[] arr) {
        //将数组放到集合中去
        ArrayList<HuffManNode> huffmanNodeList = new ArrayList<>();
        for (int val : arr) {
            huffmanNodeList.add(new HuffManNode(val));
        }
        while (huffmanNodeList.size() > 1) {
            //1、排序
            Collections.sort(huffmanNodeList);
            //2、取最小的两份棵树
            HuffManNode first = huffmanNodeList.get(0);
            HuffManNode second = huffmanNodeList.get(1);
            //3、构建新树
            HuffManNode parent = new HuffManNode(first.value + second.value);
            parent.leftNode = first;
            parent.rightNode = second;

            //4、将树放回原数列,并将取出的两个移除
            huffmanNodeList.remove(first);
            huffmanNodeList.remove(second);
            huffmanNodeList.add(parent);
        }
        //返回的既是赫夫曼树的root结点
        return huffmanNodeList.get(0);
    }

    public void preList(HuffManNode root) {
        if (root == null) {
            System.out.println("树为空树！");
        } else {
            root.preList();
        }
    }

}

class HuffManNode implements Comparable<HuffManNode> {

    Integer value;

    HuffManNode leftNode;

    HuffManNode rightNode;

    public HuffManNode(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "HuffManNode{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(HuffManNode o) {
        return this.value - o.value;
    }

    public void preList() {
        System.out.println(this);
        if (this.leftNode != null) {
            this.leftNode.preList();
        }
        if (this.rightNode != null) {
            this.rightNode.preList();
        }
    }
}
