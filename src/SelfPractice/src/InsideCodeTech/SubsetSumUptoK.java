package InsideCodeTech;

import java.util.HashMap;
import java.util.Map;

public class SubsetSumUptoK {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        System.out.println(countSubsets(arr, 0, 0, 4));
        System.out.println(countSubsetsDP(arr, 0, 0, 4, new HashMap<>()));
    }

    // TC: 2^n -> checking all subsets of arr
    // to many repeatative calls. use DP
    static int countSubsets(int[] arr, int sum, int index, int k) {
        if (sum == k) {
            return 1;
        } else if (sum > k || index >= arr.length) {
            return 0;
        } else {
            return countSubsets(arr, sum + arr[index], index + 1, k)
                    + countSubsets(arr, sum, index + 1, k);
        }
    }

    // using index and sum as key reusing count values to stop repeatative calls
    // TC: n*k -> n are indexes and k are sums
    // SC: n*k -> nk keys can be there in map at max
    static int countSubsetsDP(int[] arr, int sum, int index, int k, Map<String, Integer> dp) {
        String key = index + " " + sum;
        if (dp.containsKey(key))
            return dp.get(key);
        else if (sum == k)
            return 1;
        else if (sum > k || index >= arr.length)
            return 0;
        else {
            int res = countSubsetsDP(arr, sum + arr[index], index + 1, k, dp)
                    + countSubsetsDP(arr, sum, index + 1, k, dp);
            dp.put(key, res);
            return res;
        }
    }
}
