package InsideCodeTech;

import java.util.HashSet;
import java.util.Set;

public class FirstRepeatingCharacter {

    public static void main(String[] args) {

        String str = "programming";
        System.out.println(findChar1(str));
    }

    // TC: n2
    // SC: 1
    static char findChar(String str) {

        for (int i = 0; i < str.length() - 1; i++) {
            char a = str.charAt(i);
            for (int j = i + 1; j < str.length(); j++) {
                char b = str.charAt(j);
                if (a == b)
                    return a;
            }
        }
        return '\0';
    }

    // TC: n
    // SC : n
    static char findChar1(String str) {
        Set<Character> set = new HashSet<>();
        for (char c : str.toCharArray()) {
            if (set.contains(c))
                return c;
            else
                set.add(c);
        }
        return '\0';
    }
}
