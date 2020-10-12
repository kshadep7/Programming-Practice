package InsideCodeTech;

public class PalindromeLinkedlist {

    public static void main(String[] args) {

        LinkedList ll = new LinkedList(1);
        ll.next = new LinkedList(4);
        ll.next.next = new LinkedList(6);
        ll.next.next.next = new LinkedList(5);
        ll.next.next.next.next = new LinkedList(6);
        ll.next.next.next.next.next = new LinkedList(4);
        ll.next.next.next.next.next.next = new LinkedList(1);

        printLL(ll);
//        System.out.println(isPalindrome(ll));
        System.out.println(isPalin(ll));
    }

    // n2
    static boolean isPalindrome(LinkedList ll) {
        int len = 0;
        LinkedList temp = ll;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        temp = ll;
        for (int i = 0; i < len / 2; i++) {     // n
            LinkedList right = ll;
            for (int j = 0; j < len - i - 1; j++)       // n
                right = right.next;
            if (temp.data != right.data)
                return false;
            temp = temp.next;
        }
        return true;
    }

    static void printLL(LinkedList ll) {
        while (ll != null) {
            System.out.print(ll.data + " ");
            ll = ll.next;

        }
    }

    // N
    static boolean isPalin(LinkedList ll) {
        LinkedList temp = ll;
        LinkedList slow = temp, fast = temp;
        // find mid of list using slow and fast pointer -> slow is mid
        while (fast != null && fast.next != null) { // n
            slow = slow.next;
            fast = fast.next.next;
        }
        // reverse list starting from slow
        slow = reverse(slow); // n
        // check from start of ll and mid i.e slow
        while (slow != null) {  // n
            if (ll.data != slow.data)
                return false;
            ll = ll.next;
            slow = slow.next;
        }
        return true;
    }

    private static LinkedList reverse(LinkedList slow) {
        LinkedList pre = null, curr = slow, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
