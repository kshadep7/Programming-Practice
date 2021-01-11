package Hard;

import java.util.Arrays;

public class SetIntersectionSizeAtleast2 {

    public static void main(String[] args) {

        int[][] arr = {{1, 3}, {1, 4}, {2, 5}, {3, 5}, {90, 1000}, {91, 93}};
        int[][] arr1 = {{1, 2}, {2, 3}, {2, 4}, {4, 5}};
        int[][] arr2 = {{2, 10}, {3, 7}, {3, 15}, {4, 11}, {6, 12}, {6, 16}, {7, 8}, {7, 11}, {7, 15}, {11, 12}};
        System.out.println(findMinSeTSize(arr2));
    }

    static int findMinSeTSize(int[][] intervals) {
        // sort the array -> asc by end points and if same end points then desc by start point
        Arrays.sort(intervals, (a, b) -> (a[1] != b[1]) ? a[1] - b[1] : b[0] - a[0]);

        int res = 0;
        int max = -1, secMax = -1;
        for (int[] curr : intervals) {
            int a = curr[0], b = curr[1];

            boolean isInMax = a <= max;
            boolean isInSecMax = a <= secMax;

            if (isInMax && isInSecMax)
                continue;

            res += (isInMax ? 1 : 2);

            secMax = (isInMax ? max : b - 1);
            max = b;
        }
        return res;
    }
}
