package InsideCodeTech;

public class SortLinkedlist {

    public static void main(String[] args) {

        LinkedList ll = new LinkedList(4);
        ll.next = new LinkedList(8);
        ll.next.next = new LinkedList(1);
        ll.next.next.next = new LinkedList(6);
        ll.next.next.next.next = new LinkedList(2);
        ll.next.next.next.next.next = new LinkedList(5);

        printLL(ll);
//        sort(ll);
        System.out.println("\n");
        printLL(sort1(ll));
    }

    // bubble sort
    // n2
    static void sort(LinkedList ll) {
        LinkedList i = ll;
        while (i != null) {                 //n
            LinkedList j = ll;
            while (j.next != null) {        //n
                if (j.data > j.next.data) {
                    //swap values
                    int temp = j.data;
                    j.data = j.next.data;
                    j.next.data = temp;
                }
                j = j.next;
            }
            i = i.next;
        }
        System.out.println("\n");
        printLL(ll);
    }

    static void printLL(LinkedList ll) {
        while (ll != null) {
            System.out.print(ll.data + " ");
            ll = ll.next;

        }
    }

    // using merge sort algo
    //TC: nlogn
    //SC: call stack -> divinding/2 until we get individual node
    static LinkedList sort1(LinkedList ll) {
        //base case
        if (ll == null || ll.next == null)
            return ll;
        // get mid using slow and fast pointer
        LinkedList slow = ll;
        LinkedList fast = ll;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // save the next of slow as head of right side list
        // and make next of slow as null to seprate
        LinkedList headRight = slow.next;
        slow.next = null;

        // recurse on the left list to repeat the divide the left list
        ll = sort1(ll);
        // recurse on the right list to repeat the divide the right list
        headRight = sort1(headRight);
        return mergeLists(ll, headRight);
    }

    private static LinkedList mergeLists(LinkedList ll, LinkedList headRight) {
        LinkedList resHead = null;
        LinkedList ptr1 = ll;
        LinkedList ptr2 = headRight;
        LinkedList lower = null;
        LinkedList tail = null;
        //check if one of the node is not null
        while (ptr1 != null || ptr2 != null) {
            // check if both are present
            if (ptr1 != null && ptr2 != null) {
                if (ptr1.data < ptr2.data) {
                    lower = ptr1;
                    ptr1 = ptr1.next;
                } else {
                    lower = ptr2;
                    ptr2 = ptr2.next;
                }
            } else if (ptr1 != null) {  //check if ptr2 is over
                lower = ptr1;
                ptr1 = ptr1.next;
            } else {            // ptr1 is over
                // ptr2 != null
                lower = ptr2;
                ptr2 = ptr2.next;
            }
            // once we know which is our first ever lower node
            // assign it to resHead and tail
            if (resHead == null) {
                resHead = lower;
                tail = lower;
            } else {            // this means we found our res list head
                // and connect previous lower with new lower
                tail.next = lower;
                tail = tail.next;
            }
        }
        return resHead;
    }

}
