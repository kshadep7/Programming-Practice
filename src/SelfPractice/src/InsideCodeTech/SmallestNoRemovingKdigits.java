package InsideCodeTech;

import java.util.Stack;

public class SmallestNoRemovingKdigits {

    public static void main(String[] args) {

        String num = "825563";
        String num1 = "123456";
        String num2 = "000235";
        System.out.println(smallestNo(num2, 1));
    }

    // TC: N
    // SC: N -> stack
    static String smallestNo(String num, int k) {
        if (num.length() <= k)
            return "0";
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {        // N
            int digit = Integer.parseInt("" + num.charAt(i));
            while (!stack.isEmpty() && stack.peek() > digit && k > 0) {     // always less than N
                k--;
                stack.pop();
            }
            stack.push(digit);
        }
        // check for k > 0
        if (k > 0) {
            while (!stack.isEmpty() && k > 0) {     // N
                stack.pop();
                k--;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {      // N
            sb.append(stack.pop());
        }
        // to deal with leading zeros
        //converting it to Integer then return in string
        return sb.length() == 0 ? "0" : String.valueOf(Integer.parseInt(sb.reverse().toString()));
    }
}
