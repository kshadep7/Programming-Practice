package medium;

import java.util.ArrayList;
import java.util.List;

public class PathMaxMinValue {

    public static void main(String[] args) {

    }

    static int path(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        List<Integer> path = new ArrayList<>();
        int maxValue = Integer.MIN_VALUE;
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[i].length; j++) {
//            }
//        }
        helper(grid, 0, 0, path, maxValue);
        path.sort((a, b) -> a - b);
        return path.get(0);
    }
    // TODO : solve it
    private static void helper(int[][] grid, int i, int j, List<Integer> path, int maxValue) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == -1)
            return;

        if (grid[i][j] > maxValue) {
            maxValue = grid[i][j];
            path.add(grid[i][j]);

            grid[i][j] = -1;

            helper(grid, i - 1, j, path, maxValue);
            helper(grid, i + 1, j, path, maxValue);
            helper(grid, i, j - 1, path, maxValue);
            helper(grid, i, j + 1, path, maxValue);
        }
    }
}
