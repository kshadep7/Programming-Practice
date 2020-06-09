package LinkedLists;

import java.util.Stack;

public class Palindrome {

    public static void main(String[] args) {

    }

    public static boolean isLLPalindrome(Node ll) {
        // using two pointers fast and slow runner (if len is not known) use this
        // anyway!!
        // fast runs 2x faster than slow so when fast reaches end slow will be in mid
        // while this happens -> push elements in stack
        // check for odd if odd then push slow one node ahead
        // check slow node with popped element till end
        // return false if any one node is ≠ popped node
        //TC -> O(n) and SC -> O(n)

        Node fast = ll;
        Node slow = ll;

        Stack<Integer> stack = new Stack<>();

        // pushing data into stack
        while (fast != null && fast.next != null) {
            stack.push(slow.intData);
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null)
            slow = slow.next;

        while (slow != null) {
            int top = stack.pop().intValue();
            if (slow.intData != top)
                return false;

            slow = slow.next;
        }
        return true;
    }

}
