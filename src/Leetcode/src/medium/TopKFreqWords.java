package medium;

import java.util.*;

public class TopKFreqWords {
    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
//        String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};

        System.out.println(topKFrequent(words, 2));
    }

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        System.out.println(map.toString());
        PriorityQueue<String> minHeap = new PriorityQueue<>((a, b) ->
                map.get(a).intValue() == (map.get(b)).intValue() ? b.compareTo(a) : map.get(a) - map.get(b));

//        maxHeap.addAll(map.keySet());

        List<String> out = new ArrayList<>();
        for (String key : map.keySet()) {
            minHeap.add(key);
            if (minHeap.size() > k)
                minHeap.poll();
        }

        while (!minHeap.isEmpty()) {
            out.add(minHeap.remove());
        }
        Collections.reverse(out);
        return out;
    }


}
