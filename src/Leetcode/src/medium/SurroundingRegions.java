package medium;

import java.util.Arrays;

public class SurroundingRegions {

    public static void main(String[] args) {
        char[][] arr = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
        };
        capture(arr);

        for (char[] r : arr)
            System.out.println(Arrays.toString(r));
    }

    static char[][] capture(char[][] arr) {
        if (arr == null)
            return arr;
        int m = arr.length, n = arr[0].length;
        // first check borders and convert Os to $
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 'O' && (i == 0 || i == m - 1 || j == 0 || j == n - 1))
                    helper(arr, i, j);
            }
        }

        // convert all the inner Os to X
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 'O')
                    arr[i][j] = 'X';
                else if (arr[i][j] == '$')
                    arr[i][j] = 'O';
            }
        }

        return arr;
    }

    private static void helper(char[][] arr, int i, int j) {
        int m = arr.length, n = arr[0].length;
        if (i >= 0 && i < m && j >= 0 && j < n && arr[i][j] == 'O') {
            arr[i][j] = '$';

            helper(arr, i, j + 1);
            helper(arr, i + 1, j);
            helper(arr, i, j - 1);
            helper(arr, i - 1, j);
        }
    }

}
