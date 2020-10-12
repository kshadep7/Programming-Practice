package InsideCodeTech;

public class PathsInMatrixWithWalls {

    public static void main(String[] args) {

        int[][] ways = {
                {0, 0, 0, 0, 1},
                {1, 0, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0}};

        System.out.println(noOfWays(ways));
        System.out.println(noOfWaysDP(ways));
    }

    // recursive apporach
    //TC: 2 ^ (rows * cols)
    //SC: rows + cols -> call stack
    static int noOfWays(int[][] ways) {
        return helper(ways, 0, 0, 0);
    }

    private static int helper(int[][] ways, int i, int j, int count) {
        int row = ways.length;
        int col = ways[0].length;

        if (i == row - 1 && j == col - 1) {
            count++;
            return count;
        } else if (ways[i][j] == 1)
            return count;
        else if (i == row - 1)
            count = helper(ways, i, j + 1, count);
        else if (j == col - 1)
            count = helper(ways, i + 1, j, count);
        else {
            count = helper(ways, i, j + 1, count);
            count = helper(ways, i + 1, j, count);
        }
        return count;
    }

    // using DP
    // TC, SC: rows * cols
    static int noOfWaysDP(int[][] ways) {
        int row = ways.length;
        int col = ways[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = ways[0][0] == 1 ? 0 : 1;
        // fill first row with previous cell value-> if wall then fill 0 for that cell
        for (int i = 1; i < col; i++) {
            dp[0][i] = ways[0][i] == 1 ? 0 : dp[0][i - 1];
        }
        // same for col
        for (int i = 1; i < row; i++) {
            dp[i][0] = ways[i][0] == 1 ? 0 : dp[i - 1][0];
        }
        // fill the remaining cells
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (ways[i][j] == 1)
                    dp[i][j] = 0;
                else
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[row - 1][col - 1];
    }
}
