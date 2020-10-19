package InsideCodeTech;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

    public static void main(String[] args) {

        int[][] intervals = {{1, 3}, {4, 7}, {8, 10}, {12, 15}, {16, 17}, {18, 20}, {21, 25}, {28, 29}};
        int[] newInterval = {9, 18};

        System.out.println(Arrays.deepToString(insert(intervals, newInterval)));
    }

    // TC: N
    // SC: N
    static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> out = new ArrayList<>();

        int i = 0;
        //finding where to insert
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {  // N
            out.add(intervals[i]);
            i++;
        }
        // getting the interval -> merging if needed
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {     // N
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        out.add(newInterval);
        // add remaing intervals
        while (i < intervals.length) {  // N
            out.add(intervals[i]);
            i++;
        }
        int k = 0;
        int[][] res = new int[out.size()][2];
        for (int[] x : out) {
            res[k++] = x;
        }
        return res;
    }
}
