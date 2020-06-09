package medium;

import java.util.Arrays;

public class SparseMatrixMultiply {

    public static void main(String[] args) {

        int[][] matA = {{1, 0, 0}, {-1, 0, 3}};
        int[][] matB = {{7, 0, 0}, {0, 0, 0}, {0, 0, 1}};

        int[][] out = multiply1(matA, matB);
        System.out.println(Arrays.deepToString(out));
    }

    /*
    *              |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
        AB =       | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                                | 0 0 1 |

    * */

    static int[][] multiply(int[][] a, int[][] b) {
        int[][] out = new int[a.length][b[0].length];

        if (a[0].length != b.length)
            return out;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                if (a[i][j] != 0) {
                    for (int k = 0; k < a[0].length; k++) {
                        out[i][k] += a[i][k] * b[k][j];
                    }
                }
            }
        }
        return out;
    }

    /*
    *              |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
        AB =       | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                                | 0 0 1 |

    * */

    public static int[][] multiply1(int[][] A, int[][] B) {
        int A_rows = A.length;
        int A_cols = A[0].length;
        int B_cols = B[0].length;
        int[][] C = new int[A_rows][B_cols];

        for (int i = 0; i < A_rows; i++) {
            for (int k = 0; k < A_cols; k++) {
                if (A[i][k] != 0) {
                    for (int j = 0; j < B_cols; j++) {
                        if (B[k][j] != 0)
                            C[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        }
        return C;
    }

}
