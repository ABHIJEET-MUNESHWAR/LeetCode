package com.leetcode.companies.salesforce.lfu;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   26-05-2025
    Time:   08:42 pm
    🟠 Implement LFU Cache
    What is an LFU Cache?
        LFU stands for Least Frequently Used.
        It evicts the key with the lowest frequency of usage when the cache is full.
        If multiple keys have the same frequency, the least recently used among them is evicted.
*/

import java.util.*;

class LFUCache {
    private final int                               capacity;
    private       int                               minFreq;
    private final Map<Integer, Node>                keyToNodeMap;
    private final Map<Integer, LinkedHashSet<Node>> freqToNodesMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.keyToNodeMap = new HashMap<>();
        this.freqToNodesMap = new HashMap<>();
    }

    static class Node {
        int key, value, freq;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }

        @Override
        public String toString() {
            return String.format("{key=%d, val=%d, freq=%d}", key, value, freq);
        }
    }

    public int get(int key) {
        if (!keyToNodeMap.containsKey(key)) {
            return -1;
        }
        Node node = keyToNodeMap.get(key);
        updateFrequency(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        if (keyToNodeMap.containsKey(key)) {
            Node node = keyToNodeMap.get(key);
            node.value = value;
            updateFrequency(node);
        } else {
            if (keyToNodeMap.size() >= capacity) {
                evictLFUNode();
            }
            Node newNode = new Node(key, value);
            keyToNodeMap.put(key, newNode);
            freqToNodesMap.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(newNode);
            minFreq = 1;
        }
    }

    private void updateFrequency(Node node) {
        // Remove the node from its current frequency set
        LinkedHashSet<Node> nodes = freqToNodesMap.get(node.freq);
        nodes.remove(node);

        // If the current frequency set is empty and it was the minimum frequency, increment minFreq
        if (nodes.isEmpty() && node.freq == minFreq) {
            minFreq++;
        }

        // Increment the node's frequency
        node.freq++;

        // Add the node to the next frequency set
        freqToNodesMap.computeIfAbsent(node.freq, k -> new LinkedHashSet<>()).add(node);
    }

    private void evictLFUNode() {
        LinkedHashSet<Node> nodes = freqToNodesMap.get(minFreq);
        Node                evict = nodes.iterator().next(); // FIFO order
        nodes.remove(evict);
        if (nodes.isEmpty()) {
            freqToNodesMap.remove(minFreq);
        }
        keyToNodeMap.remove(evict.key);
    }
}

public class Lfu {
    public static void main(String[] args) {
        LFUCache lfu = new LFUCache(4);

        lfu.put(1, 10);
        lfu.put(2, 20);
        lfu.put(3, 30);
        lfu.put(4, 40);
        System.out.println(lfu.get(1));
        System.out.println(lfu.get(1));
        System.out.println(lfu.get(1));
        System.out.println(lfu.get(2));
        System.out.println(lfu.get(2));
        System.out.println(lfu.get(3));
        lfu.put(5, 50);
        lfu.put(6, 60);
        System.out.println(lfu.get(2));
        System.out.println(lfu.get(3));
        System.out.println(lfu.get(4));
        System.out.println(lfu.get(6));
        System.out.println(lfu.get(6));
        System.out.println(lfu.get(6));
        System.out.println(lfu.get(6));
    }
}
