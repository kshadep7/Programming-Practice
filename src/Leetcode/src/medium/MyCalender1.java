package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MyCalender1 {

	TreeMap<Integer, Integer> map;
	List<int[]> intervals;

	public static void main(String[] args) {
		MyCalender1 cal = new MyCalender1();

		int[][] input = {{10, 20}, {15, 25}, {20, 30}};

		for (int[] in : input) {
//			System.out.println(cal.book(in[0], in[1]));
			System.out.println(cal.book1(in[0], in[1]));
		}
	}

	public MyCalender1() {
		intervals = new ArrayList<>();
		map = new TreeMap<>();
	}

	// n2
	public boolean book(int start, int end) {
		// a x1 y1 10 20
		// b x2 y2 15 25 (20 30)

		// x2 > x1 && x2 < y1
		int[] curr = new int[]{start, end};
		for (int[] interval : intervals) {
			if (overlap(interval, curr))
				return false;
		}
		intervals.add(curr);
		return true;

	}

	// nlogn
	public boolean book1(int start, int end) {

		Map.Entry<Integer, Integer> before = map.lowerEntry(end);
		if (before != null && before.getValue() > start)
			return false;

		map.put(start, end);
		return true;
	}


	private boolean overlap(int[] a, int[] b) {
		return a[0] < b[1] && b[0] < a[1];
	}


}
