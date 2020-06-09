package ArraysAndStrings;

import java.util.HashMap;

public class PermutationPalindrome {

    public static void main(String[] args) {

    }

    public static boolean permutationPalindrome(String str) {
        // 1. put all the characters and their freq in a hashtable
        // 2. check if all the chars are even expect one ? true : false
        int count = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isLetter(c))
                continue;

            if (map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            } else {
                map.put(str.charAt(i), 1);
//				count++;
            }
        }
        System.out.println(map.toString());
        // boolean bool = false;
        for (char s : map.keySet()) {
            if (map.get(s) % 2 == 1) {
                count++;
            } else {
                count--;
            }
        }
        return count <= 1;

        // for(int i = 0; i<=count; i++ ) {
        // tab.keys().
        // }
    }

}
