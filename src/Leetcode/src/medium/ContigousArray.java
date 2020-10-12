package medium;

import java.util.HashMap;
import java.util.Map;

public class ContigousArray {

    public static void main(String[] args) {

        int[] arr = {1, 0, 0, 1, 0, 1, 1, 0};
        System.out.println(findMaxLength(arr));
    }

    static public int findMaxLength(int[] nums) {
        int cnt = 0;
        int maxLen = 0;
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0)
                cnt--;
            else
                cnt++;

            if (map.containsKey(cnt)) {
                int pre = map.get(cnt);
                maxLen = Math.max(maxLen, i - pre);
            } else {
                map.put(cnt, i);
            }
        }
        return maxLen;
    }
}
