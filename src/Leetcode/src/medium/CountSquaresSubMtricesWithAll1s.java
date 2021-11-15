package medium;

import java.util.Arrays;

public class CountSquaresSubMtricesWithAll1s {

	public static void main(String[] args) {
		int[][] mat = {
				{0, 1, 1, 1},
				{1, 1, 1, 1},
				{0, 1, 1, 1}
		};

		System.out.println(countSquares(mat));
	}

	// idea is to use dp matriix
	// if 1 then check for neighbors up left and up diagonally are 1 or not, if all are 1 then
	// take min of all neighbors and add 1
	// TC: mn
	public static int countSquares(int[][] mat) {

		int[][] dp = new int[mat.length + 1][mat[0].length + 1];
		int res = 0;
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (mat[i-1][j-1] != 0) {
					int tmp = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
					dp[i][j] = tmp;
					res += tmp;
				}
			}
		}
		for (int[] a : dp)
			System.out.println(Arrays.toString(a));
		return res;
	}
}
