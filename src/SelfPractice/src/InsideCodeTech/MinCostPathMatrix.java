package InsideCodeTech;

public class MinCostPathMatrix {

    public static void main(String[] args) {

        int mat[][] = {
                {3, 12, 4, 7, 10},
                {6, 8, 15, 11, 4},
                {19, 5, 14, 32, 21},
                {1, 20, 2, 9, 7}};
//        };

//        System.out.println(minCost(mat));
//        System.out.println(minCost1(mat, 0, 0));
        System.out.println(minCost2(mat));
    }

    // greedy appraoch -> taking min of all the cell neighbors
    // doest always work depending on input
    static int minCost(int[][] mat) {
        int cost = mat[0][0];
        int i = 0, j = 0;
        // rows
        int m = mat.length;
        //cols
        int n = mat[0].length;

        while (i < m || j < n) {
            if (i == m - 1 && j == n - 1)
                return cost;
            if (i == m - 1) {
                cost += mat[i][j + 1];
                j++;
            } else if (j == n - 1) {
                cost += mat[i + 1][j];
                i++;
            } else if (cost + mat[i + 1][j] <= cost + mat[i][j + 1]) {
                cost += mat[i + 1][j];
                i++;
            } else {
                cost += mat[i][j + 1];
                j++;
            }
        }
        return cost;
    }

    // checking all possible paths using recursion
    // TC: 2 ^ (rows * cols) -> as there will 2 calls for every cell of cell
    // eg: 1st cell 2 calls(2nd cell 2 calls (3rd cell 2 calls(4th.....))) and so on.
    //SC: call stack -> (rows + cols) ->
    static int minCost1(int[][] mat, int i, int j) {
        int m = mat.length;
        int n = mat[0].length;
        if (i == m - 1 && j == n - 1)
            return mat[i][j];
        else if (i == mat.length - 1)
            return mat[i][j] + minCost1(mat, i, j + 1);
        else if (j == mat[0].length - 1)
            return mat[i][j] + minCost1(mat, i + 1, j);
        else
            return mat[i][j] + Math.min(minCost1(mat, i, j + 1),
                    minCost1(mat, i + 1, j));
    }

    //considering the fact that in above solution
    // there are repeated calls to same cells
    // we can reduce that using DP
    static int minCost2(int[][] mat) {
        //rows len
        int n = mat.length;
        //cols len
        int m = mat[0].length;

        int[][] costDp = new int[n][m];
        costDp[0][0] = mat[0][0];
        // fill first row with cumulative addition
        for (int i = 1; i < m; i++) {
            costDp[0][i] = mat[0][i] + costDp[0][i - 1];
        }
        // fill first col with cumulative addition
        for (int i = 1; i < n; i++) {
            costDp[i][0] = mat[i][0] + costDp[i - 1][0];
        }
        // fill the rest of mat
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                costDp[i][j] = Math.min(costDp[i - 1][j], costDp[i][j - 1]) + mat[i][j];
            }
        }
        return costDp[n - 1][m - 1];
    }

}
