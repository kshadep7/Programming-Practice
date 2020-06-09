package medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    public static void main(String[] args) {

        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
//        int[][] intervals = {{7, 10}, {2, 4}};

        System.out.println(confRooms(intervals));
    }

    static int confRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        minHeap.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            int[] before = minHeap.remove();

            if (curr[0] >= before[1]) {
                before[1] = curr[1];
            } else
                minHeap.add(curr);

            minHeap.add(before);
        }
        return minHeap.size();
    }
}
