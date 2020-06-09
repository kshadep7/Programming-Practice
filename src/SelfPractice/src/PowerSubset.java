import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PowerSubset {
    static List<String> out = new ArrayList<>();

    public static void main(String[] args) {

//        printSubsets(new char[]{'a', 'b', 'c'});
        int[] arr = {1, 2, 2};
        System.out.println(subsets(arr));
//        System.out.println(powerSet("abc"));
//        System.out.println(powerSetRecur("abc"));
        List<List<Integer>> a = new ArrayList<>();

/*
        // to check if a list is present in its parent list

        List<Integer> b = new ArrayList<>(List.of(1,2));

        a.add(new ArrayList<Integer>(List.of(1)));
        a.add(new ArrayList<>(List.of(1,2)));
        a.add(new ArrayList<>(List.of(1,2,2)));

        System.out.println(a);
        System.out.println(a.contains(b));
*/

    }

    static void printSubsets(char set[]) {
        int n = set.length;

        // Run a loop for printing all 2^n
        // subsets one by one
        int len = 1 << n;
        for (int i = 0; i < len; i++) {
            System.out.print("{ ");

            // Print current subset
            for (int j = 0; j < n; j++) {

                // (1<<j) is a number with jth bit 1
                // so when we 'and' them with the
                // subset number we get which numbers
                // are present in the subset and which
                // are not

                int tmp = (i & (1 << j));
                if (tmp > 0)
                    System.out.print(set[j] + " ");
            }

            System.out.println("}");
        }
    }

    public static List<List<Integer>> subsets(int[] arr) {
        List<List<Integer>> out = new ArrayList<>();

        int len = arr.length;
        int n = 1 << len;
        //for all final output
        for (int i = 0; i < n; i++) {

            // for current subset
            List<Integer> subsets = new ArrayList<>();
            for (int j = 0; j < len; j++) {

                int temp = i & (1 << j);
                if (temp > 0)
                    subsets.add(arr[j]);
            }
            if(!out.contains(subsets))
                out.add(subsets);
        }

        return out;
    }

    // for String

    public static List<String> powerSet(String str) {
        List<String> out = new ArrayList<>();
        char[] arr = str.toCharArray();
        int len = arr.length;
        int n = 1 << len;

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < len; j++) {
                int tmp = i & (1 << j);
                if (tmp > 0)
                    sb.append(arr[j]);
            }
            out.add(sb.toString());
        }
        return out;
    }

    // power set using recursion
    public static List<String> powerSetRecur(String str) {
        return (helper(str, str.length(), -1, ""));
    }

    static List<String> helper(String str, int len, int index, String curr) {
        // base case
        if (index == len)
            return out;

        out.add(curr);
        for (int i = index + 1; i < len; i++) {

            curr += str.charAt(i);
            helper(str, len, i, curr);

            curr = curr.substring(0, curr.length()-1);
        }
        return out;
    }

}
