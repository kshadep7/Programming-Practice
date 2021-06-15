import java.util.Arrays;

public class FarthestNumber {

    /*
     Given an array and len of arr find right most smaller number of the current num in arr

     Input:
     N=5
     Arr[] = {3, 1, 5, 2, 4}
     Output:
     3 -1 4 -1 -1
     Explanation:
     Arr[3] is the farthest smallest element
     to the right of Arr[0].
     Arr[4] is the farthest smallest element
     to the right of Arr[2].
     And for the rest of the elements, there is
     no smaller element to their right.
    */
    public static void main(String[] args) {

        int[] arr = {3, 1, 5, 2, 4};
        int[] arr1 = {1, 2, 3, 4, 0};
        int[] arr2 = {5, 4, 3, 2, 1};
        int[] arr3 = {1, 2, 3, 4, 5};

        System.out.println(Arrays.toString(farthestNumber(5, arr)));
        System.out.println(Arrays.toString(farthestNumber(5, arr1)));
        System.out.println(Arrays.toString(farthestNumber(5, arr2)));
        System.out.println(Arrays.toString(farthestNumber(5, arr3)));
    }

    static int[] farthestNumber(int N, int[] Arr) {
        // 2 pointer approach
        // loop arr i,  j
        // check from right side smaller than current
        // if yes than record the idex and increament i and j to arr.len-1
        // and repeat untill i == arr.len - 1
        int n = N;
        int[] res = new int[n];
        int i = 0, j = n - 1;
        while (i < n && j >= 0) {
            if (Arr[i] > Arr[j]) {
                res[i] = j;
                i++;
                j = n - 1;
                continue;
            } else if (i == j) {
                res[i] = -1;
                i++;
                j = n - 1;
            } else
                j--;
        }
        return res;
    }
}
