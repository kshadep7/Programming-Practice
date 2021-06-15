package easy;

// must be medium problem

public class PalindromeLinkedList {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next.next = new ListNode(1);

        System.out.println(checkIfPalindrome(head));
    }

    static boolean checkIfPalindrome(ListNode head) {
        if (head == null)
            return false;

        // get mid of LL
        ListNode firstHalfEnd = getMid(head);
        // reverse second half of the LL
        ListNode secondHalfStart = reverse(firstHalfEnd.next);

        // check for node val equality
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val)
                result = false;
            p1 = p1.next;
            p2 = p2.next;
        }

        // putting the reverse second half list back together
        firstHalfEnd.next = reverse(secondHalfStart);
        return result;
    }

    private static ListNode reverse(ListNode ll) {
        ListNode pre = null;
        ListNode curr = ll;
        ListNode next;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    private static ListNode getMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
