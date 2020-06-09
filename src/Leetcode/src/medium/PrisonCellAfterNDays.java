package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PrisonCellAfterNDays {

    public static void main(String[] args) {
        int[] cells = {1, 0, 0, 1, 0, 0, 0, 1};
        System.out.println(Arrays.toString(afterDays2(cells, 826)));
    }
/*
    The following table summarizes the state of the prison on each day:
    Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
    Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
    Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
    Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
    Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
    Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
    Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
    Day 7: [0, 0, 1, 1, 0, 0, 0, 0]
*/

    // intuition --> brute force taking a linear approach
    static int[] afterDays(int[] cells, int N) {
        if (N == 0)
            return cells;
        int k = N;
        while (N > 0) {
            System.out.println("Day " + (k - N) + Arrays.toString(cells));
            int[] cells2 = new int[cells.length];
            for (int i = 1; i < cells.length - 1; i++) {
                cells2[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
            }
            cells = cells2;
            N--;
        }
        return cells;
    }

    // optimizing using a hash map
    static int[] afterDays1(int[] cells, int N) {

        if (N == 0)
            return cells;
        Map<String, Integer> seen = new HashMap<>();
        while (N > 0) {
            int[] cells2 = new int[cells.length];
            seen.put(Arrays.toString(cells), N--);
            for (int i = 1; i < cells.length - 1; i++) {
                cells2[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
            }
            cells = cells2;
            if (seen.containsKey(Arrays.toString(cells)))
                N %= seen.get(Arrays.toString(cells)) - N;
        }
        return cells;
    }

    // looping knowing the states repeat after every 14 rounds
    static int[] afterDays2(int[] cells, int N) {
        // idea is to get the remainder from N and 14
        // remainder is the number of times we will change the state of cells
        N = (N - 1) % 14 + 1;
        for (int j = N; j > 0; j--) {
            int[] temp = new int[cells.length];
            for (int i = 1; i < cells.length - 1; i++) {
                temp[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
            }
            cells = temp;
        }
        return cells;
    }
}
