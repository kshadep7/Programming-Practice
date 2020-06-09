package medium;

import java.util.Arrays;

public class WordSearch {
    public static void main(String[] args) {

        char[][] arr = new char[][]{
                {'a', 'b', 'c', 'e'},
                {'s', 'f', 'c', 's'},
                {'a', 'd', 'e', 'e'}
        };

        System.out.println(search(arr, "abcc"));
    }

    /*

    a   b   c   e
    s   f   c   s
    a   d   e   e

     */
    static boolean search(char[][] arr, String word) {
        int row = arr.length;
        int col = arr[0].length;
        int index = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(arr, word, i, j, index))
                    return true;

            }
        }

        return false;
    }

    static boolean dfs(char[][] arr, String word, int i, int j, int index) {

        int row = arr.length;
        int col = arr[0].length;

        if (i < 0 || j < 0 || i >= row || j >= col)
            return false;

        if (arr[i][j] == word.charAt(index)) {
            char temp = arr[i][j];
            arr[i][j] = '#';
            if (index == word.length() - 1)
                return true;
            else if (dfs(arr, word, i - 1, j, index + 1)
                    || dfs(arr, word, i + 1, j, index + 1)
                    || dfs(arr, word, i, j - 1, index + 1)
                    || dfs(arr, word, i, j + 1, index + 1))
                return true;

            arr[i][j] = temp;
        }
        return false;
    }
}
