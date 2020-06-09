import java.util.ArrayList;
import java.util.List;

public class AllSringPossibleK {

    public static void main(String[] args) {

        System.out.println(allStrPoss(new char[]{'(', ')'}, 2));
    }

    static List<String> allStrPoss(char[] set, int k) {
        List<String> ans = new ArrayList<>();
        return helper(ans, set, "", k);

    }

    static List<String> helper(List<String> ans, char[] set, String curr, int k) {
        if (curr.length() == k) {
            ans.add(curr);
            return ans;
        }
        for (char c : set) {
            curr = curr + c;
            ans = helper(ans, set, curr, k);
            curr = curr.substring(0, curr.length() - 1);
        }
        return ans;
    }
}

