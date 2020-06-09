package medium;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val, Node next, Node random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }
}

public class CopyListRandomPointer {

    static Map<Node, Node> visited = new HashMap<>();

    public static void main(String[] args) {

    }

    // the idea is to keep record of node is visited or not to avoid cycles due to randomness pointer
    // recursive approach
    static Node copyList(Node head) {

        // check head for null as base case
        if (head == null)
            return null;

        // for is the node is visited or not
        if (visited.containsKey(head))
            return visited.get(head);
        // creating a cloned node
        Node node = new Node(head.val, null, null);

        // putting this node in map as value of key -> head
        visited.put(head, node);

        // calling recursively for next and then random pointer
        node.next = copyList(head.next);
        node.random = copyList(head.random);

        return node;

    }

    // iterative approach
    // same as recursive just using loop
    // TC : O(N) SC : O(N)
    static Node copyListIter(Node head) {

        if (head == null)
            return null;

        Node oldNode = head;
        Node clonedNode = new Node(oldNode.val, null, null);
        visited.put(oldNode, clonedNode);

        while (oldNode != null) {
            clonedNode.random = getNode(oldNode.random);
            clonedNode.next = getNode(oldNode.next);

            //updating oldNode in loop
            oldNode = oldNode.next;
            clonedNode = clonedNode.next;
        }
        return visited.get(head);

    }

    private static Node getNode(Node node) {
        if (node != null) {
            if (visited.containsKey(node))
                return visited.get(node);
            else {
                visited.put(node, new Node(node.val, null, null));
                return visited.get(node);
            }
        }
        return null;
    }

    // without using visited hash map
    // TC : O(N) and SC : O(1)

    static Node copyListWithoutExtraSpace(Node head) {

        Node curr = head; // A
        Node temp = null;
        // inserting new cloned nodes after the original nodes
        while (curr != null) {
            temp = curr.next; // putting B in temp first
            // A -> A' -> B -> B' -> C -> C'
            //
            curr.next = new Node(curr.val, null, null); // adding new node after A
            curr.next.next = temp; // adding B after A'
            curr = temp; // making B as curr and repeating the process
        }
        curr = head;

        // assigning the random nodes for cloned nodes
        while (curr != null) {
            if (curr.next != null)
                curr.next.random = curr.random != null ? curr.random.next : curr.random;
            curr = curr.next != null ? curr.next.next : curr.next;

        }
        //  separating original and cloned nodes
        // no extra space because we are just assigning some pointers to cloned nodes.
        Node original = head;
        Node cloned = head.next;

        Node ans = cloned;

        while (original != null && cloned != null) {

            original.next = original.next != null ? original.next.next : original.next;
            cloned.next = cloned.next != null ? cloned.next.next : cloned.next;

            original = original.next;
            cloned = cloned.next;
        }
        return ans;
    }
}
