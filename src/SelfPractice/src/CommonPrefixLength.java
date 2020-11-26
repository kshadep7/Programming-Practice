import java.util.HashSet;
import java.util.Set;

public class CommonPrefixLength {

    public static void main(String[] args) {

        System.out.println(commonPrefix("abcabcd"));
        System.out.println(commonPrefix("ababaa"));
        System.out.println(commonPrefix("aa"));
    }

    public static int commonPrefix(String input) {
        int n = input.length();
        if (n == 0) return 0;

        int res = n;
        char[] arr = input.toCharArray();
        Set<Integer> indices = new HashSet<>();
        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[0])
                indices.add(i);
        }

        for (int index : indices) {
            res += getPrefixLength(arr, index);
        }
        return res;
    }

    public static int getPrefixLength(char[] arr, int start) {
        int res = 0, i = 0, j = start;

        while (j < arr.length) {
            if (arr[i++] == arr[j++])
                res++;
            else
                break;
        }
        return res;
    }
}
