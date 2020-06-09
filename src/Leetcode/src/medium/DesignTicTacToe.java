package medium;

public class DesignTicTacToe {
    int[][] grid;

    public static void main(String[] args) {

        DesignTicTacToe ticTacToe = new DesignTicTacToe(3);
        System.out.println(ticTacToe.move(0, 0, 1));
        System.out.println(ticTacToe.move(1, 1, 1));
        System.out.println(ticTacToe.move(2, 2, 1));
    }

    public DesignTicTacToe(int n) {
        grid = new int[n][n];

    }

    public int move(int row, int col, int player) {
        // check if x,y are in grid
        if (row >= grid.length || col >= grid[0].length)
            return 0;
        // check if the cell is used or not
        if (grid[row][col] != 0)
            return 0;
        grid[row][col] = player == 1 ? 1 : 2;
        // check vertical
        if (checkVertical(col, player))
            return player;
        if (checkHorizontal(row, player))
            return player;
        if (checkDiagonal(row, col, player))
            return player;
        return 0;
    }

    public boolean checkVertical(int col, int player) {
        for (int i = 0; i < grid[0].length; i++) {
            if (grid[i][col] != player)
                return false;
        }
        return true;
    }

    public boolean checkHorizontal(int row, int player) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[row][i] != player)
                return false;
        }
        return true;
    }

    public boolean checkDiagonal(int row, int col, int player) {
        if (row != col && row + col != grid.length - 1)
            return false;
        boolean topLeftBottomRight = true;
        boolean topRightBottomLeft = true;

        for (int i = 0; i < grid.length; i++) {
            if (grid[i][i] != player) {
                topLeftBottomRight = false;
                break;
            }
        }
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][grid.length - 1 - i] != player) {
                topRightBottomLeft = false;
                break;
            }
        }
        return topLeftBottomRight || topRightBottomLeft;
    }

    // O(1) approach

}
