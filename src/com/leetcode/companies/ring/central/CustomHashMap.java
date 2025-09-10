package com.leetcode.companies.ring.central;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   10-09-2025
    Time:   03:53 pm
*/
/*
We’ll implement:
✅ Hashing (using hashCode() of the key)
✅ Collision handling (via separate chaining using LinkedList)
✅ Put, Get, Remove, and Size operations
✅ Dynamic resizing (rehashing) when load factor exceeds threshold
 */
/*
⚡ Key Features
Generic ✅ (K for key, V for value)
Handles Collisions ✅ (via LinkedList)
Supports null keys ✅ (like Java’s HashMap)
Dynamic Resizing ✅ (rehashing at 0.75 load factor)
Basic Operations ✅ (put, get, remove, size)
 */

import java.util.LinkedList;

public class CustomHashMap<K, V> {
    // Entry node class
    private static class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Each bucket is a LinkedList of entries
    private LinkedList<Entry<K, V>>[] buckets;
    private int                       size = 0;

    // Default capacity and load factor
    private static final int   INITIAL_CAPACITY = 16;
    private static final float LOAD_FACTOR      = 0.75f;

    public CustomHashMap() {
        buckets = new LinkedList[INITIAL_CAPACITY];
    }

    // Hash function -> ensures index is within array bounds
    private int getBucketIndex(K key) {
        return key == null ? 0 : Math.abs(key.hashCode() % buckets.length);
    }

    public int size() {
        return size;
    }

    // Rehash -> double capacity
    public void reHash() {
        LinkedList<Entry<K, V>>[] oldBuckets = buckets;
        buckets = new LinkedList[oldBuckets.length * 2];
        size = 0;
        for (LinkedList<Entry<K, V>> bucket : oldBuckets) {
            if (bucket != null) {
                for (Entry<K, V> entry : bucket) {
                    put(entry.key, entry.value);
                }
            }
        }
    }

    public void put(K key, V value) {
        int index = getBucketIndex(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<Entry<K, V>>();
        }
        // Check if key exists -> update value
        for (Entry<K, V> entry : buckets[index]) {
            if ((key == null && entry.key == null) || (key != null && key.equals(entry.key))) {
                entry.value = value;
                return;
            }
        }
        // Insert new entry
        buckets[index].add(new Entry<>(key, value));
        size++;

        // Rehash if load factor exceeded
        if ((float) size / buckets.length > LOAD_FACTOR) {
            reHash();
        }
    }

    public V get(K key) {
        int index = getBucketIndex(key);
        if (buckets[index] == null) {
            return null;
        }
        for (Entry<K, V> entry : buckets[index]) {
            if (key.equals(entry.key)) {
                return entry.value;
            }
        }
        return null;
    }

    public V remove(K key) {
        int index = getBucketIndex(key);
        if (buckets[index] == null) {
            return null;
        }
        for (Entry<K, V> entry : buckets[index]) {
            if (key.equals(entry.key)) {
                V oldValue = entry.value;
                buckets[index].remove(entry);
                size--;
                return oldValue;
            }
        }
        return null;
    }

    public void printMap() {
        for (int i = 0; i < buckets.length; i++) {
            System.out.println("Bucket: " + i + ": ");
            if (buckets[i] != null) {
                for (Entry<K, V> entry : buckets[i]) {
                    System.out.println("[" + entry.key + "=" + entry.value + "] ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();

        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Orange", 30);
        map.put("Mango", 40);

        System.out.println("Get Apple: " + map.get("Apple")); // 10
        System.out.println("Get Mango: " + map.get("Mango")); // 40

        map.remove("Banana");
        System.out.println("Get Banana: " + map.get("Banana")); // null

        System.out.println("Size: " + map.size()); // 3

        map.printMap();
    }

}
