import easy.ListNode;

public class FindIntersectingNode {

    public static void main(String[] args) {
// A = 3 -> 8 -> 10 and B = 99 -> 1 -> 8 -> 10,
        ListNode headA = new ListNode(3);
        headA.next = new ListNode(8);
        headA.next.next = new ListNode(10);

        ListNode headB = new ListNode(99);
        headB.next = new ListNode(1);
        headB.next.next = new ListNode(8);
        headB.next.next.next = new ListNode(10);

        System.out.println(findNode(headA, headB).val);
    }

    // idea is to get len of both lists
    // find diff (d) and then put pointer of bigger list forward by d count
    // so that now both have same len to check for the result node
    static ListNode findNode(ListNode a, ListNode b) {
        if (a == null || b == null)
            return null;

        int lenA = getLen(a);
        int lenB = getLen(b);

        int diff = Math.abs(lenA - lenB);

        return lenA > lenB ? getInterNode(diff, a, b) : getInterNode(diff, b, a);
    }

    private static ListNode getInterNode(int diff, ListNode bigList, ListNode smallList) {
        int i = 0;
        while (i < diff) {
            bigList = bigList.next;
            i++;
        }
        while (bigList != null && smallList != null) {
            if (bigList.val == smallList.val)
                return bigList;

            bigList = bigList.next;
            smallList = smallList.next;
        }

        return null;
    }

    private static int getLen(ListNode node) {
        int i = 0;
        while (node != null) {
            i++;
            node = node.next;
        }
        return i;
    }
}
