import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PickingNumbers {

    public static void main(String[] args) {

        System.out.println(pickingNumbers(Arrays.asList(8,5,4,8,4)));
    }

    public static int pickingNumbers(List<Integer> a) {
        Collections.sort(a);
        int start = 0;
        int i = 0;
        int max = 0;
        while (i < a.size()) {
            if (Math.abs(a.get(start) - a.get(i)) > 1) {
                start = i;
            }
            max = Math.max(max, i - start + 1);
            i++;
        }
        i--;

        return Math.max(max, i - start + 1);
    }
}
