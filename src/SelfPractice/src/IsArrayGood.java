import java.util.HashMap;
import java.util.Map;

public class IsArrayGood {
    /*A sequence is "Good" if its every consecutive subarray (slice) (including the full array)
    contains at least one unique element,
     i.e. an element such that no other element of that subsequence has the same value.
    Given a sequence of integers, decide whether it is "Good".

Examples:
[1, 2, 3] "Good"
[1, 2, 1] "Good"
[1, 2, 1, 2] "Bad"
[2, 2] "Bad"
*/
    public static void main(String[] args) {

        int[] arr = {1, 2, 3};
        int[] arr1 = {1, 2, 1, 2};
        int[] arr3 = {1, 2, 1};
        int[] arr4 = {2, 2};

        System.out.println(isGood(arr4));
    }

    // [1,2,1,2]
    //  0 1 2 3
    public static boolean isGood(int[] arr) {
        if (arr.length == 0 || arr == null)
            return false;
        Map<Integer, Integer> map;
        a:
        for (int i = 0; i < arr.length; i++) {
            map = new HashMap<>();

            for (int j = i; j < arr.length; j++) {
                map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
            }
            for (int key : map.keySet()) {
                if (map.get(key) == 1) {
                    continue a;
                }
            }
            return false;
        }
        return true;
    }
}

