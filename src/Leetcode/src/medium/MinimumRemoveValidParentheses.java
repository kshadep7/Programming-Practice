package medium;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MinimumRemoveValidParentheses {

    public static void main(String[] args) {
        String s = "l(e)))et((co)d(e";
//        System.out.println(remove(s));
        System.out.println(minRemoveToMakeValid(s));


    }

    static String remove(String s) {

        Stack<Integer> stack = new Stack<>();
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            }
            if (ch == ')')
                if (stack.isEmpty())
                    set.add(i);
                else
                    stack.pop();
        }

        while (!stack.isEmpty())
            set.add(stack.pop());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(i))
                sb.append(s.charAt(i));

        }
        return sb.toString();
    }

    private static StringBuilder removeInvalidClosing(CharSequence string, char open, char close) {
        StringBuilder sb = new StringBuilder();
        int balance = 0;
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (c == open) {
                balance++;
            }
            if (c == close) {
                if (balance == 0) continue;
                balance--;
            }
            sb.append(c);
        }
        return sb;
    }

    public static String minRemoveToMakeValid(String s) {
        StringBuilder result = removeInvalidClosing(s, '(', ')');
        result = removeInvalidClosing(result.reverse(), ')', '(');
        return result.reverse().toString();
    }


}
