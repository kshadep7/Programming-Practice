package InsideCodeTech;

public class JumpToLastIndex {

    public static void main(String[] args) {

        int[] arr = {3, 0, 2, 0, 2, 1, 0, 3}; // false
        int[] arr1 = {3, 0, 2, 0, 2, 1, 4, 3}; // true
        System.out.println(isValid(arr, 0));
        System.out.println(isValidDP(arr));
        System.out.println(isValid1(arr1));
    }

    // TC: 2^n -> as there are many possibilities to reach the last index
    // and those possibilities are the subsets of array
    // worst case -> no of subsets of an array on n elements is 2^n
    static boolean isValid(int[] arr, int i) {
        if (i == arr.length - 1)
            return true;

        for (int j = 1; j < arr[i] + 1; j++) {
            if (isValid(arr, i + j))
                return true;
        }
        return false;
    }

    // no of repeated recursive call can be seen
    // so use DP
    //TC: n2
    //SC: n -> dp array
    static boolean isValidDP(int[] arr) {
        boolean[] dp = new boolean[arr.length];
        dp[0] = true;
        for (int i = 0; i < arr.length; i++) {
            if (!dp[i])
                return false;
            else if (i + arr[i] >= arr.length - 1)
                return true;
            for (int j = 1; j < arr[i] + 1; j++) {
                dp[i + j] = true;
            }
        }
        return dp[arr.length - 1];
    }

    //can be optimized
    // using max index logic
    //TC, SC: 1
    static boolean isValid1(int[] arr) {
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            // max jump is higher than last index
            // eg: maxIndex = 10 and arr ends at index 7 -> so poosible
            if (maxIndex >= arr.length - 1)
                return true;
            else if (maxIndex < i)  // eg. max jump is 7 and last index ends at 10 -> impossible
                return false;
            // can jump to max index
            maxIndex = Math.max(maxIndex, i + arr[i]);
        }
        return false;
    }
}
