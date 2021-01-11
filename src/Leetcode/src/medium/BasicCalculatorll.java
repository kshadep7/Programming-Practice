package medium;

import java.util.Stack;

public class BasicCalculatorll {

    public static void main(String[] args) {
        String exp = "3+2*2";
        System.out.println(calculate(exp));
    }

    static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char opr = '+';
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = (num * 10) + (ch - '0');
            }
            if (!Character.isDigit(ch) && !Character.isWhitespace(ch) || i == s.length() - 1) {
                if (opr == '-')
                    stack.push(-num);
                else if (opr == '+')
                    stack.push(num);
                else if (opr == '/')
                    stack.push(stack.pop() / num);
                else if (opr == '*')
                    stack.push(stack.pop() * num);

                opr = ch;
                num = 0;
            }
        }
        int res = 0;
        while (!stack.isEmpty())
            res += stack.pop();
        return res;
    }
}
