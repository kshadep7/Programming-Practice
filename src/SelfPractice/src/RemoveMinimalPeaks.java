import java.util.*;


/*
 * removing min peak values from list
 * eg - [2 7 (8) 5 1 (6) 3 (9) 4]
 * 1. peak values -> 8 6 9
 * 2. remove min peak value from main list
 * follow 1 and 2 untill all items are removed and store in other list (maintain the order of removal)
 *
 * */
public class RemoveMinimalPeaks {

    public static void main(String[] args) {
        int[] arr = {2, 7, 8, 5, 1, 6, 3, 9, 4};

//        removePeaks(arr);
        System.out.println(Arrays.toString(removePeaksBF(arr)));
    }

    // brute force
    /*
     * find min peak and remove it from list
     * and add it to the ans list
     *
     * TC: n3
     * */

    private static int[] removePeaksBF(int[] arr) {
        int n = arr.length;
        List<Integer> ls = new ArrayList<>();
        int[] res = new int[n];
        for (int i : arr)
            ls.add(i);

        for (int i = 0; i < n; i++) {       // N
            int min = Integer.MAX_VALUE;
            int index = -1;
            int size = ls.size();
            // finding min peak
            for (int j = 0; j < size; j++) {        //N
                if (j == 0 && j + 1 < size) {
                    if (ls.get(j) > ls.get(j + 1) && ls.get(j) < min) {
                        min = ls.get(j);
                        index = j;
                    }
                } else if (j == ls.size() - 1 && j - 1 >= 0) {
                    if (ls.get(j) > ls.get(j - 1) && ls.get(j) < min) {
                        min = ls.get(j);
                        index = j;
                    }
                } else if (size == 1) {
                    min = ls.get(j);
                    index = j;
                } else {
                    if (ls.get(j - 1) < ls.get(j) && ls.get(j) > ls.get(j + 1) && ls.get(j) < min) {
                        min = ls.get(j);
                        index = j;
                    }
                }
            }
            ls.remove(index);       // N
            res[i] = min;
        }

        return res;
    }

    /*
     * approach:
     * 1. traverse through list and find all peak values and store index in min heap
     * 2. remove top from heap -> remove from list using index
     * 3. repeat 1 until heap is empty
     * */

    static List<Integer> removePeaks(List<Integer> ls) {
        List<Integer> res = new ArrayList<>();
        List<Integer> ll = new LinkedList<>(ls);
        // min heap
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        //get all peaks and add them to heap
        for (int i = 0; i < ll.size(); i++) {
            if (i == 0) {
                if (ll.get(i) > ll.get(i + 1)) {
                    heap.add(new int[]{ll.get(i), i});
                }
            } else if (i == ll.size() - 1) {
                if (ll.get(i) > ll.get(i - 1)) {
                    heap.add(new int[]{ll.get(i), i});
                }
            } else {
                if (ll.get(i - 1) < ll.get(i) && ll.get(i) > ll.get(i + 1))
                    heap.add(new int[]{ll.get(i), i});
            }
        }
        while (!heap.isEmpty()) {
            int[] arr = heap.poll();
            int index = arr[1];
            int minPeakValue = arr[0];
            res.add(minPeakValue);
            checkNeighbors(ll.listIterator(index).previous());
            checkNeighbors(ll.listIterator(index).next());

        }

        return null;
    }

    private static void checkNeighbors(int preOrNext) {

    }

}
