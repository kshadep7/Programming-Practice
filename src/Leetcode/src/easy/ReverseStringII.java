package easy;

public class ReverseStringII {

    public static void main(String[] args) {
        String s = "abcdefghij";
        System.out.println(reverseII(s, 2));
    }

    // the idea is to traverse the string by 2k and swap the k elements before moving on to next
    // 2kth index
    // TC: N, SC: N -> arr
    static String reverseII(String s, int k) {
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i += 2 * k) {       // N
            // get start and end index to swap
            int start = i;
            int end = Math.min(start + k - 1, arr.length);

            while (start < end) {       // less than N
                //swap
                char temp = arr[start];
                arr[start++] = arr[end];
                arr[end--] = temp;
            }
        }
        return new String(arr);
    }
}
