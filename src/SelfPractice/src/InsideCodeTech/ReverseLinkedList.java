package InsideCodeTech;

import java.util.Stack;

class LinkedList {
    int data;
    LinkedList next;

    public LinkedList(int data) {
        this.data = data;
        this.next = null;
    }

}

public class ReverseLinkedList {

    public static void main(String[] args) {
        LinkedList head = new LinkedList(5);
        head.next = new LinkedList(3);
        head.next.next = new LinkedList(6);
        head.next.next.next = new LinkedList(4);
        head.next.next.next.next = new LinkedList(7);

        printLL(head);
        System.out.println("\n");
        reverse3(head);
    }

    // TC: n
    // SC: n
    static void reverse(LinkedList head) {
        Stack<LinkedList> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        head = stack.pop();
        LinkedList newHead = head;
        while (!stack.isEmpty()) {
            head.next = stack.pop();
            head = head.next;
        }
        head.next = null;
        printLL(newHead);
    }

    static void printLL(LinkedList ll) {
        while (ll != null) {
            System.out.print(ll.data + " ");
            ll = ll.next;

        }
    }

    // using value swaping
    // TC: n2
    // SC: 1
    static void reverse1(LinkedList ll) {
        int len = 0;
        LinkedList temp = ll;
        // get len of ll
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        temp = ll;
        for (int i = 0; i < len / 2; i++) {
            LinkedList right = ll;
            for (int j = 0; j < len - i - 1; j++)
                right = right.next;
            // swap node values
            int t = temp.data;
            temp.data = right.data;
            right.data = t;
            temp = temp.next;
        }
        printLL(ll);
    }

    // using link swapping -> iterative
    // SC: n
    // SC: 1
    static void reverse2(LinkedList ll) {
        LinkedList pre = null;
        LinkedList curr = ll;
        LinkedList next;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        printLL(pre);
    }

    static void reverse3(LinkedList ll) {
        LinkedList reversed = helper(ll);
        printLL(reversed);
    }

    // swapping links -> recursive
    // TC: n
    // SC: n -> call stack
    private static LinkedList helper(LinkedList node) {
        if (node == null || node.next == null)
            return node;
        LinkedList rev = helper(node.next);
        node.next.next = node;
        node.next = null;
        return rev;
    }
}



