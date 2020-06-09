package medium;

import java.util.HashSet;
import java.util.Set;

public class NumberDistinctIslands {

    public static void main(String[] args) {

        int[][] grid = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 1, 0, 1, 1}};
        System.out.println(distinctIslands(grid));
    }

    // the idea is same as number of islands
    // but here to find the distinctness we are creating strings and adding in set
    //if same shape of islands are present in the grid then set will have distinct island signature/ string
    // finally set size will be ur ans
    static int distinctIslands(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        Set<String> set = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0) {
                    StringBuilder sb = new StringBuilder();
                    helper(grid, i, j, sb, "o");// for origin
                    set.add(sb.toString());
                }
            }
        }
        System.out.println(set);
        return set.size();
    }

    private static void helper(int[][] grid, int i, int j, StringBuilder sb, String direction) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0)
            return;
        sb.append(direction);
        grid[i][j] = 0;
        helper(grid, i - 1, j, sb, "u");
        helper(grid, i + 1, j, sb, "d");
        helper(grid, i, j - 1, sb, "l");
        helper(grid, i, j + 1, sb, "r");
        sb.append("b"); // for backtracking
    }
}
