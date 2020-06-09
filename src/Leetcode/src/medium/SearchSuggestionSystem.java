package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class SearchSuggestionSystem {

    public static void main(String[] args) {
        String[] pro = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String word = "mouse";
//        suggestedProducts(pro, word);


    }

    static List<List<String>> suggestedProducts(String[] products, String word) {

        TreeMap<String, Integer> map = new TreeMap<>();
        Arrays.sort(products); // nlogn
        List<String> productsList = new ArrayList<>(Arrays.asList(products));

        for (int i = 0; i < products.length; i++) { // n
            map.put(products[i], i);
        }

        System.out.println(map);
        List<List<String>> res = new ArrayList<>();
        String key = "";
        for (char c : word.toCharArray()) { // m --> word length
            key += c;
            String ceiling = map.ceilingKey(key);
            String floor = map.floorKey(key + "~");
            if (ceiling == null || floor == null) break;
            res.add(productsList.subList(map.get(ceiling), Math.min(map.get(ceiling) + 3, map.get(floor) + 1)));
        }

        while (res.size() < word.length()) res.add(new ArrayList<>());

        return res;

    }
}
