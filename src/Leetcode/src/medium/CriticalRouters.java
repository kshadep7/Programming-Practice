package medium;

import java.util.*;

public class CriticalRouters {
    static int time = 0;


    public static void main(String[] args) {

        int[][] links = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 5}, {5, 6}, {3, 4}};
//        int[][] links = {{1, 2}, {1, 3}, {2, 3}, {3, 4}, {3, 6}, {4, 5}, {6, 7}, {6, 9}, {7, 8}, {8, 9}};
//        int[][] links = {{1, 2}, {1, 3}, {3, 4}, {1, 4}, {4, 5}};
//        int[][] links = {{1, 2}, {1, 3}, {2, 3}, {2, 4}, {2, 5}, {4, 6}, {5, 6}};
        List<List<Integer>> links1 = new ArrayList<>();
        // creating nested lists
        for (int[] link : links) {
            List<Integer> list = new ArrayList<>();
            for (int i : link)
                list.add(i);
            links1.add(list);
        }

        System.out.println(getCriticalNodes(links1, 7, 6));
//        System.out.println(links1);
    }

    private static List<Integer> getCriticalNodes(List<List<Integer>> links, int numLinks, int numRouters) {
        time = 0;
        numRouters += 1; // This is where I made a mistake (which I believe it works now)
        // index are from 0 to n-1
        // so inside the map key "0" is also present regardless of any router whose is ID is 0 in the input links
        // this won't affect the algorithm as 0 won't be connected to any other router (if 0 is not present in input)
        // so including all the routers IDs is important for this algorithm to work.
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < numRouters; i++) {
            map.put(i, new HashSet<>());
        }
        // converting nested list to 2d array
//        int[][] arr = new int[links.size()][];
//
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = new int[links.get(i).size()];
//        }
//
//        for (int i = 0; i < links.size(); i++) {
//            for (int j = 0; j < links.get(i).size(); j++) {
//                arr[i][j] = links.get(i).get(j);
//            }
//        }
        // adding adjacent routers to their respective routers

        for (List<Integer> link : links) {
            map.get(link.get(0)).add(link.get(1));
            map.get(link.get(1)).add(link.get(0));
        }

//        for (int[] link : arr) {
//            map.get(link[0]).add(link[1]);
//            map.get(link[1]).add(link[0]);
//        }
        Set<Integer> ansSet = new HashSet<>();
        int[] low = new int[numRouters];
        int[] disc = new int[numRouters];
        int[] parent = new int[numRouters];
        Arrays.fill(disc, -1);
        Arrays.fill(parent, -1);
        for (int i = 0; i < numRouters; i++) {
            if (disc[i] == -1)
                dfs(map, low, disc, parent, i, ansSet);
        }
        return new ArrayList<>(ansSet);
    }


    private static void dfs(Map<Integer, Set<Integer>> map, int[] lo, int[] disc, int[] parent, int cur, Set<Integer> res) {
        int children = 0;
        disc[cur] = lo[cur] = ++time;
        for (int i : map.get(cur)) {
            if (disc[i] == -1) {
                children++;
                parent[i] = cur;
                dfs(map, lo, disc, parent, i, res);
                lo[cur] = Math.min(lo[cur], lo[i]);
                if ((parent[cur] == -1 && children > 1) || (parent[cur] != -1 && lo[i] >= disc[cur]))
                    res.add(cur);
            } else if (i != parent[cur])
                lo[cur] = Math.min(lo[cur], disc[i]);
        }
    }

}
