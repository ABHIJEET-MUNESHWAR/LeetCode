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
    Node head;
    Node tail;
    Map<Integer, Node> numToNodeMap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        numToNodeMap = new HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public void addNode(Node node) {
        Node nextNode = head.next;
        node.next = nextNode;
        node.prev = head;
        head.next = node;
        nextNode.prev = node;
    }

    public void deleteNode(Node node) {
        Node nextNode = node.next;
        Node prevNode = node.prev;
        nextNode.prev = prevNode;
        prevNode.next = nextNode;
    }

    public int get(int key) {
        if (!numToNodeMap.containsKey(key)) {
            return -1;
        }
        Node node = numToNodeMap.get(key);
        deleteNode(node);
        addNode(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (numToNodeMap.containsKey(key)) {
            Node node = numToNodeMap.get(key);
            deleteNode(node);
            node.value = value;
            addNode(node);
        } else {
            if (numToNodeMap.size() == capacity) {
                Node nodeToDelete = tail.prev;
                numToNodeMap.remove(nodeToDelete.key);
                deleteNode(nodeToDelete);
            }
            Node node = new Node(key, value);
            addNode(node);
            numToNodeMap.put(key, node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */