
/*
 * in a given array find count of pairs of (1, j) such that i <= j and
 * (arr[i] + rev(arr[j]) == (arr[j] + rev(arr[i])
 * fun rev(102) = 201
 * */


public class OppositeNums {
    public static void main(String[] args) {
        int[] arr = {1, 20, 2, 11};
        System.out.println(oppositeNums(arr));
    }

    // TODO: Solve it!!!
    static int oppositeNums(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (i <= j) {

                }
            }
        }
        return 0;
    }
}
