package com.baek.algorithm.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    class Node {
        int data;
        LinkedList<Node> adjacent;
        Boolean marked;

        public Node(int data) {
            this.data = data;
            this.adjacent = new LinkedList<Node>();
            this.marked = false;
        }
    }

    Node[] nodes;

    Graph(int size) {
        nodes = new Node[size];
        for (int i = 0; i < size ; i++) {
            nodes[i] = new Node(i);
        }
    }

    void clear() {
        for (Node n: nodes) {
            n.marked = false;
        }
    }

    void addEdge(int i1, int i2) {
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];
        if (!n1.adjacent.contains(n2)) {
            n1.adjacent.add(n2);
        }
        if (!n2.adjacent.contains(n1)) {
            n2.adjacent.add(n1);
        }
    }

    void dfs() {
        dfs(0);
    }

    void dfs(int index) {
        Node root = nodes[index];
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        root.marked = true;

        while (!stack.isEmpty()) {
            Node r = stack.pop();
            for (Node n: r.adjacent) {
                if (n.marked == false) {
                    n.marked = true;
                    stack.push(n);

                }
            }
            visit(r);
        }
    }

    void bfs(int index) {
        Node root = nodes[index];
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(root);
        root.marked = true;

        while (!queue.isEmpty()) {
            Node r = queue.pollFirst();
            for (Node n: r.adjacent) {
                if (n.marked == false) {
                    n.marked = true;
                    queue.add(n);
                }
            }
            visit(r);
        }
    }

    void dfsR(Node r) {
        if(r == null)
            return;

        r.marked = true;
        visit(r);
        for (Node n: r.adjacent) {
            if (n.marked == false) {
                n.marked = true;
                dfsR(n);
            }
        }
    }

    void dfsR(int index) {
        Node n = nodes[index];
        dfsR(n);
    }

    void visit(Node node) {
        System.out.println(node.data + " visit!!");
    }

    public static void main(String[] args) {
        Graph g = new Graph(9);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(5, 6);
        g.addEdge(5, 7);
        g.addEdge(6, 8);

        System.out.println("-------------------------------");
        g.clear();
        g.dfsR(0);

        System.out.println("-------------------------------");
        g.clear();
        g.dfs(0);

        System.out.println("-------------------------------");
        g.clear();
        g.bfs(0);
    }
}
