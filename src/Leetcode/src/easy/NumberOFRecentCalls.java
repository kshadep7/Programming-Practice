package easy;

import java.util.LinkedList;

class RecentCalls {
    LinkedList<Integer> list;

    public RecentCalls() {
        this.list = new LinkedList<>();
    }

    public int ping(int t) {
        list.addLast(t);
        while (list.getFirst() < (t - 3000))
            list.removeFirst();
        return list.size();
    }
}

public class NumberOFRecentCalls {

    public static void main(String[] args) {
        RecentCalls rc = new RecentCalls();
        System.out.println(rc.ping(1));
        System.out.println(rc.ping(100));
        System.out.println(rc.ping(3001));
        System.out.println(rc.ping(3002));
    }


}
