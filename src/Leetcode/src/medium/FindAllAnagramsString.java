package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsString {
    public static void main(String[] args) {

        String s = "cbaebabacd";
        String p = "abc";

        System.out.println(findAnagrams(s, p));

    }

    private static List<Integer> findAnagrams(String s, String p) {

        List<Integer> out = new ArrayList<>();
        Map<Character, Integer> pMap = new HashMap<>();
        Map<Character, Integer> cMap = new HashMap<>();

        int slen = s.length();
        int plen = p.length();
        // put all char in p map
        for (char c : p.toCharArray()) {
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < slen; i++) {
            // add char by char in c map
            char ch = s.charAt(i);
            cMap.put(ch, cMap.getOrDefault(ch, 0) + 1);

            if (i >= plen) {
                char c = s.charAt(i - plen);
                if (cMap.get(c) == 1)
                    cMap.remove(c);
                else {
                    cMap.put(c, cMap.get(c) - 1);
                }
            }

            if (pMap.equals(cMap)) {
                out.add(i - plen + 1);
            }

        }
        return out;
    }
}
