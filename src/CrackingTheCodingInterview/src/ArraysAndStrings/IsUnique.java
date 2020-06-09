package ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class IsUnique {

    public static void main(String[] args) {

    }
    public static boolean isUnique(String s) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            String str = Character.toString(s.charAt(i));
            if (!map.containsKey(str)) {
                map.put(str, 1);
            } else {
                map.put(str, map.get(str) + 1);
            }
        }

        System.out.println(map.toString());
        for (String c : map.keySet()) {
            if (map.get(c) > 1)
                return false;
        }
        return true;
    }

    public static boolean isUnique1(String str) { // using ASCII character set approach
        boolean[] charset = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            if (charset[str.charAt(i)]) {
                return false;
            }
            charset[str.charAt(i)] = true;
        }
        return true;
    }

}
