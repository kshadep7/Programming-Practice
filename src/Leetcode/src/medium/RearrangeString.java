package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RearrangeString {

    public static void main(String[] args) {

        String s = "aaaabbc";
//        System.out.println(arrange(s));
        System.out.println(reorganizeString(s));
    }

    static String arrange(String s) {

        // idea is to start building the string using most occurring character
        // i.e greedy approach
        Map<Character, Integer> freq = new HashMap<>();
        // create frequency map
        for (char c : s.toCharArray())
            freq.put(c, freq.getOrDefault(c, 0) + 1);

        // add the map chars to map heap sorted by char freq
        PriorityQueue<Character> heap = new PriorityQueue<>((a, b) -> freq.get(b) - freq.get(a));
        heap.addAll(freq.keySet());

        StringBuilder sb = new StringBuilder();
        while (heap.size() > 1) {
            // get top two char highest freq
            char curr = heap.remove();
            char next = heap.remove();
            // append to sb
            sb.append(curr);
            sb.append(next);
            // reduce count and update map
            freq.put(curr, freq.get(curr) - 1);
            freq.put(next, freq.get(next) - 1);

            //check if char freq is > 0 if yes then add that char to heap again
            if (freq.get(curr) > 0)
                heap.add(curr);
            if (freq.get(next) > 0)
                heap.add(next);

        }
        // id any char is still in heap then check the freq of that char
        // if freq > 1 then return "" if not freq is 1 then just append
        if (!heap.isEmpty()) {
            char last = heap.remove();
            if (freq.get(last) > 1)
                return "not possible";
            sb.append(last);
        }
        return sb.toString();
    }
// TC: O(n) SC: O(1)
    public static String reorganizeString(String S) {
        int[] hash = new int[26];
        for (int i = 0; i < S.length(); i++) {
            hash[S.charAt(i) - 'a']++;
        }
        int max = 0, letter = 0;
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > max) {
                max = hash[i];
                letter = i;
            }
        }
        if (max > (S.length() + 1) / 2) {
            return "";
        }
        char[] res = new char[S.length()];
        int idx = 0;
        while (hash[letter] > 0) {
            res[idx] = (char) (letter + 'a');
            idx += 2;
            hash[letter]--;
        }
        for (int i = 0; i < hash.length; i++) {
            while (hash[i] > 0) {
                if (idx >= res.length) {
                    idx = 1;
                }
                res[idx] = (char) (i + 'a');
                idx += 2;
                hash[i]--;
            }
        }
        return String.valueOf(res);
    }
    // Time O(N): fill hash[] + find the letter + write results into char array
    //Space O(N + 26): result + hash[]
}
