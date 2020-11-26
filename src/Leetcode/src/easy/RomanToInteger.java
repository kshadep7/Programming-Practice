package easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {
        String s = "MCMXCIV";
        String s1 = "III";

//        System.out.println(romanToInt(s1));
        System.out.println(Integer.MAX_VALUE);
    }

    public static int romanToInt(String s) {
        // making a map with values of all possible combinations
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);

        // by taking one char and two chars
        int res = 0;
        int index = 0;
        while (index < s.length()) {
            String oneChar = "" + s.charAt(index);
            String twoChars = index + 1 >= s.length() ? "" : "" + s.charAt(index) + s.charAt(index + 1);

            //getting values
            int oneCharValue = map.getOrDefault(oneChar, 0);
            int twoCharValue = map.getOrDefault(twoChars, 0);

            if (oneCharValue > twoCharValue) {
                res += oneCharValue;
                index += 1;
            } else {
                res += twoCharValue;
                index += 2;
            }

        }
        return res;
//        helper(s, 0, res, map);
    }

    // TODO: try to solve recurseively
    public static int helper(String s, int index, int res, Map<String, Integer> map) {
        if (index >= s.length())
            return res;

        // creating strings
        String oneChar = "" + s.charAt(index);
        String twoChars = "" + s.charAt(index) + s.charAt(index + 1);

        //getting values
        int oneCharValue = map.getOrDefault(oneChar, 0);
        int twoCharValue = map.getOrDefault(twoChars, 0);

        if (oneCharValue > twoCharValue) {
            res += oneCharValue;
            helper(s, index + 1, res, map);
        } else {
            res += twoCharValue;
            helper(s, index + 2, res, map);
        }
        return res;
    }
}

