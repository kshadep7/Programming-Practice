package LinkedLists;

import java.util.LinkedList;

class Node {
    Node next;
    String data;
    int intData;

    Node(String s, int i) {
        data = s;
        intData = i;
        next = null;
    }
}

public class RemoveKthToLast {

    public static void main(String[] args) {

    }


    public int kthToLast(Node head, int k) {
        // Using Node class
        // Using Recursion:
        // The call stack will fill space with n recursive
        // calls(n -> elements in the LL)
        // TC and SC -> O(n)
        if (head == null)
            return 0;

        int index = kthToLast(head.next, k) + 1;
        if (index == k)
            System.out.println(head.data);

        return index;

        // =================================================
        // Using Iterative:
        // Have two pointers as head p1 and p2
        // iterate p1 till kth position
        // iterate p1 and p2 simultaneously and return p2 as p1 hits end i.e null
        // TC -> O(n) and SC -> O(1)
    }

    public void kthToLast(LinkedList<String> list, int k) {
        // knowing the size of the list will help in finding the kth to last element
        // just compare index with (size - k)
        // TC -> O(n) SC-> O(1)
        for (int i = list.size() - 1; i > 0; i--) {
            if (i == list.size() - k) {
                System.out.println(list.get(i));
                break;
            }
        }
    }

}
