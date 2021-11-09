public class PeakFinding {

    public static void main(String[] args) {

        int[] arr = {4, 5, 8, 3};
        int[] arr1 = {1, 3, 4, 7, 8};
        System.out.println(find(arr));
        System.out.println(find(arr1));
    }

    static String find(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                if (arr[i] >= arr[i + 1])
                    return "" + arr[i] + " " + i;
            } else if (i == arr.length - 1) {
                if (arr[i - 1] <= arr[i])
                    return "" + arr[i] + " " + i;
            } else {
                if (arr[i - 1] <= arr[i] && arr[i] >= arr[i + 1])
                    return "" + arr[i] + " " + i;
            }
        }
        return "no peak";
    }
}
