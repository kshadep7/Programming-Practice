/*
 * count all the pairs with indices i<=j whose sum is a power of 2.
 * */
public class CountAllPairs {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(countAllPairs(arr));
    }

    static int countAllPairs(int[] arr) {

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (isPairPowerOftwo(arr[i] + arr[j])) {
                    System.out.println(arr[i] + arr[j]);
                    count++;
                }
            }
        }
        return count;
    }

    static boolean isPairPowerOftwo(int x) {
        return (x != 0) && ((x & (x - 1)) == 0);
    }

    // TODO: Try another approch better than n2
/*
    static int count(int[] arr) {

    }
*/
}
