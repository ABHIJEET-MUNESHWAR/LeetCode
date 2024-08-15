package com.leetcode.medium.design;

import java.util.HashMap;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    09/07/24,
 * Time:    11:53 pm
 * 146. LRU Cache
 * https://leetcode.com/problems/lru-cache/description/
 */
class Node {
    int key;
    int value;
    Node next;
    Node prev;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

class LRUCache {

    int capacity;
    HashMap<Integer, Node> map;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public void addNode(Node newNode) {
        Node temp = head.next;
        head.next = newNode;
        newNode.prev = head;
        newNode.next = temp;
        temp.prev = newNode;
    }

    public void deleteNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        deleteNode(node);
        addNode(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            deleteNode(node);
            node.value = value;
            addNode(node);
        } else {
            Node newNode = new Node(key, value);
            if (map.size() == capacity) {
                Node prev = tail.prev;
                deleteNode(prev);
                addNode(newNode);
                map.remove(prev.key);
                map.put(key, newNode);
            } else {
                addNode(newNode);
                map.put(key, newNode);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */