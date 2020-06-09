package medium;

import java.util.*;

public class SimplyfyPath {

    public static void main(String[] args) {
//        System.out.println(simplifyPath("/a/./b/../../c/"));
//        System.out.println(simple("/../"));
        System.out.println(simplifyPath1("/home//foo/../bar//abc//.."));
    }

    // for a single char --> not a general solution
    public static String simplifyPath(String path) {
        // String[] arr = path.split("/");
        // System.out.println(Arrays.toString(arr));
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int len = path.length();
        while (i < len) {

            if (path.charAt(i) == '/') {
                i++;
                continue;
            } else if (path.charAt(i) == '.') {
                if (path.charAt(i + 1) == '.')
                    if (!stack.isEmpty()) stack.pop();
                i++;
                continue;
            }

            stack.push(path.charAt(i));
            i++;
        }

        while (!stack.isEmpty()) {
            char c = stack.pop();
            sb.append(Character.toString(c));
            sb.append("/");
        }

        return sb.reverse().toString();
    }

    static String simple(String path) {
        Deque<String> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        // String[] arr = {"", " ", ".", ".."};
        ArrayList<String> list = new ArrayList<>(Arrays.asList("", " ", ".", ".."));
        System.out.println(Arrays.toString(path.split("/")));
        for (String str : path.split("/")) {
            if (list.contains(str) && str.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else if (!list.contains(str)) {
                stack.push(str);
            }
        }
        System.out.println(stack.toString());
        while (!stack.isEmpty()) {
            String s = stack.pollLast();
            sb.append("/");
            sb.append(s);
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }

    // just for practice
    static String simplifyPath1(String path) {

        Deque<String> stack = new LinkedList<>();
        List<String> skip = new ArrayList<>(Arrays.asList("", " ", ".", ".."));

        for (String str : path.split("/")) {
            if (!skip.contains(str)) {
                stack.push(str);
            } else if (skip.contains(str) && str.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            String s = stack.pollLast();
            sb.append("/");
            sb.append(s);
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
