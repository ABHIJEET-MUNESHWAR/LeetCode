package com.leetcode.hard.stack;


import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   02-08-2026
    Time:   08:45 pm
    https://leetcode.com/problems/max-stack/description/
*/
class Node {
    int  val;
    Node next, prev;

    public Node() {
        //
    }

    public Node(int val) {
        this.val = val;
    }
}

class DoublyLinkedList {
    Node head = new Node();
    Node tail = new Node();

    public DoublyLinkedList() {
        head.next = tail;
        tail.prev = head;
    }

    public Node append(int val) {
        Node node = new Node(val);
        node.next = tail;
        node.prev = tail.prev;
        tail.prev = node;
        node.prev.next = node;
        return node;
    }

    public Node remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        return node;
    }

    public int peek() {
        return tail.prev.val;
    }

    public Node pop() {
        return remove(tail.prev);
    }
}

public class MaxStack {
    private DoublyLinkedList             doublyLinkedList;
    private TreeMap<Integer, List<Node>> nodeValToNodesTreeMap;

    public MaxStack() {
        doublyLinkedList = new DoublyLinkedList();
        nodeValToNodesTreeMap = new TreeMap<>();
    }

    public void push(int val) {
        Node node = doublyLinkedList.append(val);
        nodeValToNodesTreeMap.computeIfAbsent(val, key -> new ArrayList<>()).add(node);
    }

    public int pop() {
        Node       node      = doublyLinkedList.pop();
        List<Node> nodesList = nodeValToNodesTreeMap.get(node.val);
        int        val       = nodesList.remove(nodesList.size() - 1).val;
        if (nodesList.isEmpty()) {
            nodeValToNodesTreeMap.remove(node.val);
        }
        return val;
    }

    public int top() {
        return doublyLinkedList.peek();
    }

    public int peekMax() {
        return nodeValToNodesTreeMap.lastKey();
    }

    public int popMax() {
        int        maxVal    = nodeValToNodesTreeMap.lastKey();
        List<Node> nodesList = nodeValToNodesTreeMap.get(maxVal);
        Node       node      = nodesList.remove(nodesList.size() - 1);
        if (nodesList.isEmpty()) {
            nodeValToNodesTreeMap.remove(maxVal);
        }
        doublyLinkedList.remove(node);
        return maxVal;
    }
}
