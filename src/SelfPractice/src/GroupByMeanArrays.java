import java.util.*;

public class GroupByMeanArrays {

    public static void main(String[] args) {
        int[][] test = new int[][]{
                {3, 3, 4, 2},
                {4, 4},
                {4, 0, 3, 3},
                {2, 3},
                {3, 3, 3}};

        System.out.println(Arrays.deepToString(solution(test)));
    }

    public static int[][] solution(int[][] a) {
        Map<Double, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            int[] arr = a[i];
            double sum = 0;
            for (int x : arr) sum += x;
            sum /= arr.length;
            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }
        return map.values().stream().map(l -> l.stream().mapToInt(x -> x).toArray()).sorted((x, y) -> x[0] - y[0]).toArray(int[][]::new);
    }
}
