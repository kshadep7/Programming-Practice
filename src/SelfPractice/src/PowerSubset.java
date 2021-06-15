import java.util.*;

public class PowerSubset {
    static List<String> out = new ArrayList<>();

    public static void main(String[] args) {

//        printSubsets(new char[]{'a', 'b', 'c'});
        int[] arr = {1, 2, 3};
//        System.out.println(subsets(arr));
//        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3));
//        System.out.println(powerSet(set));
        System.out.println(countSubsets(arr, new ArrayList<>(), 0, new ArrayList<>()));
//        System.out.println(powerSet("abc"));
//        System.out.println(powerSetRecur("abc"));
//        List<List<Integer>> a = new ArrayList<>();

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

    // TC: N * 2^N
    public static List<List<Integer>> subsets(int[] arr) {
        List<List<Integer>> out = new ArrayList<>();

        int len = arr.length;
        int n = 1 << len;   // i.e 2^len
        //for all final output
        for (int i = 0; i < n; i++) {   // 2^len
            // for current subset
            List<Integer> subsets = new ArrayList<>();
            for (int j = 0; j < len; j++) { // len

                int temp = i & (1 << j);
                if (temp > 0)
                    subsets.add(arr[j]);
            }
            if (!out.contains(subsets))     // len
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

            curr = curr.substring(0, curr.length() - 1);
        }
        return out;
    }

    public static Set<Set<Integer>> powerSet(Set<Integer> GivenSet) {
        Set<Set<Integer>> resultSet = new HashSet<>();
        if (GivenSet.isEmpty()) {
            resultSet.add(new HashSet<>());
            return resultSet;
        }
        List<Integer> list = new ArrayList<>(GivenSet);
        int head = list.get(0);
        Set<Integer> restOfSet = new HashSet<>(list.subList(1, list.size()));
        for (Set<Integer> currSet : powerSet(restOfSet)) {
            Set<Integer> newSet = new HashSet<>();
            newSet.add(head);
            newSet.addAll(currSet);
            resultSet.add(newSet);
            resultSet.add(currSet);
        }
        return resultSet;
    }

    // Using Backtracking
    //TC: N x 2^N
    static List<List<Integer>> countSubsets(int[] arr, List<Integer> curr, int index, List<List<Integer>> res) {
        if (index >= arr.length) {
            return res;
        } else {
            curr.add(arr[index]);
            countSubsets(arr, curr, index + 1, res);
            res.add(new ArrayList<>(curr));
            curr.remove(curr.size() - 1);
            countSubsets(arr, curr, index + 1, res);
        }
        return res;
    }

}
