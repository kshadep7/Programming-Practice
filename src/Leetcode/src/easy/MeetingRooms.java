package easy;

import java.util.Arrays;

public class MeetingRooms {

    public static void main(String[] args) {
//        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        int[][] intervals = {{7, 10}, {2, 4}};

        System.out.println(canAttendAll(intervals));
    }

    static boolean canAttendAll(int[][] intervals) {

        if (intervals == null || intervals.length == 0)
            return true;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < intervals.length - 1; i++) {
            if (isOverlap(intervals[i], intervals[i + 1]))
                return false;
        }
        return true;
    }

    private static boolean isOverlap(int[] before, int[] after) {
        return (before[1] > after[0] && before[0] < after[1]);
    }
}
