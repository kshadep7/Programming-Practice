import java.util.Arrays;

public class SubMatrixFull {

    public static void main(String[] args) {

        int[][] arr = {
                {1, 2, 3, 2, 5, 7},
                {4, 5, 6, 1, 7, 6},
                {7, 8, 9, 4, 8, 3}};

        System.out.println(Arrays.toString(isSubMtrixFull(arr)));
    }

    // TC: n x 3 x n -> 3n2 -> n2
    // TODO: can we do better ?? look into it.
    static boolean[] isSubMtrixFull(int[][] arr) {

        int len = arr[0].length - 2;
        boolean[] res = new boolean[len];

        // total sum of 1 to 9 -> 45
        int checkSum = 45;
        for (int i = 0; i < arr[0].length - 3; i++) {
            int sum = 0;
            for (int j = 0; j < 3; j++) {
                for (int k = i; k < i + 3; k++) {
                    sum += arr[j][k];
                }
            }
            if (sum == checkSum)
                res[i] = true;
        }
        return res;
    }
}
