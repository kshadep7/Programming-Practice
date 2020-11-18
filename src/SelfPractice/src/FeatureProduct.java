import java.util.*;

public class FeatureProduct {

    public static void main(String[] args) {

    }

    public String featProduct(String[] products) {

        Map<String, Integer> map = new HashMap<>();
        int maxCount = 0;
        for (String p : products) {
            map.put(p, map.get(p) == null ? 1 : map.get(p) + 1);
            maxCount = Math.max(maxCount, map.get(p));
        }

        List<String> ls = new ArrayList<>();
        for (String key : map.keySet()) {
            if (map.get(key) == maxCount) {
                ls.add(key);
            }
        }
        ls.sort(Collections.reverseOrder());
        return ls.get(0);
    }
}
