package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RottingOranges {

	public static void main(String[] args) {
		int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
//        int[][] grid = {{1}};
//        int[][] grid = {{0, 1}};
//        int[][] grid = {{0,2}};
//        int[][] grid = {{1, 2}};
		// int[][] grid = {{2,1,1}, {0,1,1}, {1,0,1}};
//        int[][] grid = {{1}, {2}, {2}};

		System.out.println(minutes(grid));
		System.out.println(orangesRotting(grid));
	}

	// faster approach --> N
	// using dfs helper approach
	public static int orangesRotting(int[][] grid) {
		int liResult = 0;

		for (int i = 0; i < grid.length; ++i) {
			for (int j = 0; j < grid[i].length; ++j)
				if (grid[i][j] == 2)
					helper(grid, i, j, 2);
		}

		System.out.println(Arrays.deepToString(grid));

		for (int i = 0; i < grid.length; ++i) {
			for (int j = 0; j < grid[i].length; ++j)
				if (grid[i][j] == 1)
					return -1;
				else if (grid[i][j] == 0)
					continue;
				else
					liResult = Math.max(liResult, grid[i][j] - 2);
		}

		return liResult;
	}

	private static void helper(int[][] grid, int i, int j, int val) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length)
			return;

		if (grid[i][j] == 0)
			return;

		if (grid[i][j] > 1 && grid[i][j] < val)
			return;

		grid[i][j] = val;

		helper(grid, i + 1, j, val + 1);
		helper(grid, i - 1, j, val + 1);
		helper(grid, i, j + 1, val + 1);
		helper(grid, i, j - 1, val + 1);
	}

	static int minutes(int[][] grid) {
		// creates sets for fresh and rotten oranges

		Set<String> fresh = new HashSet<>();
		Set<String> rotten = new HashSet<>();

		// adding coordinates to sets
		// N --> visiting all nodes/blocks
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {

				if (grid[i][j] == 2)
					rotten.add("" + i + j);
				else if (grid[i][j] == 1)
					fresh.add("" + i + j);
			}
		}
		if (rotten.size() == 0)
			return -1;

//        System.out.println(rotten);
//        System.out.println(fresh);

		// checking if fresh oranges are in range of rotten orange
		// setting directions   up     down     right    left
		int min = 0;
		int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		// N --> worst case all blocks can be one except [0][0]
		while (fresh.size() > 0) {
			Set<String> infected = new HashSet<>();
			for (String s : rotten) {
				// might create problem for 2 digit indexes
				int i = s.charAt(0) - '0';
				int j = s.charAt(1) - '0';

				for (int[] dir : directions) {
					int nextI = i + dir[0];
					int nextJ = j + dir[1];
					if (fresh.contains("" + nextI + nextJ)) {
						infected.add("" + nextI + nextJ);
						fresh.remove("" + nextI + nextJ);
					}
				}

			}
			if (infected.size() == 0)
				return -1;

			rotten = infected;
			min++;
		}
		return min;

	}

	// dp cannot be used as thee rotten orange or 2 can be anywhere
	// for dp to be used rotten orange or 2 should be at (0,0) or (n,n)


}
