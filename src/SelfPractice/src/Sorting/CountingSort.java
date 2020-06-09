package Sorting;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CountingSort {
// only works when the range of items is known
    public static void main(String[] args) {
        int[] arr = {4, 1, 3, 7, 9, 1, 0};
        String str = "akash";
        sort(str);
//        countSort(arr);
    }
    /*
    4 6 1 7 4 1 0

    count[range+1] - > count[7]
    count[] -> 0 1 2 3 4 5 6 7
               1 2     2   1 1
    count[] -> 1 3 3 3 5 5 6 7


     */


    static void countSort(int[] arr) {

        //count frequency of array elements
        int[] count = new int[10];
        int[] res = new int[arr.length];
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        System.out.println(Arrays.toString(count));

        for (int i = 1; i < count.length; i++) {
            count[i] = count[i] + count[i - 1];
        }
        System.out.println(Arrays.toString(count));

        for (int i = 0; i < arr.length; i++) {
            res[count[arr[i]]-1] = arr[i];
            count[arr[i]]--;
        }

        System.out.println(Arrays.toString(res));
    }

    static void sort(String s){
        int[] count = new int[26];
        char[] res = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        System.out.println(Arrays.toString(count));
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i-1];
        }

        System.out.println(Arrays.toString(count));
        for (int i = 0 ; i < res.length; i++) {
            res[count[s.charAt(i)-'a']-1] = s.charAt(i);
            count[s.charAt(i)-'a']--;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : res){
            sb.append(c);
        }
        System.out.println(sb.toString());
    }
}
