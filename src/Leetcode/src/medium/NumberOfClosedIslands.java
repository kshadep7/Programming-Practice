package medium;

public class NumberOfClosedIslands {

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 1, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 1, 1, 1, 0}};

        int[][] grid1 = {
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0}};

        int[][] grid3 = {
                {1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1}};

        int[][] grid4 = {
                {0, 0, 1, 1, 0, 1, 0, 0, 1, 0},
                {1, 1, 0, 1, 1, 0, 1, 1, 1, 0},
                {1, 0, 1, 1, 1, 0, 0, 1, 1, 0},
                {0, 1, 1, 0, 0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0, 1, 1, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1, 1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 1, 0, 1, 0, 1},
                {1, 1, 1, 0, 1, 1, 0, 1, 1, 0}};

        System.out.println(closedIslands(grid));
        System.out.println(closedIslands(grid1));
        System.out.println(closedIslands(grid3));
        System.out.println(closedIslands(grid4));
    }

    static int closedIslands(int[][] grid) {

        int m = grid.length;
        if (m <= 2) return 0;
        int n = grid[0].length;
        if (n <= 2) return 0;

        boolean[][] visited = new boolean[m][n];
        boolean[] isNotBorder = new boolean[1];
        isNotBorder[0] = true;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == 0) {
                    helper(grid, i, j, visited, isNotBorder);
                    if (isNotBorder[0])
                        res++;
                    isNotBorder[0] = true;
                }
            }
        }
        return res;
    }

    private static void helper(int[][] grid, int i, int j, boolean[][] visited, boolean[] isNotBorder) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 1)
            return;

        if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && grid[i][j] == 0) {
            isNotBorder[0] = false;
            return;
        }
        grid[i][j] = 1;
        helper(grid, i + 1, j, visited, isNotBorder);
        helper(grid, i - 1, j, visited, isNotBorder);
        helper(grid, i, j + 1, visited, isNotBorder);
        helper(grid, i, j - 1, visited, isNotBorder);


    }
}
