package medium;

import java.util.Arrays;

public class TaskScheduler {

    public static void main(String[] args) {

        char[] arr = {'A', 'A', 'A', 'B', 'B', 'B'};
        System.out.println(intervals(arr, 3));

    }

    static int intervals(char[] tasks, int n) {

        int[] taskFreq = new int[26];
        for (char c :
                tasks) {
            taskFreq[c - 'A']++;
        }

        Arrays.sort(taskFreq);

        int max = taskFreq[25] - 1;
        int idleSlots = max * n;

        //filling idle slots with other tasks
        // basically making value of idle slots smaller as the task are getting done
        // respecting the interval value --> n

        for (int i = 24; i >= 0; i--) {
            idleSlots -= Math.min(taskFreq[i], max);
        }

        return idleSlots > 0 ? idleSlots + tasks.length : tasks.length;
    }
}
