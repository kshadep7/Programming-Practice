package Hard;

import java.util.*;

public class JobSchedulingMaxProfit {

    public static void main(String[] args) {
        int[] start = {1, 2, 4};
        int[] end = {2, 2, 1};
        int[] vol = {1, 2, 3};

        int[] start2 = {1, 2, 3, 3};
        int[] end2 = {3, 4, 5, 6};
        int[] vol2 = {50, 10, 40, 70};

        int[] start1 = {1, 10, 100};
        int[] end1 = {1, 10, 100};
        int[] vol1 = {1, 10, 100};

//        System.out.println(jobScheduling(start, end, vol));
//        System.out.println(jobScheduling(start1, end1, vol1));
        System.out.println(jobScheduling(start2, end2, vol2));

    }

    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }

//        System.out.println(Arrays.deepToString(jobs));
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
//        System.out.println(Arrays.deepToString(jobs));
        TreeMap<Integer, Integer> dp = new TreeMap<>();
        dp.put(0, 0);
        for (int[] job : jobs) {
            int cur = dp.floorEntry(job[0]).getValue() + job[2];
            if (cur > dp.lastEntry().getValue())
                dp.put(job[1], cur);
        }
//        System.out.println(dp);
        return dp.lastEntry().getValue();
    }

    public static int jobScheduling1(int[] startTime, int[] endTime, int[] profit) {
        // sort by endTime
        int[][] items = new int[startTime.length][3];
        for (int i = 0; i < startTime.length; i++) {
            items[i] = new int[]{startTime[i], startTime[i] + endTime[i], profit[i]};
        }
        Arrays.sort(items, (a1, a2) -> a1[1] - a2[1]);
        List<Integer> dpEndTime = new ArrayList<>();
        List<Integer> dpProfit = new ArrayList<>();
        // init value to avoid IndexOutBoundExp
        dpEndTime.add(0);
        dpProfit.add(0);
        for (int[] item : items) {
            int s = item[0], e = item[1], p = item[2];
            // find previous endTime index
            int prevIdx = Collections.binarySearch(dpEndTime, s + 1);
            if (prevIdx < 0) {
                prevIdx = -prevIdx - 1;
            }
            prevIdx--;
            int currProfit = dpProfit.get(prevIdx) + p, maxProfit = dpProfit.get(dpProfit.size() - 1);
            if (currProfit > maxProfit) {
                dpProfit.add(currProfit);
                dpEndTime.add(e);
            }
        }
        return dpProfit.get(dpProfit.size() - 1);
    }

}
