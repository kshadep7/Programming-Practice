package medium;

import java.util.*;

public class IntervalListIntersections {
    public static void main(String[] args) {

        int[][] a = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
//        int[][] b = {{1, 2}, {5, 5}, {8, 12}, {15, 24}, {25, 26}};
        int[][] b = {{1, 2}, {5, 5}, {8, 10}, {15, 23}, {24, 24}, {25, 25}};
//        System.out.println(Arrays.deepToString(intersection(a, b)));
        System.out.println(Arrays.deepToString(union(a, b)));
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
    static int[][] intersection(int[][] a, int[][] b) {
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

    static int[][] union(int[][] a, int[][] b) {
        Stack<int[]> stack = new Stack<>();
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            int[] x = a[i], y = b[j];
            int[] curr = null;
            if (hasOverlap(x, y)) {
                curr = getMerge(x, y);
            }
            //check for previous overlaps
            if (stack.size() == 0)
                stack.push(curr);

            if (curr != null) {
                if (hasOverlap(stack.peek(), curr)) {
                    stack.push(getMerge(stack.pop(), curr));
                } else
                    stack.push(curr);
            }
            if (x[1] < y[1]) i++;
            else j++;
        }
        //check for remaining elements in both arrays
        while (i < a.length) {
            int[] curr = a[i++];
            if (hasOverlap(stack.peek(), curr))
                stack.push(getMerge(stack.pop(), curr));
            else stack.push(curr);
        }

        while (j < b.length) {
            int[] curr = a[j++];
            if (hasOverlap(stack.peek(), curr))
                stack.push(getMerge(stack.pop(), curr));
            else stack.push(curr);
        }

        LinkedList<int[]> res = new LinkedList<>();
        while (!stack.isEmpty())
            res.addFirst(stack.pop());

        return res.toArray(new int[res.size()][]);
    }

    private static int[] getMerge(int[] x, int[] y) {
        return new int[]{Math.min(x[0], y[0]), Math.max(x[1], y[1])};
    }

    private static boolean hasOverlap(int[] x, int[] y) {
        if (x[0] > y[0])
            return hasOverlap(y, x);

        return Math.max(x[0], y[0]) <= Math.min(x[1], y[1]);
    }

}
