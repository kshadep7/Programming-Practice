import java.util.Arrays;

public class RemoveDuplicatesArray {

    public static void main(String[] args) {
//        System.out.println(remove(new int[]{1, 1, 1, 2, 2, 3}));
        System.out.println(remove2(new int[]{1, 1, 1, 1, 2, 2, 2, 3}));
    }

    static int remove(int[] arr) {

        int i = 0;
        for (int j = 0; j < arr.length; j++) {

            if (arr[i] == arr[j])
                continue;
            else {
                i++;
                arr[i] = arr[j];
            }
        }
        System.out.println(Arrays.toString(arr));
        return i + 1;

    }

    static int remove2(int[] arr) {
        int i = 0;
        int j = 1;

        while (j < arr.length) {

            if (arr[i] == arr[j]) {
                if (i == 0) {
                    i++;
                    j++;
                } else if (arr[i] == arr[i - 1]) {
                    j++;
                } else {
                    i++;
                    arr[i] = arr[j];
                    j++;
                }
            } else {
                i++;
                arr[i] = arr[j];
                j++;
            }
        }
        System.out.println(Arrays.toString(arr));
        return i + 1;
    }
}
