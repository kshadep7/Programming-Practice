import java.util.ArrayList;
import java.util.List;

public class AllValidParenthesis {
    public static void main(String[] args) {
        System.out.println(backtrack(new ArrayList<>(), "", 0, 0, 2));

    }

    public static List<String> backtrack(List<String> ans, String cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur);
            return ans;
        }

        if (open < max)
            ans = backtrack(ans, cur + "(", open + 1, close, max);
        if (close < open)
            ans = backtrack(ans, cur + ")", open, close + 1, max);

        return ans;
    }
}
