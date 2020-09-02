public class CountSubSegments {

    /*
        Find no of counts of 3 contininuos sub arrays where sum(1st) <= sum(2nd) <= sum(3rd) 
    */

    /*
     * approach 1:
     * using 3 loops -> n3
     *
     * approach 2:
     * using 2 loops
     * idea is to calculate total sum of array and subtract sum1 and sum2 from it to get sum3
     * TC : n2 + n -> better than n3
     * */

    private static final int MAX = Integer.MAX_VALUE;
    private static final int MIN = Integer.MIN_VALUE;

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 5, 0};
        int[] arr1 = {1, 1, 1};

        System.out.println(count(arr));
    }

    static int count(int[] arr) {
        int count = 0;
        int sum1 = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            sum1 += arr[i];
            int sum2 = 0;
            for (int j = i + 1; j < arr.length - 1; j++) {
                sum2 += arr[j];
                int sum3 = 0;
                // this loop can be removed -> see apporach 2
                for (int k = j + 1; k < arr.length; k++) {
                    sum3 += arr[k];
                }
                if (sum1 <= sum2 && sum2 <= sum3)
                    count++;
            }
        }
        return count;
    }

    // TODO: look for edge cases
    static int count2(int[] arr) {
        int total = findTotal(arr);
        int count = 0;
        int sum1 = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            sum1 += arr[i];
            int sum2 = 0;
            for (int j = i + 1; j < arr.length - 1; j++) {
                sum2 += arr[j];
                if (sum1 <= sum2 && sum2 <= (total - sum1 - sum2))
                    count++;
            }
        }
        return count;
    }

    private static int findTotal(int[] arr) {
        int total = 0;
        for (int i : arr)
            total += i;
        return total;
    }
}
