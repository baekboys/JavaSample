package com.baek.algorithm;

public class BinaryTree {
    class Node {
        int data;
        Node left;
        Node right;
    }

    public Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node makeNode(Node left, int data, Node right) {
        Node node = new Node();
        node.data = data;
        node.left = left;
        node.right = right;
        return node;
    }

    public Node search(int data, Node node) {
        if (node != null) {
            if (node.data == data) {
                System.out.println("찾았다!!!");
                return node;
            } else {
                System.out.println("없어요... 좌측노드 찾아볼께요..!!!" + node.data);
                Node left = search(data, node.left);
                if (left == null) {
                    System.out.println("역시 없어요... 우측노드 찾아볼께요..!!!" + node.data);
                    return search(data, node.right);
                }
                else
                    return left;
            }
        }
        return null;
    }

    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.data);
            inOrder(node.right);
        }
    }

    public void preOrder(Node node) {
        if (node != null) {
            System.out.println(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.data);
        }
    }

    public static void main(String[] args) {
        BinaryTree t = new BinaryTree();

        Node n4 = t.makeNode(null,4, null);
        Node n5 = t.makeNode(null,5, null);
        Node n2 = t.makeNode(n4,2, n5);
        Node n3 = t.makeNode(null,3,null);
        Node n1 = t.makeNode(n2,1, n3);

        t.setRoot(n1);
        System.out.println("-----------------------");
        System.out.println("inOrder");
        t.inOrder(t.getRoot());
        System.out.println("-----------------------");
        System.out.println("preOrder");
        t.preOrder(t.getRoot());
        System.out.println("-----------------------");
        System.out.println("postOrder");
        t.postOrder(t.getRoot());

        Node n = t.search(2, t.getRoot());
        System.out.println("탐색결과 : " + (n == null ? "못찾음.." : n.data));
    }
}
