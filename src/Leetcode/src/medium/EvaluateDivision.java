package medium;

import java.util.*;

public class EvaluateDivision {

    public static void main(String[] args) {

    }

    static double[] evaluate(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, List<String[]>> map = new HashMap<>();
        int i = 0;
        // creating graph
        for (List<String> eq : equations) {
            String src = eq.get(0);
            String des = eq.get(1);

            if (!map.containsKey(src))
                map.put(src, new ArrayList<>());
            if (!map.containsKey(des))
                map.put(des, new ArrayList<>());

            map.get(src).add(new String[]{des, Double.toString(values[i])});
            map.get(des).add(new String[]{src, (Double.toString(1.0 / values[i]))});
            i++;
        }

        // finding queries ans
        i = 0;
        double[] res = new double[queries.size()];
        boolean[] visited = new boolean[queries.size()];
        for (List<String> q : queries) {
            String src = q.get(0);
            String des = q.get(1);
            Set<String> set = new HashSet<>();
            set.add(src);
            res[i++] = helper(map, src, des, visited);
        }
        return res;
    }

    private static double helper(Map<String, List<String[]>> map, String src, String des, boolean[] visited) {
        if (!map.containsKey(src) || !map.containsKey(des))
            return -1;
        else if (src.equals(des)) {
            return 1;
        } else if (map.containsKey(src)) {
            List<String[]> curr = map.get(src);
            for (String[] arr : curr) {
                if (!map.containsKey(arr[0]))
                    continue;
                return Integer.parseInt(arr[1]) * helper(map, arr[0], des, visited);
            }
        }
        return -1.0;
    }
}
