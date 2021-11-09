package easy;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

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

	private static boolean isOverlap1(int[] before, int[] after) {
		return (before[1] > after[0] && before[0] < after[1]);
	}

	static int canAttendAll1(List<Integer> start, List<Integer> end) {

		int[][] intervals = new int[start.size()][2];
		for (int i = 0; i < start.size(); i++) {
			intervals[i] = new int[]{start.get(i), end.get(i)};
		}
		int res = 1;

		// if (intervals == null || intervals.length == 0)
		//   return 0;

		Stack<int[]> st = new Stack<>();

		Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
		st.push(intervals[0]);

		for (int i = 1; i < intervals.length - 1; i++) {

			int[] curr = st.peek();
			if (isOverlap(curr, intervals[i])) {
//				st.pop();
				st.push(intervals[i]);
			} else {

			}
		}
		return 0;
	}

}
