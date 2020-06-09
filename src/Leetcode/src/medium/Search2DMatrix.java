package medium;

public class Search2DMatrix {

    public static void main(String[] args) {

        int[][] matrix = {
                {1,  4,  7,  11, 15},
                {2,  5,  8,  12, 19},
                {3,  6,  9,  16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};

        System.out.println(search(matrix, 5));
    }

    static boolean search(int[][] matrix, int target) {

        // idea is to use binary search as matrix has sorted row wise and column as well
        // iterating through diagonals
        // eg 0,0 -> search row then in column
        // then 1,1 -> inside of matrix as upper entire row and col to left of 11 are done searching

        if (matrix == null || matrix.length == 0)
            return false;
        //taking min of rows and cols
        int diagonalLen = Math.min(matrix.length, matrix[0].length);
        for (int i = 0; i < diagonalLen; i++) {
            // for searching in cols
            boolean verticalSearch = binarySearch(matrix, target, i, true);
            boolean horizontalSearch = binarySearch(matrix, target, i, false);
            if (verticalSearch || horizontalSearch)
                return true;
        }
        return false;
    }

    // performing binary search according to rows and cols
    private static boolean binarySearch(int[][] matrix, int target, int start, boolean vertical) {
        int lo = start;
        int hi = vertical ? matrix.length - 1 : matrix[0].length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (vertical) {
                if (matrix[mid][start] < target)
                    lo = mid + 1;
                else if (matrix[mid][start] > target)
                    hi = mid - 1;
                else
                    return true;
            } else {
                if (matrix[start][mid] < target)
                    lo = mid + 1;
                else if (matrix[start][mid] > target)
                    hi = mid - 1;
                else
                    return true;
            }
        }
        return false;
    }

    // just checking the values of matrix
    static boolean search2(int[][] matrix, int target) {
        int i = matrix.length - 1;
        int j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] > target)
                i--;
            else if (matrix[i][j] < target)
                j++;
            else
                return true;
        }
        return false;
    }
}
