package easy;

import java.util.*;

public class MostCommonWord {

    public static void main(String[] args) {

        String s = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};

        System.out.println(mostCommonWord(s, banned));

    }

    public static String mostCommonWord(String paragraph, String[] banned) {

        String para = paragraph.toLowerCase();
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> map = new HashMap<>();
        String[] words = para.split("\\W+");
        System.out.println(Arrays.toString(words));
        for (String word : words) {
            if (!bannedSet.contains(word)) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        System.out.println(map.toString());
        PriorityQueue<String> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
//        PriorityQueue<String> minHeap = new PriorityQueue<>();

        maxHeap.addAll(map.keySet());
//        for (String word : map.keySet()) {
//            minHeap.add(word);
//            if (minHeap.size() > 1)
//                minHeap.poll();
//        }

        System.out.println(maxHeap.toString());
//        if (!minHeap.isEmpty())
//            return minHeap.poll();

        if (!maxHeap.isEmpty())
            return maxHeap.poll();

        return "";
    }

}
