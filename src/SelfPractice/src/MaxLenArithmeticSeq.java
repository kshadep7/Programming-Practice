import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaxLenArithmeticSeq {

    public static void main(String[] args) {

        int[] a = {0, 4, 8, 16};
        int[] b = {0, 2, 6, 12, 14, 20};

        int[] a1 = {5, 7, 13, 14};
        int[] b1 = {9, 11, 15};

        System.out.println(maxLen(a1, b1));

    }

    static int maxLen(int[] a, int[] b) {
        if (a.length == 2)
            return 2;

        List<Integer> res = new ArrayList<>();
        Set<Integer> setB = new HashSet<Integer>();
        for (int i : b)
            setB.add(i);

        res.add(a[0]);
        res.add(a[1]);

        int j = 1;

        int diff = a[1] - a[0];
        // modifying the structure of list runtime is not a best pratice
        // but it works for this solution.
        for (int i = 1; i < res.size(); i++) {
            int temp = res.get(i) + diff;
            if (j < a.length - 1 && temp == a[j + 1]) {
                res.add(a[j + 1]);
                j++;
            } else {
                if (setB.contains(temp)) {
                    res.add(temp);
                }
            }
        }
        System.out.println(res);
        return j != a.length ? -1 : res.size();
    }
}
