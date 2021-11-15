package medium;

import java.util.*;

public class MergeIntervals {
	//[[1,3],[2,6],[8,10],[15,18]]
	public static void main(String[] args) {
		int[][] arr = {
				{1, 3},
				{2, 6},
				{8, 10},
				{15, 18}
		};
		int[][] arr1 = {
				{8, 9},
				{6, 7},
				{4, 5},
				{2, 3},
				{1, 10}
		};
		int[][] arr3 = {{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}};
		int[][] arr4 = {{1, 4}, {4, 5}};



//        int[][] out = merge2(arr);
//		int[][] out = mergeWithoutStack(arr3);
//		System.out.println(Arrays.deepToString(out));
//		System.out.println(Arrays.deepToString(merge(arr4)));
	}

	// with stack and sorting
	static int[][] merge(int[][] arr) {
		Stack<int[]> stack = new Stack<>();

		Arrays.sort(arr, (a, b) -> a[0] - b[0]);
		stack.push(arr[0]);

		for (int i = 1; i < arr.length; i++) {
			int[] top = stack.peek();
			int[] next = arr[i];
			if (top[1] < next[0]) {
				stack.push(next);
			} else if (top[1] < next[1]) {
				top[1] = next[1];
				stack.pop();
				stack.push(top);
			}
		}
		int[][] out = new int[stack.size()][];
		int i = 0;
		while (!stack.isEmpty()) {

			out[i] = stack.pop();
			i++;
		}

		return out;
	}
	// TC: O(n*Log(n)) - due to sorting
	// SC: O(n) - Stack

	//without stack with sorting
	static int[][] mergeWithoutStack(int[][] arr) {
		Arrays.sort(arr, (a, b) -> a[0] - b[0]);
		int index = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[index][1] >= arr[i][0] && arr[index][0] <= arr[i][1]) {
				arr[index][1] = Math.max(arr[index][1], arr[i][1]);
				arr[index][0] = Math.min(arr[index][0], arr[i][0]);
			} else {
//                arr[index] = arr[i];
				index++;
			}
		}
		int[][] out = new int[index + 1][];
		for (int i = 0; i < out.length; i++) {
			out[i] = arr[i];
		}
		return out;
	}

	// Working solution with TC --> less than O(n2)  -- without sorting
	public static int[][] merge2(int[][] arr) {

		if (arr.length <= 1) return arr;

		//add first interval
		List<int[]> list = new ArrayList<>();
		list.add(arr[0]);

		for (int i = 1; i < arr.length; i++) {
			int[] newI = arr[i];
			for (int j = 0; j < list.size(); j++) {
				int[] oldI = list.get(j);
				if (overlap(oldI, newI)) {
					//merge two intervals
					int l = Math.min(oldI[0], newI[0]);
					int r = Math.max(oldI[1], newI[1]);
					newI = new int[]{l, r};
					//remove old interval
					list.remove(j--);
				}
			}
			//add new interval
			list.add(newI);
		}

		return list.toArray(new int[list.size()][]);
	}

	private static boolean overlap(int[] i1, int[] i2) {
		return (i1[0] <= i2[1] && i2[0] <= i1[1]);
	}


}
