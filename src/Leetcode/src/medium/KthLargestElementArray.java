package medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementArray {

    public static void main(String[] args) {
        int[] arr = {4, 2, 6, 5, 8, 4, 3};
//        System.out.println(findKthLargest(arr, 3));
        System.out.println(find(arr, 2));
    }

    //using min heap of size k
    // TC: nlogk with O(k) SC
    static int find(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : arr) {
            pq.add(i);
            if (pq.size() > k)
                pq.poll();
        }
        return pq.poll();
    }


    // using sorting: brute force
    //TC --> nlogn with O(1) SC
    static int findKthLargest(int[] arr, int k) {
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int len = arr.length;
        return arr[len - k];
    }
}
