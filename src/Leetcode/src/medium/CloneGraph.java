package medium;

import java.util.*;

class GraphNode {
    int val;
    List<GraphNode> neighbors;

    public GraphNode(int val, List<GraphNode> list) {
        this.val = val;
        this.neighbors = list;
    }

    public GraphNode(int val) {
        this.val = val;
        this.neighbors = new ArrayList<>();
    }
}

public class CloneGraph {
    static Map<GraphNode, GraphNode> visited = new HashMap<>();

    public static void main(String[] args) {
        GraphNode node1 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        GraphNode node4 = new GraphNode(4);
        List<GraphNode> list1 = new ArrayList<>(Arrays.asList(node2, node4));
        List<GraphNode> list2 = new ArrayList<>(Arrays.asList(node1, node3));
        List<GraphNode> list3 = new ArrayList<>(Arrays.asList(node2, node4));
        List<GraphNode> list4 = new ArrayList<>(Arrays.asList(node1, node3));

        node1.neighbors = list1;
        node2.neighbors = list2;
        node3.neighbors = list3;
        node4.neighbors = list4;

        List<List<GraphNode>> adjList = new ArrayList<>(Arrays.asList(list1, list2, list3, list4));

        System.out.println(adjList);
        System.out.println(cloned(node1));

    }

    // using dfs and Hash map approach
    static GraphNode cloned(GraphNode node) {
        // node null
        if (node == null)
            return null;

        // check is this node is present in hash map
        if (visited.containsKey(node))
            return visited.get(node);

        // creating new clone node for the curr node
        // with empty neighbors
        GraphNode cloneNode = new GraphNode(node.val, new ArrayList<>());

        // adding node and clone node to hash map
        visited.put(node, cloneNode);

        // traversing the neighbors of curr node and adding them to cloned node's list recursively
        for (GraphNode neighbors : node.neighbors) {
            cloneNode.neighbors.add(cloned(neighbors));
        }

        return cloneNode;
    }
}
