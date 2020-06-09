package easy;

public class FindNonDuplicate {

    public static void main(String[] args) {
        int[] arr = {2, 2, 3, 3, 4, 5, 5};
        System.out.println(find(arr));
    }

    // using XOR
    static int find(int[] arr) {
        int pre = arr[0];
        for (int i = 1; i < arr.length; i++) {
            pre ^= arr[i];
        }
        return pre;
    }

}
