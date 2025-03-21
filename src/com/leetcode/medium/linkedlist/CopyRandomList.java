package com.leetcode.medium.linkedlist;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    21/05/24,
 * Time:    8:54 am
 * 138. Copy List with Random Pointer
 * https://leetcode.com/problems/copy-list-with-random-pointer/description/
 */
class Node {
  int val;
  Node next;
  Node random;

  public Node(int val) {
    this.val = val;
    this.next = null;
    this.random = null;
  }
}

public class CopyRandomList {
  public static void main(String[] args) {
    CopyRandomList copyRandomList = new CopyRandomList();
    Node head = new Node(7);
    head.next = new Node(13);
    head.next.next = new Node(11);
    head.next.next.next = new Node(10);
    head.next.next.next.next = new Node(1);
    head.random = null;
    head.next.random = head.next;
    head.next.next.random = head.next.next.next.next;
    head.next.next.next.random = head.next.next;
    head.next.next.next.next.random = head;
    Node deepCopyHead = copyRandomList.copyRandomList(head);
  }

  private Node copyRandomList(Node head) {
    if (head == null) {
      return null;
    }
    Node current = head;
    Node nextNode = null;
    while (current != null) {
      nextNode = current.next;
      Node copyNode = new Node(current.val);
      current.next = copyNode;
      copyNode.next = nextNode;
      current = nextNode;
    }
    current = head;
    while (current != null) {
      if (current.random != null) {
        current.next.random = current.random.next;
      }
      current = current.next.next;
    }
    current = head;
    Node dummyHead = new Node(0);
    Node copy = null;
    Node copyIterator = dummyHead;
    while (current != null) {
      Node next = current.next.next;

      // Extract the copy
      copy = current.next;
      copyIterator.next = copy;
      copyIterator = copy;

      // Restore original list
      current.next = next;
      current = next;
    }
    return dummyHead.next;
  }
}