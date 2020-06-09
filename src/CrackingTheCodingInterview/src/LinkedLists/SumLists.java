package LinkedLists;

public class SumLists {
    static class PartialSum {
        public Node sum = null;
        public int carry = 0;
    }

    public static void main(String[] args) {


    }

    public static void addLLs(Node num1, Node num2) {

        // while num1 and num2 are not null
        // add the inDatas of num1 n num2 store in sum and store the carry as well
        // add the units digit to temp and and join to res if null else prev.next
        // store temp in prev (making current prev for next iteration)
        // increment num1 and num2
        // check for additional carry value.

        Node res = null;
        Node temp = null;
        Node prev = null;
        int carry = 0, sum;

        while (num1 != null || num2 != null) {

            sum = carry + (num1 != null ? num1.intData : 0) + (num2 != null ? num2.intData : 0);
            carry = sum < 10 ? 0 : 1;
            sum %= 10;
            temp = new Node("", sum);

            if (res == null) {
                res = temp;
            } else {
                prev.next = temp;
            }
            prev = temp;

            if (num1 != null)
                num1 = num1.next;
            if (num2 != null)
                num2 = num2.next;
        }

        if (carry > 0)
            temp.next = new Node("", carry);

        printLL(res);

    }

    public static void printLL(Node head) {
        while (head != null) {
            System.out.print(head.intData + " --> ");
            head = head.next;
        }
        System.out.print("null\n");
    }

    static Node addLists(Node l1, Node l2) {
        int len1 = llLength(l1);
        int len2 = llLength(l2);

        /* Pad the shorter list with zeros - see note (1) */
        if (len1 < len2) {
            l1 = padList(l1, len2 - len1);
        } else {
            l2 = padList(l2, len1 - len2);
        }

        /* Add lists */
        PartialSum sum = addListsHelper(l1, l2);

        /*
         * If there was a carry value left over, insert this at the front of the list.
         * Otherwise, just return the linked list.
         */
        if (sum.carry == 0) {
            return sum.sum;
        } else {
            Node result = insertBefore(sum.sum, sum.carry);
            return result;
        }
    }

    public static int llLength(Node l) {
        int count = 0;
        while (l != null) {
            count++;
            l = l.next;
        }
        return count;
    }

    static PartialSum addListsHelper(Node l1, Node l2) {
        if (l1 == null && l2 == null) {
            PartialSum sum = new PartialSum();
            return sum;
        }
        /* Add smaller digits recursively */
        PartialSum sum = addListsHelper(l1.next, l2.next);

        /* Add carry to current data */
        int val = sum.carry + l1.intData + l2.intData;

        /* Insert sum of current digits */
        Node full_result = insertBefore(sum.sum, val % 10);

        /* Return sum so far, and the carry value */
        sum.sum = full_result;
        sum.carry = val / 10;
        return sum;
    }

    /* Pad the list with zeros */
    static Node padList(Node l, int padding) {
        Node head = l;
        for (int i = 0; i < padding; i++) {
            head = insertBefore(head, 0);
        }
        return head;
    }

    /* Helper function to insert node in the front of a linked list */
    static Node insertBefore(Node list, int data) {
        Node node = new Node("", data);
        if (list != null) {
            node.next = list;
        }
        return node;
    }


}
