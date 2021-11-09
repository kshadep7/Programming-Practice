import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlowerHouses {

	static boolean foundWay = false;
	static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

	public static void main(String[] args) {

		char[][] grid = new char[][]{
				{'H', '0', '0', '0'},
				{'0', 'H', '0', 'H'},
				{'0', '0', 'H', '0'},
				{'0', '0', '0', '0'}};


		flowerHouses(grid);
		for (char[] row : grid)
			System.out.println(Arrays.toString(row));
	}

	public static void flowerHouses(char[][] grid) {

		int n = grid.length;
		int m = grid[0].length;
		// for checking if flower is present in that row or col
		boolean[] rows = new boolean[n];
		boolean[] cols = new boolean[m];

		//getting house cordinates
		List<int[]> houses = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 'H')
					houses.add(new int[]{i, j});
			}
		}
		for (int[] i: houses){
			System.out.println(Arrays.toString(i));
		}

		dfs(grid, 0, houses, rows, cols);
	}

	private static void helper(char[][] grid, int i, List<int[]> houses, boolean[] rows, boolean[] cols) {
		// check nummber of flowers planted are greater than houses
		// or if we already found a correct possible way to plant for all houses
		if (i >= houses.size() || foundWay)
			return;

		int[] house = houses.get(i);
		for (int[] dir : dirs) {
			int x = house[0] + dir[0];
			int y = house[1] + dir[1];

			// cheeck if in grid and flower not present in that row or col
			if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '0' && !rows[x] && !cols[y]) {
				// check if flowers planted are eequal to no of houses
				if (i == houses.size() - 1) {
					foundWay = true;
					return;
				}

				//plant flower
				grid[x][y] = 'X';
				// mark visited on that row and col
				rows[x] = true;
				cols[y] = true;
				//call for next house
				helper(grid, i + 1, houses, rows, cols);
				//check if we already found a way
				if (foundWay)
					return;

				//backtrack
				grid[x][y] = '0';
				rows[x] = false;
				cols[y] = false;
			}
		}
	}

	private static void dfs(char[][] arr, int i, List<int[]> houses, boolean[] rows, boolean[] cols) {
		if(i >= houses.size() || foundWay) return;

		int[] house = houses.get(i);

		for(int[] d : dirs) {
			int x = d[0] + house[0];
			int y = d[1] + house[1];
			if(x >= 0 && x < arr.length && y >= 0 && y < arr[0].length && arr[x][y] == '0' && !rows[x] && !cols[y]) {
				if(i == houses.size()-1) {
					foundWay = true;
					return;
				}
				arr[x][y] = 'X';
				rows[x] = true;
				cols[y] = true;
				dfs(arr, i+1, houses, rows, cols);
				if(foundWay) return;
				arr[x][y] = '0';
				rows[x] = false;
				cols[y] = false;
			}
		}
	}
}
