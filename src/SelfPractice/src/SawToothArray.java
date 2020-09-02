public class SawToothArray {

    // get count of subarrays(atleast 2 elements) of up and down streak in an array
    /*
     * [1,2,1,2,1] - res -> 10
     * -> [12121] - 1
     * 12 - 2
     * 21 - 3... and so on
     * */
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 2, 1};
        int[] arr1 = {9,8,7,6,5};
        System.out.println(countUpDowns(arr1));
    }

    static int countUpDowns(int[] arr) {

        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            boolean up = false;
            boolean down = false;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j - 1] == arr[j])
                    continue;
                if (!up && !down) {
                    if (arr[j - 1] < arr[j])
                        up = true;
                    else if (arr[j - 1] > arr[j])
                        down = true;
                    count++;
                } else if (up) {
                    if (arr[j - 1] > arr[j]) {
                        down = true;
                        up = false;
                        count++;
                    } else break;
                } else if (down) {
                    if (arr[j - 1] < arr[j]) {
                        up = true;
                        down = false;
                        count++;
                    } else break;
                }
            }
        }
        return count;
    }
}
