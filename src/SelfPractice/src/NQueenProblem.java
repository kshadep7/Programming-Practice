import java.util.LinkedList;
import java.util.Queue;

public class NQueenProblem {


    public static void main(String[] args) {

    }

    // TODO : Solve it later.
    //iterative approach -> BGS
    static int noOfWays(int gridLen, int queens) {
        int res = 0;
        Queue<String> que = new LinkedList<>();
        que.offer("00");
        for (int i = 0; i < gridLen; i++) {
            while (!que.isEmpty()) {
//                if (que.size())
            }
        }
        return res;
    }


}
