package medium;

public class NumberOfIsland {

    public static void main(String[] args) {

        int[][] grid = {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 1, 1}};
        System.out.println(numOfIslands(grid));
    }

    static int numOfIslands(int[][] grid) {

        //checking nullability
        if (grid == null || grid.length == 0)
            return 0;

        int num = 0;
        // as we have to check every element in thr grid so nested for loops
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // check for only 1's
                if (grid[i][j] == 1)
                    num += dfsHelper(grid, i, j);
            }
        }
        return num;
    }

    static int dfsHelper(int[][] grid, int i, int j) {

        //base case check boundaries and grid block value
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0)
            return 0;

        //make the curr grid value 0 --> i.e. marking as visited
        grid[i][j] = 0;
        // otherwise check/recurse in 4 directions
        dfsHelper(grid, i + 1, j);
        dfsHelper(grid, i - 1, j);
        dfsHelper(grid, i, j + 1);
        dfsHelper(grid, i, j - 1);

        return 1;
    }
}
