package medium;

import java.util.HashMap;
import java.util.Map;

public class TestGithubCopilot {

	// number of islands 2
	public static void main(String[] args) {
		char[][] grid = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'},
				{'0', '0', '0', '1', '1'}};
		System.out.println(numIslands(grid));
	}

	public static int numIslands(char[][] grid) {
		int res = 0;
		int m = grid.length;
		int n = grid[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1') {
					res++;
					dfs(grid, i, j);
				}
			}
		}
		return res;
	}

	public static void dfs(char[][] grid, int i, int j) {
		int m = grid.length;
		int n = grid[0].length;
		if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') {
			return;
		}
		grid[i][j] = '0';
		dfs(grid, i + 1, j);
		dfs(grid, i - 1, j);
		dfs(grid, i, j + 1);
		dfs(grid, i, j - 1);
	}

}
