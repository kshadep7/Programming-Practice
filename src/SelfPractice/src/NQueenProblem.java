public class NQueenProblem {


    public static void main(String[] args) {

    }

    // the idea is to check every col by putting the queen in each cell of that particular row
    // if the next row cannot be filled with a queen then back track
    // another check is to check for boundaries and if the placed queen is attacked or not.
    static int noOfWays(int gridLen, int queens) {
        int row = 0, col = 0;
        char[][] mat = new char[gridLen][gridLen];
        // fill array with (.)
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j] = '.';
            }
        }
        return helper(gridLen, mat, 0);
    }

    // TODO: Solve it !!
    private static int helper(int gridLen, char[][] mat, int row) {
        return 0;
    }


}
