package medium;

public class ContainingMostWater {

    public static void main(String[] args) {
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] arr1 = {1, 2, 1, 4, 0, 1};
        System.out.println(maxArea1(arr));
    }

    // n2
    static int maxArea(int[] heights) {

        int max = 0;
        for (int i = 0; i < heights.length - 1; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                int newArea = Math.min(heights[i], heights[j]) * (j - i);
                max = Math.max(max, newArea);
            }
        }
        return max;
    }

    // two pointer apporach
    //n
    static int maxArea1(int[] arr) {
        int max = 0;
        int lo = 0, hi = arr.length - 1;

        while (lo < hi) {
            int newArea = Math.min(arr[lo], arr[hi]) * (hi - lo);
            max = Math.max(newArea, max);
            if (arr[lo] < arr[hi])
                lo++;
            else
                hi--;
        }
        return max;
    }
}
