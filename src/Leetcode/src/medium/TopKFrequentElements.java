package medium;

import java.util.*;

public class TopKFrequentElements {

    public static void main(String[] args) {

        int[] arr = {1, 1, 1, 2, 2, 3};

        System.out.println(topKFrequent1(arr, 2));

    }

    // NlogK --> average case
    // NlogN --> worst case when k = n
    public static List<Integer> topKFrequent(int[] nums, int k) {

        if (nums == null || nums.length == 0)
            return new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        for (int key : map.keySet()) {
            minHeap.offer(key);
            if (minHeap.size() > k)
                minHeap.poll();
        }
        List<Integer> out = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            out.add(minHeap.poll());
        }

        return out;
    }

    // O(N) approach
    public static List<Integer> topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        // corner case: if there is only one number in nums, we need the bucket has index 1.
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int n : map.keySet()) {
            int freq = map.get(n);
            if (bucket[freq] == null)
                bucket[freq] = new LinkedList<>();
            bucket[freq].add(n);
        }

        List<Integer> res = new LinkedList<>();
        for (int i = bucket.length - 1; i > 0 && k > 0; --i) {
            if (bucket[i] != null) {
                List<Integer> list = bucket[i];
                res.addAll(list);
                k -= list.size();
            }
        }

        return res;
    }

}
