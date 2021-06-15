package easy;

import java.util.Arrays;

public class MoveZeros {

    public static void main(String[] args) {

        int[] arr = {0, 1, 0, 3, 12};
        System.out.println(Arrays.toString(moveZeros(arr)));
    }

    // using 2 pointer approach
    // where pointer-1 is to keep track of non zero index to place the non zero element
    // other pointer-2 is used to iterate the array
    // TC: n, SC: 1 -> in-place
    static int[] moveZeros(int[] arr) {
        int lastNonZeroIndextoFill = 0; // pointer-1

        // pointer-2
        for (int i = 0; i < arr.length; i++) {      // N
            if (arr[i] != 0)
                arr[lastNonZeroIndextoFill++] = arr[i];
        }

        // fill the rest arr with zeros;
        for (int i = lastNonZeroIndextoFill; i < arr.length; i++) {     // N
            arr[i] = 0;
        }

        return arr;
    }
}
