package medium;

public class MissingElementSortedArray {

    public static void main(String[] args) {

        int[] arr = {4, 7, 9, 10, 14, 15, 17};
//        System.out.println(findElement(arr, 4));
        System.out.println(find1(arr, 5));
    }

    // [4,7,9,10], K = 3
    static int findElement(int[] arr, int k) {

        int index = 0;
        int ans = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[index] != 1) {
                ans = arr[index];
                while (ans < arr[i] - 1) {
                    k--;
                    ans += 1;
                    if (k == 0)
                        return ans;
                }
            }
            index++;
        }
        if (k > 0)
            ans = arr[arr.length - 1] + k;

        return ans;
    }

    // a little faster approach
    // but still o(n)
    static int find(int[] arr, int k) {
        int ans = arr[0] + k;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > ans)
                return ans;
            else ans++;
        }
        return ans;
    }

    // using binary search
    static int find1(int[] arr, int k) {
        int len = arr.length;
        int low = 0;
        int high = len - 1;
        // find all the missing element in the array
        int allMissingNum = arr[len - 1] - arr[0] - len + 1;

        if (allMissingNum < k)
            return arr[len - 1] + k - allMissingNum;

        // actual binary search
        while (low < high - 1) {

            // finding mid
            int mid = low + (high - low) / 2;
            // find all missing number from low to mid --> meaning left side of mid
            int missing = arr[mid] - arr[low] - (mid - low);
            // check if these left missing nums are >= k meaning missing value has
            // to lie to on the left side
            // if yes make your mid as high
            if (missing >= k)
                high = mid;
            else {
                // put your left as mid and subtract the missing nums from k
                // as the actual missing number lies on the right side of the mid
                k -= missing;
                low = mid;
            }
        }
        return arr[low] + k;

    }
}
