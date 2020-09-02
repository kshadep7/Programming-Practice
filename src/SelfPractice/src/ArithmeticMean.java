public class ArithmeticMean {

    public static void main(String[] args) {

        int[] arr = {2, 4, 6, 6, 3};
        System.out.println(countIndices(arr));
        System.out.println(Integer.MAX_VALUE);
    }

    static int countIndices(int[] arr) {

        int res = 0;
        int a = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                if ((arr[i + 1]) == 2 * arr[i])
                    res++;
            } else if (i == arr.length - 1) {
                if ((arr[i - 1]) == 2 * arr[i])
                    res++;
            } else {
                if ((arr[i - 1] + arr[i + 1]) == 2 * arr[i])
                    res++;
            }
        }
        return res;
    }
}
