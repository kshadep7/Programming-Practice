import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};    // k = 3
        int[] arr1 = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};   // k = 4

        System.out.println(findAllMax(arr1, 4));
        System.out.println(findAllMaxHeap(arr1, 4));
    }

    /**
     * Given an array and an integer K, find the maximum for each and every
     * contiguous subarray of size k.
     */


    // the idea is quite simple
    // using sliding window technique -> interate thru the arr
    // using inner loop find max in that subarray
    // TC: nk, SC: 1
    static List<Integer> findAllMax(int[] arr, int k) {

        if (arr.length < k)
            return new ArrayList<>();

        int n = arr.length;
        int j = 0;
        int max;
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i <= n - k; i++) {  // n
            max = arr[i];

            for (int l = i; l < k + i; l++) {       // k
                max = Math.max(max, arr[l]);
            }
            res.add(max);
        }
        return res;
    }

    // inner loop can be optimized using max heap
    // to find the max element in current subarr
    // TC: nlogk --> inserting and removing takes logk , SC: k -> heap
    static List<Integer> findAllMaxHeap(int[] arr, int k) {
        if (arr.length < k)
            return new ArrayList<>();

        int n = arr.length;
        int i = 0;

        List<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        // first add first k elements
        for (; i < k; i++) {
            heap.add(arr[i]);
        }

        // and add first max value
        res.add(heap.peek());
        // remove first element
        heap.remove(arr[0]);

        // add rest of the elements and repeat the process.
        for (; i < n; i++) {
            heap.add(arr[i]);
            res.add(heap.peek());
            heap.remove(i - k + 1);
        }
        return res;
    }
}
