package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NextPalindrome {
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {

        int[] arr = {3, 2, 1};
//        nextPermutation(arr);
        next(arr);

    }

    // O(N): find the decreasing element in the array from right most element
    /*
    eg. 1 2 6 5 4 3
          i <- <- <-
        checking for value after 2
        1 2 6 5 4 3
          i       j
        swap i and j
        1 3 6 5 4 2
          i       j
        reverse everything after i
        1 3 (6 5 4 2)
        1 3  2 4 5 6 --> output
     */
    // swap that element with right most element
    // reverse entire array after the index of decreasing element found in step 1

    static void next(int[] nums) {
        int i = nums.length - 2;
        //finding decreasing the element
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
        System.out.println(Arrays.toString(nums));
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void reverse(int[] arr, int i) {
        int j = arr.length - 1;
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }
    // brute force : nlogn + n!
    // 1) finding all the permutations
    // 2) checking where the given string lies and getting next string
    // 3) if not present then return sorted string

    public static void nextPermutation(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        String s = "";
        for (int i : arr)
            s += i;
        String a = "";
        for (int i : nums)
            a += i;
        System.out.println(s);
        helper(s, "", list);
        System.out.println(list);
        int index = list.indexOf(a);
        if (index == list.size() - 1)
            Arrays.sort(nums);
        else {
            String str = list.get(index + 1);
//            System.arraycopy(str.toCharArray(),0, nums, 0, nums.length);
            int i = 0;
            for (char c : str.toCharArray()) {
                nums[i++] = c - '0';
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    private static void helper(String s, String ans, List<String> list) {

        if (s.length() == 0) {
            if (!list.contains(ans))
                list.add(ans);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            String ros = s.substring(0, i) + s.substring(i + 1);
            helper(ros, ans + c, list);
        }
    }
}
