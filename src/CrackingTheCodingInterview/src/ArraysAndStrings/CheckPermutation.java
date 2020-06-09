package ArraysAndStrings;

import java.util.HashMap;

public class CheckPermutation {
    public static void main(String[] args) {

    }

    public static boolean checkPermuation(String str1, String str2) {
        // TODO: adding one string in hashMap i.e letters as keys and their frequency as
        // their respectively values.
        // then checking the other string character by character in that map
        // if the map contains the letters - reduce the freq by 1
        // if freq of any letter is -1 or map contains no letter return false

        if (str1.length() != str2.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            if (map.containsKey(str1.charAt(i))) {
                map.put(str1.charAt(i), map.get(str1.charAt(i)) + 1);
            } else {
                map.put(str1.charAt(i), 1);
            }
        }
        for (int i = 0; i < str2.length(); i++) {
            if (map.containsKey(str2.charAt(i))) {
                map.put(str2.charAt(i), map.get(str2.charAt(i)) - 1);
                if (map.get(str2.charAt(i)) < 0) {
                    return false;
                }
            } else {
                return false;
            }
        }

        // System.out.println(map.toString());
        return true;
    }

}
