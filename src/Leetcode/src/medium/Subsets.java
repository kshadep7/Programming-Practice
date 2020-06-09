package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

public class Subsets {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
//        System.out.println(subsets(arr));
//        System.out.println(sub(arr));
        System.out.println();
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList();
        output.add(new ArrayList<Integer>());

        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList();
            for (List<Integer> curr : output) {
                newSubsets.add(new ArrayList<Integer>(curr) {{
                    add(num);
                }});
            }
            for (List<Integer> curr : newSubsets) {
                output.add(curr);
            }
        }
        return output;
    }

    static List<List<Integer>> sub(int[] arr) {
        List<List<Integer>> out = new ArrayList<>();

        int j = 0;
        for (int i = 1; i <= arr.length; i++) {

            List<Integer> subs = new ArrayList<>();
            for (int k = 0; k < i; k++) {
                subs.add(arr[k]);
            }
            out.add(subs);
        }
        return out;
    }
}
