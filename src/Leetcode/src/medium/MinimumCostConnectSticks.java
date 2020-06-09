package medium;

import java.util.PriorityQueue;

public class MinimumCostConnectSticks {

    public static void main(String[] args) {

//        int[] arr = {1, 8, 3, 5};
        int[] arr = {2, 4, 3};
        System.out.println(minCost(arr));
    }

    static int minCost(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;

        if (arr.length == 1)
            return arr[0];

        int sum = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i : arr) {
            minHeap.add(i);
        }

        while (!minHeap.isEmpty()) {
            int a = minHeap.poll();
            int b = minHeap.poll();
            sum += (a + b);
            minHeap.add(a + b);
            if (minHeap.size() == 1)
                break;
        }

        return sum;
    }
}
