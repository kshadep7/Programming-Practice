package easy;

public class NonDecreasingArray {

    public static void main(String[] args) {

        int[] arr = {4, 2, 1};
        System.out.println(isNonDecreasing(arr));
    }

    static boolean isNonDecreasing(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                arr[i + 1] = arr[i];
                count++;
            }
        }
        return count <= 1;
    }
}
