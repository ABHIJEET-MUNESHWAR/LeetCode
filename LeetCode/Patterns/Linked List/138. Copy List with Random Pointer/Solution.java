/*
// Definition for a Node.
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
*/

class Solution {
    public Node copyRandomList(Node head) {
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