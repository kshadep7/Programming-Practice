import java.util.ArrayList;
import java.util.List;

public class RectanglesFitting {

    public static void main(String[] args) {

        int[][] operations = {{0, 1, 3}, {0, 4, 2}, {1, 3, 4}, {1, 3, 2}};
        int[][] operations1 = {{1, 1, 1}};
        System.out.println(canFitRectangles(operations1));
    }
    /*
    You are given an array consisting of 2 types of operations.
[0,a,b] - Create and save a rectangle of size axb
[1,a,b] - check whether every PREVIOUS saved rectangle can be fit inside this rectangle of axb.
You can rotate rectangles by 90 degrees. We try to fit each rectangle ONE AT A TIME and not TOGETHER.
Return an array of booleans representing answers to second operation in the order in which they appear.
ex.
operations = [[0,1,3], [0,4,2], [1,3,4], [1,3,2]]
output = [true,false]
[1,3] and [4,2](rotated) can fit inside [3,4] so true
[1,3] can fit but [4,2] cannot fit inside [3,2] so false.
     */
// operations = [[0,1,3], [0,4,2], [1,3,4], [1,3,2]]

    static List<Boolean> canFitRectangles(int[][] operations) {
        if (operations == null || operations.length == 0)
            return new ArrayList<>();

        //save all the rectacles and containers in a diff lists
        List<int[]> saved = new ArrayList<>();
        List<int[]> containers = new ArrayList<>();
        for (int[] opr : operations) {
            if (opr[0] == 0)
                saved.add(opr);
            else
                containers.add(opr);
        }

        List<Boolean> res = new ArrayList<>();
        // base case where no saved rectangles present
        if (saved.size() == 0) {
            res.add(true);
            return res;
        }

        a:
        for (int[] arr : containers) {
            int X = arr[1];
            int Y = arr[2];
            b:
            for (int[] save : saved) {
                int x = save[1];
                int y = save[2];
                if (!(x <= X && y <= Y || y <= X && x <= Y)) {
                    res.add(false);
                    continue a;
                }
            }
            res.add(true);
        }
        return res;
    }
}
