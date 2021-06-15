package easy;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacter {

    public static void main(String[] args) {
        String s = "leelcode";
        System.out.println(firstUnique(s));
        System.out.println(firstUni1(s));
    }

    // TC: n, SC: n
    static int firstUnique(String s) {
        if (s == null || s.length() == 0)
            return -1;

        // freq map
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // check for first char with count 1
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) == 1)
                return i;
        }
        return -1;
    }

    static int firstUni1(String s) {
        int ans = Integer.MAX_VALUE;
        int left = 0;

        for (char i = 'a'; i <= 'z'; i++) {
            left = s.indexOf(i);
            if (left != -1 && s.lastIndexOf(i) == left)
                ans = Math.min(ans, left);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
