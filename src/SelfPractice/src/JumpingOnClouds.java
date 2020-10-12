public class JumpingOnClouds {

    public static void main(String[] args) {

        int[] arr = {0, 0, 1, 0, 0, 1, 0};
        System.out.println(jumpingOnClouds(arr));
    }

    static int jumpingOnClouds(int[] c) {
        int jumps = -1;
        for (int i = 0; i < c.length; i++) {
            if (i < (c.length - 2) && c[i + 2] == 0) {
                i++;
            }
            jumps++;
        }
        return jumps;

    }
}
