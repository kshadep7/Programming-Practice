package medium;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {

        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int[] arr1 = {1, 3, 1, 1, 1};
//        System.out.println(search(arr, 5));
        System.out.println(search1(arr1, 3));
    }

    static int search(int[] arr, int target) {

        // using basic binary search approach
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (arr[mid] == target)
                return mid;

            if (arr[mid] >= arr[lo]) {
                if (target >= arr[lo] && target < arr[mid]) {
                    hi = mid - 1;
                } else lo = mid + 1;
            } else {
                if (target <= arr[hi] && target > arr[mid])
                    lo = mid + 1;
                else hi = mid - 1;
            }
        }
        return -1;
    }

    // what if duplicates are present
    static boolean search1(int[] arr, int target) {

        // using basic binary search approach
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (arr[mid] == target)
                return true;
            // left side is sorted --  no need for double checking
            if (arr[mid] > arr[lo] /*|| arr[mid] > arr[hi]*/) {
                if (target >= arr[lo] && target < arr[mid]) {
                    hi = mid - 1;
                } else lo = mid + 1;

            } else if (/*arr[mid] < arr[hi] ||*/ arr[mid] < arr[lo]) { // right side is sorted
                if (target <= arr[hi] && target > arr[mid])
                    lo = mid + 1;
                else hi = mid - 1;
            } else {
                // because arr[lo] == arr[mid] == arr[hi]
                //so just increment pointer lo or hi .. both works
                // doing nothing but just decreasing number of duplicates in the search sub array
                // worst case is O(n) for eg [1,1,1,1,1,1]
                lo++;
            }
        }
        return false;
    }

}
