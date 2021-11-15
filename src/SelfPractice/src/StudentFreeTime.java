import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentFreeTime {

	public static void main(String[] args) {

		int[][] arr = {{1, 3}, {6, 7}, {2, 4}, {2, 5}, {9, 12}};
		int[][] arr1 = {{1, 2}, {5, 6}, {1, 3}, {4, 10}};
//		System.out.println(Arrays.deepToString(sol(arr)));
//		System.out.println(Arrays.deepToString(sol(arr1)));

	}

	public static int[][] sol(int[][] arr) {

		Arrays.sort(arr, (a, b) -> {
			if (a[0] == b[0])
				return a[1] - b[1];
			else
				return a[0] - b[0];
		});

		System.out.println(Arrays.deepToString(arr));
		int[][] res = new int[arr.length][2];
		int j = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			int[] pre = arr[i];
			int[] curr = arr[i + 1];

			if (!overlap(pre, curr)) {
				res[j][0] = pre[1];
				res[j][1] = curr[0];
				j++;
			}
		}
		return Arrays.copyOf(res, j);
	}

	private static boolean overlap(int[] i1, int[] i2) {
		return (i1[0] <= i2[1] && i2[0] <= i1[1]);
	}


}
