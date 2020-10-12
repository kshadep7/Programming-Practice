package medium;

import java.util.ArrayList;
import java.util.List;

public class SprialMatrix {

    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 3,},
                {4, 5, 6},
                {7, 8, 9}};

        System.out.println(spiral(mat));
    }

    // TC: n -> all cells in mat
    static List<Integer> spiral(int[][] mat) {
        List<Integer> res = new ArrayList<>();

        if (mat == null || mat.length == 0)
            return res;

        int top = 0;
        int right = mat[0].length - 1;
        int left = 0;
        int bottom = mat.length - 1;

        int size = mat.length * mat[0].length;
        while (res.size() < size) {

            for (int i = left; i <= right && res.size() < size; i++) {
                //adding top row
                res.add(mat[top][i]);
            }
            top++;      // dont want to add top right element twice
            for (int i = top; i <= bottom && res.size() < size; i++) {
                //adding right most col
                res.add(mat[i][right]);
            }
            right--;
            for (int i = right; i >= left && res.size() < size; i--) {
                //adding bottom row
                res.add(mat[bottom][i]);
            }
            bottom--;
            for (int i = bottom; i >= top && res.size() < size; i--) {
                //adding left col
                res.add(mat[i][left]);
            }
            left++;     // go one layer inside of mat
        }
        return res;
    }
}
