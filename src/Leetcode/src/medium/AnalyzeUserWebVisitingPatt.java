package medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalyzeUserWebVisitingPatt {

    public static void main(String[] args) {

        String[] users = {"joe", "joe", "joe", "james", "james", "james", "james", "mary", "mary", "mary"};
        String[] webs = {"home", "about", "career", "home", "cart", "maps", "home", "home", "about", "career"};
        int[] times = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    }

    // TODO : solve it ..
    static List<String> pattern(String[] users, String[] webs, int[] times) {

        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < times.length; i++) {

//            map.put(users[i], map.get(users[i]).add(webs[i]));
        }
        return null;
    }


}
