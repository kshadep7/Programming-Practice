package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StrobogrammaticNumbers {

    public static void main(String[] args) {

//        System.out.println(findStrobogrammatic(3));
        System.out.println(findAllStrobogrammatic(3));
    }

    // iterative approach
    public static List<String> findStrobogrammatic(int n) {
        List<String> cur, ans;
        ans = new ArrayList<String>((n & 1) == 0 ? Arrays.asList("") : Arrays.asList("0", "1", "8"));
        if (n < 2) return ans;

        for (; n > 1; n -= 2) {
            cur = ans;
            ans = new ArrayList<String>();
            for (String i : cur) {
//                if (n > 3)
                ans.add('0' + i + '0');
                ans.add('1' + i + '1');
                ans.add('8' + i + '8');
                ans.add('6' + i + '9');
                ans.add('9' + i + '6');
            }
        }

        return ans;
    }

    // Recursive approach
    public static List<String> findAllStrobogrammatic(int n) {
        if (n == 0) return new ArrayList<>(Arrays.asList(""));
        if (n == 1) return new ArrayList<>(Arrays.asList("0", "1", "8"));

        List<String> currList = findStrobogrammatic(n - 2);
        List<String> res = new ArrayList<>();

        for (String str : currList) {
            res.add("0" + str + "0");
            res.add("1" + str + "1");
            res.add("8" + str + "8");
            res.add("6" + str + "9");
            res.add("9" + str + "6");
        }

        return res;
    }
}
