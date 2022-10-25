package com.tree;

/**
 * 练习
 * 前序遍历
 * 中序遍历
 * 后序遍历
 */
public class BinaryTreeDemo {

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();
        Node root = new Node(1, "唐僧");
        Node node2 = new Node(2, "孙悟空");
        root.leftNode = node2;
        Node node3 = new Node(3, "猪八戒");
        root.rightNode = node3;
        Node node4 = new Node(4, "沙和尚");
        node3.rightNode = node4;
        binaryTree.setRoot(root);

        System.out.println("前");
        binaryTree.preOrder();
        System.out.println("中");
        binaryTree.infixOrder();
        System.out.println("后");
        binaryTree.postOrder();
    }
}


class BinaryTree {

    private Node root;

    public void setRoot(Node root) {
        this.root = root;
    }

    //前序遍历
    public void preOrder(){
        root.preOrder();
    }

    //前序遍历
    public void infixOrder(){
        root.infixOrder();
    }

    //前序遍历
    public void postOrder(){
        root.postOrder();
    }

}

class Node {

    public Integer num;

    public String name;

    public Node leftNode;

    public Node rightNode;

    public Node(Integer num, String name) {
        this.num = num;
        this.name = name;
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.leftNode != null) {
            this.leftNode.preOrder();
        }
        if (this.rightNode != null) {
            this.rightNode.preOrder();
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.leftNode != null) {
            this.leftNode.infixOrder();
        }
        System.out.println(this);
        if (this.rightNode != null) {
            this.rightNode.infixOrder();
        }
    }

    //前序遍历
    public void postOrder() {
        if (this.leftNode != null) {
            this.leftNode.postOrder();
        }
        if (this.rightNode != null) {
            this.rightNode.postOrder();
        }
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Node{" +
                "num=" + num +
                ", name='" + name + '\'' +
                '}';
    }
}
