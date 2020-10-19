package InsideCodeTech;

import java.util.Arrays;
import java.util.Stack;

public class MergeIntervals {

    public static void main(String[] args) {

        int[][] intervals = {{1, 4}, {5, 8}, {7, 10}, {9, 13}, {14, 16}, {16, 20}, {17, 19}};
        System.out.println(Arrays.deepToString(mergeInt(intervals)));
    }

    // TC:
    static int[][] mergeInt(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return intervals;
        // if arr in not sorted according to first point of the interval
        // sorting the array
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);  // NlogN
        Stack<int[]> stack = new Stack<>();
        stack.push(intervals[0]);
        int i = 1;
        while (i < intervals.length) {
            int[] pre = stack.pop();
            int[] next = intervals[i];
            if (pre[1] >= next[0]) {
                pre[0] = Math.min(pre[0], next[0]);
                pre[1] = Math.max(pre[1], next[1]);
                stack.push(pre);
            } else {
                stack.push(pre);
                stack.push(next);
            }
            i++;
        }
        int[][] res = new int[stack.size()][2];
        int j = stack.size() - 1;
        while (!stack.isEmpty()) {
            res[j--] = stack.pop();
        }
        return res;
    }
}
