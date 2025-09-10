package com.leetcode.companies.ring.central;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   10-09-2025
    Time:   03:21 pm
    Design custom HashMap
*/

import java.util.LinkedList;
import java.util.List;

public class MyHashMap {
    class Pair {
        int key;
        int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private List<Pair>[] buckets;
    private int          size = 10000;

    public MyHashMap() {
        buckets = new List[size];
        for (int i = 0; i < size; i++) {
            buckets[i] = new LinkedList<Pair>();
        }
    }

    public void put(int key, int value) {
        int        bucketNo = key % size;
        List<Pair> pairs    = buckets[bucketNo];
        for (Pair pair : pairs) {
            if (pair.key == key) {
                pair.value = value;
                return;
            }
        }
        pairs.add(new Pair(key, value));
    }

    public int get(int key) {
        int        bucketNo = key % size;
        List<Pair> pairs    = buckets[bucketNo];
        for (Pair pair : pairs) {
            if (pair.key == key) {
                return pair.value;
            }
        }
        return -1;
    }

    public void remove(int key) {
        int        bucketNo = key % size;
        List<Pair> pairs    = buckets[bucketNo];
        for (Pair pair : pairs) {
            if (pair.key == key) {
                pairs.remove(pair);
                return;
            }
        }
    }
}
