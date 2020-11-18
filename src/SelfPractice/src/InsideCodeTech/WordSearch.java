package InsideCodeTech;

public class WordSearch {

    public static void main(String[] args) {

        char[][] mat = {
                {'K', 'I', 'N', 'T'},
                {'B', 'I', 'N', 'S'},
                {'G', 'N', 'Y', 'I'},
                {'U', 'O', 'E', 'D'},
                {'D', 'I', 'B', 'V'},
                {'H', 'I', 'R', 'T'}};
        String word = "INSIDE";

        System.out.println(isWordPresent(mat, word));
    }

    static boolean isWordPresent(char[][] mat, String word) {
        int row = mat.length;
        int col = mat[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (helper(mat, word, 0, i, j)) {
                    printMat(mat);
                    return true;
                }
            }
        }
        printMat(mat);
        return false;
    }

    private static boolean helper(char[][] mat, String word, int index, int i, int j) {
        if (i < 0 || i >= mat.length || j < 0 || j >= mat[0].length)
            return false;
        else if (mat[i][j] == word.charAt(index)) {
            char temp = mat[i][j];
            mat[i][j] = '#';
            if (index == word.length() - 1)
                return true;
            else if (helper(mat, word, index + 1, i, j + 1)
                    || helper(mat, word, index + 1, i + 1, j)
                    || (helper(mat, word, index + 1, i, j - 1))
                    || helper(mat, word, index + 1, i - 1, j))
                return true;
            mat[i][j] = temp;
        }
        return false;
    }

    static void printMat(char[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println("\n");
        }
    }
}
