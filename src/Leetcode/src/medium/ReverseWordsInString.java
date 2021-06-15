package medium;

import java.util.Arrays;

public class ReverseWordsInString {

    public static void main(String[] args) {

        String s = " the sky is  blue";
        System.out.println(reverseWords(s));
    }

    static String reverseWords(String s) {
        String[] arr = s.split(" ");
        System.out.println(Arrays.toString(arr));
        int start = 0, end = arr.length - 1;
        while (start < end) {
            if (arr[start].equals(""))
                start++;
            else if (arr[end].equals(""))
                end--;
            else {
                String temp = arr[start];
                arr[start++] = arr[end];
                arr[end--] = temp;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i].equals("")) {
                sb.append(arr[i]);
                if (i != arr.length - 1)
                    sb.append(" ");
            }
        }
        return sb.toString();
    }
}
