import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationWithContraints {

    public static void main(String[] args) {

        int[] arr = {2, 2, 4, 2, 5, 7, 11};
        int[] arr1 = {3, 4, 4, 1, 2, 3, 4};
        System.out.println(Arrays.toString(findPermuationsCounts(arr)));
    }

    static int[] findPermuationsCounts(int[] arr) {
        int d = arr[0];
        int t = arr[1];
        int q = arr[2];

        int[] ans = new int[q];
        int k = 0;
        for (int i = 3; i < arr.length; i++) {
            ans[k++] = helper(d, t, arr[i], "", 0, 0, new ArrayList<>()).size();
        }

//        System.out.println(helper(3, 3, 5, "", 0, 0, new ArrayList<>()).size());
        return ans;
    }

    static List<String> helper(int d, int t, int n, String currPerm, int i, int j, List<String> res) {
        if (currPerm.length() == n && i < d && j < t) {
            res.add(currPerm);
            return res;
        } else if (i >= d || j >= t)
            return res;
        else {
            helper(d, t, n, currPerm + "D", i + 1, 0, res);
            helper(d, t, n, currPerm + "T", 0, j + 1, res);
            return res;
        }
    }
}
