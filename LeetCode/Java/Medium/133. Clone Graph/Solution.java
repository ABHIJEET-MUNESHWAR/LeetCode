/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        Map<Node, Node> nodeToClonedNodeMap = new HashMap<>();
        Node clonedNode = new Node(node.val);
        nodeToClonedNodeMap.put(node, clonedNode);
        dfsCloneGraph(node, clonedNode, nodeToClonedNodeMap);
        return clonedNode;
    }

    public void dfsCloneGraph(Node node, Node clonedNode, Map<Node, Node> nodeToClonedNodeMap) {
        for (Node neighbour : node.neighbors) {
            Node clonedNeighbourNode = new Node(neighbour.val);
            if (!nodeToClonedNodeMap.containsKey(neighbour)) {
                nodeToClonedNodeMap.put(neighbour, clonedNeighbourNode);
                clonedNode.neighbors.add(clonedNeighbourNode);
                dfsCloneGraph(neighbour, clonedNeighbourNode, nodeToClonedNodeMap);
            } else {
                clonedNode.neighbors.add(nodeToClonedNodeMap.get(neighbour));
            }
        }
    }
}