package InsideCodeTech;

import java.util.ArrayList;
import java.util.List;

public class StringSubsequences {

    public static void main(String[] args) {
        String s = "abcd";
        System.out.println(findAllSubs(s));
    }

    static List<String> findAllSubs(String s) {
        return helper(s, 0, "", new ArrayList<>());
    }

    private static List<String> helper(String s, int i, String sub, List<String> res) {
        if (i == s.length()) {
            res.add(sub);
            return res;
        }

        res = helper(s, i + 1, sub + s.charAt(i), res);
        res = helper(s, i + 1, sub, res);

        return res;
    }
}
