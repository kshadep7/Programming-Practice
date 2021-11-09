package InsideCodeTech;

import java.util.Stack;

public class ValidBrackets {

    public static void main(String[] args) {
        String s = "{()}";
        String s1 = "{(})";
        String s2 = "[}";

        System.out.println(isValid(s1));
    }

    // {} [] ()
    static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '{')
                stack.push('}');
            else if (c == '(')
                stack.push(')');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        // for edge case if stack still has some chars then string is invalid
        return stack.isEmpty();
    }
}
