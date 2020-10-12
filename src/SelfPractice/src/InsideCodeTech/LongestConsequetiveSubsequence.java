package InsideCodeTech;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*Given an array of integers arr, create a function that returns the length of the longest consecutive
sequence that can we found in arr.

Example 1:
Input: arr = [14, 1, 8, 4, 0, 13, 6, 9, 2, 7]
Output: 4
Explanation: the longest consecutive sequence is 6 7 8 9

Example 2:
Input: arr = [4, 5, 2, 6, 5, 4, 1, -5, 0, 4]
Output: 3
Explanation: the longest consecutive sequence is 4 5 6

Example 3:
Input: arr = [5, 10]
Output: 1
Explanation: the longest consecutive sequence is 5 (also 10)
*/
public class LongestConsequetiveSubsequence {

    public static void main(String[] args) {
        int[] arr = {14, 1, 8, 4, 0, 13, 6, 9, 2, 7};
        int[] arr1 = {4, 5, 2, 6, 5, 4, 1, -5, 0, 4};
        int[] arr2 = {5, 10};
        int[] arr3 = {1, 1, 1, 1, 1, 1, 1};
//        System.out.println(findLongest(arr3));
        System.out.println(findLongest1(arr1));
    }

    // TC: nlogn -> sorting
    static int findLongest(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        int max = 1;
        int temp = 1;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] + 1 == arr[i + 1])
                temp++;
            else {
                max = Math.max(temp, max);
                temp = 1;
            }
        }
        return max;
    }

    // TC : n -> coz the inner while loop will surely run less than n
    static int findLongest1(int[] arr) {

        Set<Integer> set = new HashSet<>();
        for (int i : arr)
            set.add(i);
        int max = 1;
        int temp = 1;
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (!set.contains(num - 1)) {

                while (set.contains(num + 1)) {
                    temp++;
                    num = num + 1;
                }
                max = Math.max(max, temp);
                temp = 1;
            }
        }
        return max;
    }
}
