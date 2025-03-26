package com.leetcode.companies.meta.screening;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   25-03-2025
    Time:   05:54 pm
    Find the least common ancestor given 2 nodes
*/

public class FindLCA {
    class Node {
        char value;
        Node left;
        Node right;
        Node parent;

        public Node(char value) {
            this.value = value;
        }
    }

    public Node findLCA(Node p, Node q) {
        int len1 = findLenToRoot(p);
        int len2 = findLenToRoot(q);
        if (len1 > len2) {
            int diff = len1 - len2;
            while (diff-- > 0) {
                p = p.parent;
            }
        } else {
            int diff = len2 - len1;
            while (diff-- > 0) {
                q = q.parent;
            }
        }
        while (p != null && q != null && p != q) {
            p = p.parent;
            q = q.parent;
        }
        return p;
    }

    private int findLenToRoot(Node p) {
        int len = 0;
        while (p.parent != null) {
            p = p.parent;
            len++;
        }
        return len;
    }
}
