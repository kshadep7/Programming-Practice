package InsideCodeTech;

public class FindMinRotatedSortedArray {

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 2, 3};
        int[] arr1 = {5, 6, 7, 2, 3, 4};
        System.out.println(finMin(arr1));
        System.out.println(finMinRec(arr1));
    }

    static int finMin(int[] arr) {
        // base case
        if (arr[arr.length - 1] > arr[0])
            return arr[0];
        int min = Integer.MAX_VALUE;
        return helper(arr, 0, arr.length - 1, min);
    }

    // TC: logN
    // recursive approach
    private static int helper(int[] arr, int start, int end, int min) {
        if (end >= start) {
            int mid = start + (end - start) / 2;

            min = Math.min(min, arr[mid]);
            if (arr[mid] < arr[mid + 1]) {
                min = helper(arr, start, mid - 1, min);
            } else {
                min = helper(arr, mid + 1, end, min);
            }
        }
        return min;
    }

    // iterative
    // TC: logN
    private static int finMinRec(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        if (arr[start] < arr[end])
            return arr[start];

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > arr[mid + 1])
                return arr[mid + 1];
            else if (arr[mid - 1] > arr[mid])
                return arr[mid];
            else if (arr[mid] > arr[end])
                start = mid + 1;
            else
                end = mid - 1;
        }
        return arr[start];
    }
}
