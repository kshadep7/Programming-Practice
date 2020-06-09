package LinkedLists;

public class Partition {

    public static void main(String[] args) {

    }

    public static void partition(Node head, int par) {
        // null check on head
        // Maintain two separate LL nodes start and end to save < and > values
        // merge the two LL nodes

        // My Solution: ------------------------->
        // Node start = new Node("", 0), end = new Node("", 0);
        // while (head != null) {
        // if (head.intData < par) {
        // start.intData = head.intData;
        // start = start.next; ---> //here the start was getting null and I thought
        // memory
        // //was allocated to the linked list (which is wrng)
        // } else {
        // end.intData = head.intData;
        // end = end.next;
        // }
        // head = head.next;
        // }
        // start.next = end;
        // end.next = null;
        //
        // printLL(start);
        // -------------------------------------->
        Node start = head;
        Node end = head;
        while (head != null) {
            Node next = head.next;
            if (head.intData < par) {
                /* Insert node at start. */
                head.next = start;
                start = head;
            } else {
                /* Insert node at end. */
                end.next = head;
                end = head;
            }
            head = next;
        }
        end.next = null;
        // The head has changed, so we need to return it to the user.
        printLL(start);
        printLL(end);
    }

    public static void printLL(Node head) {
        while (head != null) {
            System.out.print(head.intData + " --> ");
            head = head.next;
        }
        System.out.print("null\n");
    }

}
