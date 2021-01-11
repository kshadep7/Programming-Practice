package medium;

import java.util.*;

public class ReconstructItenary {

    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        // ["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]
        // [["JFK","KUL"],["JFK","NRT"],["NRT","JFK"]]
        List<String> ticket = new ArrayList<>(Arrays.asList("JFK", "SFO"));
        List<String> ticket1 = new ArrayList<>(Arrays.asList("JFK", "ATL"));
        List<String> ticket2 = new ArrayList<>(Arrays.asList("SFO", "ATL"));
        List<String> ticket3 = new ArrayList<>(Arrays.asList("ATL", "JKF"));
        List<String> ticket4 = new ArrayList<>(Arrays.asList("ATL", "SFO"));

        List<String> ticket5 = new ArrayList<>(Arrays.asList("JFK", "KUL"));
        List<String> ticket6 = new ArrayList<>(Arrays.asList("JFK", "NRT"));
        List<String> ticket7 = new ArrayList<>(Arrays.asList("NRT", "JFK"));


//        tickets.add(ticket);
//        tickets.add(ticket1);
//        tickets.add(ticket2);
//        tickets.add(ticket3);
//        tickets.add(ticket4);

        tickets.add(ticket5);
        tickets.add(ticket6);
        tickets.add(ticket7);

        System.out.println(findItinerary(tickets));

    }

    public static List<String> findItinerary(List<List<String>> tickets) {

        // using a map creating a graph
        // travering the map using keys

        Map<String, PriorityQueue<String>> map = new HashMap<>();
        createGraph(map, tickets);      // n

        LinkedList<String> res = new LinkedList<>();
        String origin = "JFK";
//        res.add(origin);
        dfs(map, res, origin);
        return res;
    }

    public static void dfs(Map<String, PriorityQueue<String>> map, LinkedList<String> st, String from) {
        if (map.containsKey(from)) {
            PriorityQueue<String> que = map.get(from);
            while (que != null && !que.isEmpty()) {
                String to = que.poll();
                dfs(map, st, to);
            }
        }
        st.addFirst(from);
    }

    public static void createGraph(Map<String, PriorityQueue<String>> map, List<List<String>> tickets) {
        for (List<String> tic : tickets) {

            String from = tic.get(0);
            String to = tic.get(1);

            if (!map.containsKey(from))
                map.put(from, new PriorityQueue<>());

            map.get(from).add(to);
        }

        System.out.println(map);
    }
}
