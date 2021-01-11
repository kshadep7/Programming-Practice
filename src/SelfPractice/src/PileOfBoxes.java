import java.util.Arrays;

public class PileOfBoxes {

    public static void main(String[] args) {
        int[] piles = {4,5,5,2,4};
        System.out.println(minSteps(piles));
    }

    public static int minSteps(int[] piles) {
        int len = piles.length;
        if (len <= 1) return 0;
        Arrays.sort(piles);
        int res = 0, distinctNums = 0;
        for (int i = 1; i < len; ++i) {
            if (piles[i] != piles[i - 1]) {
                ++distinctNums;
            }
            res += distinctNums;
        }
        return res;
    }

}
