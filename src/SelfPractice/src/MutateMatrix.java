public class MutateMatrix {

    // mutate matrix according to the queries provided by array q
    // 0 -> rotate 90 degree
    // 1 -> reflect it its main diagonal
    // 2 -> reflect in its secondary diagonal

    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        int[] q = {0, 1, 2};
        System.out.println("Orginal: \n");
        printMat(mat, 4);
        System.out.println("\n\n");
        printMat(mutate(mat, q), mat.length);
    }

    static int[][] mutate(int[][] a, int[] q) {

        for (int i : q) {
            switch (i) {
                case 0:
                    rotate(a);
                    break;
                case 1:
                    mainReflect(a);
                    break;
                case 2:
                    secondaryReflect(a);
                    break;
                default:
                    return null;
            }
        }
//        rotate(a);
//        mainReflect(a);
//        secondaryReflect(a);
//        printMat(a, a.length);
        return a;
    }

    static void rotate(int[][] a) {
        int n = a.length;
        for (int layer = 0; layer < n / 2; layer++) {
            for (int i = layer; i < n - 1 - layer; i++) {
                // temp = top
                int temp = a[layer][i];
                // top = left
                a[layer][i] = a[n - 1 - i][layer];
                // left = bottom
                a[n - 1 - i][layer] = a[n - 1 - layer][n - 1 - i];
                //bottom = right
                a[n - 1 - layer][n - 1 - i] = a[i][n - 1 - layer];
                //right = temp
                a[i][n - 1 - layer] = temp;
            }
        }

//        System.out.println("Rotate: \n");
//        printMat(a, a.length);
    }

    static void mainReflect(int[][] a) {
        boolean[][] visited = new boolean[a.length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {

                if (i != j && !visited[i][j] && !visited[j][i]) {
                    int temp = a[i][j];
                    a[i][j] = a[j][i];
                    a[j][i] = temp;

                    visited[i][j] = true;
                    visited[j][i] = true;
                }
            }
        }
//        System.out.println("Main reflect: \n");
//        printMat(a, a.length);

    }

    static void secondaryReflect(int[][] a) {

//        boolean[][] visited = new boolean[a.length][a.length];

        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                int temp = a[i][j];
                a[i][j] = a[n - 1 - j][n - 1 - i];
                a[n - 1 - j][n - 1 - i] = temp;
            }
        }
//        System.out.println("Secondarty Reflect: \n");
//        printMat(a, a.length);

    }

    static void printMat(int[][] mat, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
//                mat[i][j] = ++count;
                if (mat[i][j] < 10) {
                    System.out.print(mat[i][j] + "      ");
                } else if (mat[i][j] < 100) {
                    System.out.print(mat[i][j] + "     ");
                } else {
                    System.out.print(mat[i][j] + "   ");
                }
            }
            System.out.println("\n");
        }

    }
}
