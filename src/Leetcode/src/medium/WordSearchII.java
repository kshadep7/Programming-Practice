package medium;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {

    public static void main(String[] args) {

        char[][] arr = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}

        };

        String[] words = new String[]{"oath", "pea", "eat", "rain", "flka"};

        System.out.println(findWords(arr, words));

    }

    public static List<String> findWords(char[][] board, String[] words) {

        List<String> list = new ArrayList<>();
        int row = board.length;
        int col = board[0].length;

        int n = words.length;

        for (int i = 0; i < n; i++) {
            if (search(board, words[i])) {
                list.add(words[i]);
            }
        }

        return list;
    }

    public static boolean search(char[][] arr, String word) {

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

    public static boolean dfs(char[][] arr, String word, int i, int j, int index) {

        int row = arr.length;
        int col = arr[0].length;

        //base case
        if (i < 0 || j < 0 || i >= row || j >= col)
            return false;

        if (arr[i][j] == word.charAt(index)) {

            char temp = arr[i][j];
            arr[i][j] = '#';
            if (index == word.length() - 1) {
                arr[i][j] = temp;
                return true;
            }
            else if (dfs(arr, word, i - 1, j, index + 1)
                    || dfs(arr, word, i + 1, j, index + 1)
                    || dfs(arr, word, i, j - 1, index + 1)
                    || dfs(arr, word, i, j + 1, index + 1)) {
                arr[i][j] = temp;
                return true;
            }
            arr[i][j] = temp;
        }
        return false;
    }


}
