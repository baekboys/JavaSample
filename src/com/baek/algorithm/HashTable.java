package com.baek.algorithm;

import java.util.LinkedList;

public class HashTable {
    class Node {
        String key;
        String value;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    LinkedList<Node>[] data;

    public HashTable(int size) {
        this.data = new LinkedList[size];
    }

    private int getHashCode(String key) {
        int hashCode = 0;
        for ( char c: key.toCharArray()) {
            hashCode += c;
        }
        return hashCode;
    }

    private int convertToIndex(int hashCode) {
        return hashCode % data.length;
    }

    private Node searchKey(LinkedList<Node> list, String key) {
        if (list == null)
            return null;

        for (Node node: list) {
            if (node.key.equals(key)) {
                return node;
            }
        }
        return null;
    }

    public void put(String key, String value) {
        int hashCode = getHashCode(key);
        int index = convertToIndex(hashCode);
        LinkedList<Node> list = data[index];
        if (list == null) {
            list = new LinkedList<Node>();
            data[index] = list;
        }
        Node node = searchKey(list, key);
        if (node == null) {
            list.add(new Node(key, value));
        } else {
            node.setValue(value);
        }
    }

    public String get(String key) {
        int hashCode = getHashCode(key);
        int index = convertToIndex(hashCode);
        LinkedList<Node> list = data[index];
        Node node = searchKey(list, key);
        return node == null ? "" : node.getValue();
    }

    public static void main(String[] args) {
        HashTable h = new HashTable(3);

        h.put("백", "명선");
        h.put("권", "은혜");
        h.put("하", "하연");

        System.out.println(h.get("백"));
        System.out.println(h.get("권"));
        System.out.println(h.get("하"));

        h.put("하", "찡찡이");
        System.out.println(h.get("하"));
    }
}
