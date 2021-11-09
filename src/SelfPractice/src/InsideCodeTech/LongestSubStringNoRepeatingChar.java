package InsideCodeTech;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestSubStringNoRepeatingChar {

    public static void main(String[] args) {

        String str = "abcdbeghef";
        System.out.println(longestSub(str));
        System.out.println(longestSub1(str));
    }

    // TC: n2
    // SC: n
    static int longestSub(String str) {
        if (str.length() < 1)
            return 0;

        Set<Character> set = new HashSet<>();
        int max = 1;
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
            for (int j = i + 1; j < str.length(); j++) {
                if (set.contains(str.charAt(j))) {
                    set.clear();
                    break;
                } else {
                    set.add(str.charAt(j));
                    max = Math.max(max, set.size());
                }
            }
        }
        return max;
    }

    // TC: n
    // SC: 1
    static int longestSub1(String s) {
        int[] indexes = new int[128]; // -> constant space of 128
        Arrays.fill(indexes, -1);
        int start = 0; // to store the starting index of the char
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            // check if we any charatcter is repeated
            if (indexes[(int) s.charAt(i)] >= start)
                //update start index
                start = indexes[(int) s.charAt(i)] + 1;
            // upate char index in array
            indexes[(int) s.charAt(i)] = i;
            // check max value for updated sub string len
            max = Math.max(max, i - start + 1);
        }
        return max;
    }
}
