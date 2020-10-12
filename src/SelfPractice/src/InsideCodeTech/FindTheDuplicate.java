package InsideCodeTech;

import java.util.HashSet;
import java.util.Set;

public class FindTheDuplicate {

    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 2, 1, 6, 3};
        int[] arr1 = {4, 2, 1, 3, 1};
        System.out.println(find1(arr1));
    }

    //TC : n
    //SC: n
    static int find(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            if (set.contains(i))
                return i;
            else
                set.add(i);
        }

        return Integer.MAX_VALUE;
    }

    //using tortoise and hare algo
    // TC: n
    // SC: 1
    static int find1(int[] arr) {
        int tortoise = arr[0];
        int hare = arr[arr[0]];

        while (tortoise != hare) {
            tortoise = arr[tortoise];
            hare = arr[arr[hare]];
        }
        tortoise = 0;
        while (tortoise != hare) {
            tortoise = arr[tortoise];
            hare = arr[hare];
        }
        return tortoise;
    }
}
