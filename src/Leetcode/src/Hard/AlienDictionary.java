package Hard;

import java.util.*;

public class AlienDictionary {
    /*
    *     [
            "wrt",
            "wrf",
            "er",
            "ett",
            "rftt"
        ]
    */
    public static void main(String[] args) {

        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
//        String[] words = {"abc", "ab"};
        System.out.println(order(words));
    }

    static String order(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        int[] inDegree = new int[26];
        boolean flag = false;
        buildGraph(graph, words, inDegree);
        return bfs(graph, inDegree);
    }

    private static String bfs(Map<Character, Set<Character>> graph, int[] inDegree) {

        StringBuilder sb = new StringBuilder();
        int totalChars = graph.size();
        Queue<Character> que = new LinkedList<>();
        // right now the map looks like this:
        /*
         * w : e
         * r : t
         * t : f
         * f :
         * e : r
         *
         * */
        // inDegree -> e f r t w
        // count ->    1 1 1 1 0

        //taking the 0 count first
        // TODO: for this test case inDegree value is 0
        for (char c : graph.keySet()) {
            if (inDegree[c - 'a'] == 0) {
                sb.append(c);
                que.offer(c);
            }
        }
        // check for neighbors
        while (!que.isEmpty()) {
            char curr = que.poll();

            if (graph.get(curr) == null || graph.get(curr).size() == 0)
                continue;

            for (char neighbor : graph.get(curr)) {
                inDegree[neighbor - 'a']--;
                if (inDegree[neighbor - 'a'] == 0) {
                    sb.append(neighbor);
                    que.offer(neighbor);
                }
            }
        }
        return sb.length() == totalChars ? sb.toString() : "";

    }

    /*
    [
        "wrt",
        "wrf",
        "er",
        "ett",
        "rftt"
    ]

    **/
    private static void buildGraph(Map<Character, Set<Character>> graph, String[] words, int[] inDegree) {

        // putting all chars or nodes in the map with new set for each node
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
            }
        }

        // get the order of the chars and put into the set
        // t is before f so add f in t's set in the map

        for (int i = 1; i < words.length; i++) {

            String first = words[i - 1];
            String second = words[i];
            int len = Math.min(first.length(), second.length());
            for (int j = 0; j < len; j++) {
                if (first.charAt(j) != second.charAt(j)) {
                    char before = first.charAt(j);
                    char after = second.charAt(j);

                    if (!graph.get(before).contains(after)) {
                        graph.get(before).add(after);
                        inDegree[after - 'a']++;
                    }
                    break;
                }
                if (j + 1 == len && first.length() > second.length()) {
                    graph.clear();
                    return;
                }
            }
        }
    }
}
