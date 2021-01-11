package medium;

import java.util.Arrays;

public class Minesweeper {

    public static void main(String[] args) {
        char[][] board = {
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}};

        updateBoard(board, new int[]{3, 0});
        printBoard(board);

    }

    static char[][] updateBoard(char[][] board, int[] click) {
        int rowLen = board.length, colLen = board[0].length;
        int row = click[0], col = click[1];

        // check for cell mine if M -> change to X, stop dfs and return board.
        if (board[row][col] == 'M') {
            board[row][col] = 'X';
        } else {
            // find neighbor has a mine or not
            int count = 0;
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (i == 0 && j == 0)
                        continue;
                    int r = row + i, c = col + j;
                    if (r < 0 || r >= rowLen || c < 0 || c >= colLen)
                        continue;
                    if (board[r][c] == 'M' || board[r][c] == 'X')
                        count++;
                }
            }
            // if mines are present then update the cell with count
            if (count > 0) {
                board[row][col] = (char) (count + '0');
            } else {
                board[row][col] = 'B';
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        if (i == 0 && j == 0)
                            continue;
                        int r = row + i, c = col + j;
                        if (r < 0 || r >= rowLen || c < 0 || c >= colLen)
                            continue;
                        if (board[r][c] == 'E')
                            updateBoard(board, new int[]{r, c});
                    }
                }
            }
        }
        return board;
    }

    static void printBoard(char[][] mat) {
        for (char[] chars : mat) {
            System.out.println(Arrays.toString(chars));
        }
    }

}
