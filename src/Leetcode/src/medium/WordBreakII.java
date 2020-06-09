package medium;

import java.util.*;

public class WordBreakII {
    static HashMap<String, List<String>> map = new HashMap<>();

    public static void main(String[] args) {
        String s = "pineapplepenapple";
        List<String> dict = new ArrayList<>(Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"));
        System.out.println(wordBreak(s, dict));

    }

    /*
        s = "pineapplepenapple"
        wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]

        out:
            "pine apple pen apple",
            "pineapple pen apple",
            "pine applepen apple"

    */
    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        if (map.containsKey(s)) {
            return map.get(s);
        }
        if (wordDict.contains(s)) {
            res.add(s);
        }
        for (int i = 1; i < s.length(); i++) {
            String t = s.substring(i);
            if (wordDict.contains(t)) {
                List<String> temp = wordBreak(s.substring(0, i), wordDict);
                if (temp.size() != 0) {
                    for (int j = 0; j < temp.size(); j++) {
                        res.add(temp.get(j) + " " + t);
                    }
                }
            }
        }
        map.put(s, res);
        return res;
    }

    static List<String> wordBreak1(String s, List<String> dict) {
        Map<String, List<String>> cache = new HashMap<>();

        return helper(s, dict, cache, 0);
    }

    // TODO : try to solve it ..
    private static List<String> helper(String s, List<String> dict, Map<String, List<String>> cache, int start) {
        List<String> res = new ArrayList<>();
        if (s.isEmpty() || s.length() == 0)
            return res;

        if (cache.containsKey(s))
            return cache.get(s);

        //        s = "pineapplepenapple"
//                wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
        for (String word : dict) {
            String sub = s.substring(start);
            if (sub.startsWith(word)) {
                String sentence = word + " " + helper(s, dict, cache, start + word.length());

            }
        }
        map.put(s, res);
        return res;
    }

}
