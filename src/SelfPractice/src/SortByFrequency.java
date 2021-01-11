import java.util.*;

public class SortByFrequency {

    public static void main(String[] args) {
        List<String> input = new ArrayList<>(Arrays.asList("I", "am", "so", "happy", "so", "happy", "that", "happy"));
        sortByFreq(input);
    }

    // TC : nlong
    // SC : n -> map + heap
    static List<String> sortByFreq(List<String> input) {

        if (input.size() < 2)
            return input;

        int n = input.size();

        HashMap<String, int[]> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String key = input.get(i);
            if (!map.containsKey(key)) {
                map.put(key, new int[]{1, i});
            } else {
                map.get(key)[0]++;
//                map.put(key, arr);
            }
        }
//        System.out.println(map);

        PriorityQueue<Map.Entry<String, int[]>> heap = new PriorityQueue<>((o1, o2) -> {
            int[] values1 = o1.getValue();
            int[] values2 = o2.getValue();

            return values1[0] == values2[0] ? values1[1] - values2[1] : values2[0] - values1[0];
        });

        heap.addAll(map.entrySet());    // nlogn
        List<String> res = new ArrayList<>();
        while (!heap.isEmpty()) {       //nlogn
            res.add(heap.remove().getKey());
        }
        System.out.println(res);
        return res;
    }
}
