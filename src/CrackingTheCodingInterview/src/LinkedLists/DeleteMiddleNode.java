package LinkedLists;

public class DeleteMiddleNode {

    public static void main(String[] args) {

    }

    public void delMiddleNode(Node head, Node mid) {
        // null check middle isn't null and neither first nor last node
        // copy the middle.next.data into middle.data
        // change the middle.next pointer to middle.next.next

        if (mid == null || mid.next == null) {
            System.out.println("node is first or last or null");
        } else {
            mid.data = mid.next.data;
            mid.next = mid.next.next;
        }
        printLL(head);

    }

    public static void printLL(Node head) {
        while (head != null) {
            System.out.print(head.intData + " --> ");
            head = head.next;
        }
        System.out.print("null\n");
    }


}
