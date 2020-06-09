package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalListIntersections {
    public static void main(String[] args) {

        int[][] a = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] b = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};
        System.out.println(Arrays.deepToString(inter(a, b)));
    }

    // not working
    static int[][] intersections(int[][] a, int[][] b) {
        List<int[]> out = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {

                if (b[i][0] >= a[i][0] && b[i][0] <= a[i][1] || b[i][1] >= a[i][0] && b[i][1] <= a[i][1]) {
                    int lo = Math.max(b[i][0], a[i][0]);
                    int hi = Math.min(b[i][1], a[i][1]);
                    out.add(new int[]{lo, hi});
                }
            }
        }
        return out.toArray(new int[out.size()][]);
    }

    // Working solution:
    // using two pointer i and j
    static int[][] inter(int[][] a, int[][] b) {
        List<int[]> ans = new ArrayList<>();
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            int lo = Math.max(a[i][0], b[j][0]);
            int hi = Math.min(a[i][1], b[j][1]);
            // check if lo is lies in the interval or vice versa
            if (lo <= hi)
                ans.add(new int[]{lo, hi});
            // check if the endpoints of A is greater or smaller
            // to check if another interval fits in the same A or B
            if (a[i][1] < b[j][1]) i++;
            else j++;
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
