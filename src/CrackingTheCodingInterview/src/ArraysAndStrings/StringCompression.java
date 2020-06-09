package ArraysAndStrings;

import java.util.HashMap;

public class StringCompression {

    public static void main(String[] args) {

    }

    public static String stringCompression(String str) {
        // brute force:
        // Put all the chars in hashmap and their freq
        // put together the keys and their respective values into a string and return it
        // (using string builder)
        // Time: O(c+n) -> c: number of characters, n -> builder length (bcoz of
        // .toString())
        // Space: O(n) -> HashMap storing

        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder compressedStr = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            } else {
                map.put(str.charAt(i), 1);
            }
        }
        System.out.println(map.toString());
        for (char c : map.keySet()) {
            compressedStr.append(c);
            compressedStr.append(map.get(c));
        }
        System.out.println("Str length: " + str.length());
        System.out.println("CompressedStr length: " + compressedStr.length());

        return compressedStr.length() > str.length() ? compressedStr.toString() : str;
    }

}
