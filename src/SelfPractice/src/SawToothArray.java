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
        int[] arr1 = {9, 8, 7, 6, 5};
        int[] arr2 = {-1000000000, 1000000000};
        int[] arr3 = {-778277028, -509675834, -828663475, 190114564,
                -34919218, -34919218, 106447210, -887980502, -399561546,
                -319453881, -319453881, 564702467, -512179848,
                634452898, -279371457, -279371457, -72310717, -770556513, -629539596, 112073567};
//        System.out.println(countUpDowns(arr3));
        System.out.println(getSawtoothCount(arr1));
    }

    // doest not work for arr3
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

    public static int getSawtoothCount(int[] nums) {
        int answer = 0;
        int n = nums.length;

        boolean dir;
        int i = 0, j = 1;

        //Outermost loop.
        while (j < n) {
            //We skip all the duplicate elements since they can't contribute to our result.
            while (j < n && nums[j - 1] == nums[j]) {
                j++;
            }

            //If skipping duplicates leads to end of array, we break and return answer.
            if (j == n) break;


            i = j - 1;

            //Direction variable. We need this to store whether we go UP or DOWN in current iteration.
            //It is initialized as TRUE if direction for nums[0] -> nums[1] is UP, otherwise it's false.
            dir = nums[j - 1] < nums[j];

            //This while loop condition is the trickiest part imho. If nums[j-1] < nums[j] then we know dir should be true,
            //Otherwise if nums[j-1] > nums[j] then dir is false, hence we use !dir.
            while (j < n && (nums[j - 1] < nums[j] && dir || nums[j - 1] > nums[j] && !dir)) {
                //Extend the window and flip the direction.
                j++;
                dir = !dir;
            }

            //Calculate subarrays count for current window size.
            answer += ((j - i) * (j - i - 1)) / 2;
        }
        return answer;
    }
}
