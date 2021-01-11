package medium;

import java.util.HashSet;

public class ValidSuduku {

    public static void main(String[] args) {

        char[][] grid = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        System.out.println(isValidSuduku(grid));
    }

    static boolean isValidSuduku(char[][] grid) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] != '.') {
                    char ch = grid[i][j];
                    int boxIndex = getBoxIndex(i, j);
                    if (rows[i].contains(ch) || cols[j].contains(ch) || boxes[boxIndex].contains(ch))
                        return false;

                    rows[i].add(ch);
                    cols[j].add(ch);
                    boxes[boxIndex].add(ch);
                }
            }
        }
        return true;
    }

    private static int getBoxIndex(int i, int j) {
        if (0 <= i && i < 3 && 0 <= j && j < 3) return 0;
        if (0 <= i && i < 3 && 3 <= j && j < 6) return 1;
        if (0 <= i && i < 3 && 6 <= j && j < 9) return 2;

        if (3 <= i && i < 6 && 0 <= j && j < 3) return 3;
        if (3 <= i && i < 6 && 3 <= j && j < 6) return 4;
        if (3 <= i && i < 6 && 6 <= j && j < 9) return 5;

        if (6 <= i && i < 9 && 0 <= j && j < 3) return 6;
        if (6 <= i && i < 9 && 3 <= j && j < 6) return 7;
        if (6 <= i && i < 9 && 6 <= j && j < 9) return 8;

        return -1;
    }
}
