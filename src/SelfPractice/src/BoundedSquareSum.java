public class BoundedSquareSum {

    public static void main(String[] args) {

        int[] a = {3, -1, 9};
        int[] b = {100, 5, -2};

        System.out.println(boundedSquareSum(a, b, 7, 99));
    }

    static int boundedSquareSum(int[] a, int[] b, int low, int high) {

        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                int sqrauredSum = a[i] * a[i] + b[j] * b[j];
                if (low <= sqrauredSum && sqrauredSum <= high)
                    count++;
            }
        }
        return count;
    }

}
