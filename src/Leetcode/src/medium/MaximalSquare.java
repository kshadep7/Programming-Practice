package medium;

import java.util.Arrays;

public class MaximalSquare {

	public static void main(String[] args) {
		int[][] mat = {
				{0, 1, 1, 1},
				{1, 1, 1, 1},
				{0, 1, 1, 1}
		};

		System.out.println(maxSquareArea(mat));
	}

	public static int maxSquareArea(int[][] mat) {

		int[][] dp = new int[mat.length + 1][mat[0].length + 1];
		int res = Integer.MIN_VALUE;
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (mat[i - 1][j - 1] != 0) {
					int tmp = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
					dp[i][j] = tmp;
					res = Math.max(res, tmp);
				}
			}
		}
		for (int[] a : dp)
			System.out.println(Arrays.toString(a));
		return res * res;
	}

}
