import java.util.HashSet;
import java.util.Set;

public class BrokenKeyBoard {

    public static void main(String[] args) {
//        String s = "Hello, this is CodeSignal";
        String s = "hello, world";
        char[] keys = {'e', 'i', 'h', 'l', 'o', 's'};
        int rst = brokenKeyboard(s, keys);
        System.out.println(rst);
    }

    public static int brokenKeyboard(String text, char[] letters) {
        if (letters == null || letters.length == 0 || text == null || text.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        for (char c : letters) {
            set.add(c);
        }
        String[] words = text.split(" ");
        int rst = 0;
        search:
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (Character.isLetter(c) && !set.contains(c)) {
                    continue search;
                }
            }
            rst++;
        }
        return rst;
    }

}
