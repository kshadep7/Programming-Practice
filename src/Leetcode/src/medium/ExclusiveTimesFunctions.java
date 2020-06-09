package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ExclusiveTimesFunctions {

    public static void main(String[] args) {
//        List<String> logs = new ArrayList<>(Arrays.asList("0:start:0", "1:start:2", "1:end:5", "0:end:6"));
        List<String> logs = new ArrayList<>(Arrays.asList("0:start:0", "0:start:2", "0:end:5", "0:start:6", "0:end:6", "0:end:7"));
        System.out.println(Arrays.toString(times(1, logs)));

    }

    static int[] times(int n, List<String> list) {
        Stack<String[]> stack = new Stack<>();

        int[] out = new int[n];
        stack.add(list.get(0).split(":"));
        int time = Integer.parseInt(list.get(0).split(":")[2]);
        int i = 1;
        while (i < list.size()) {
            String[] top = stack.peek();
            String[] next = list.get(i).split(":");
            if (top[1].equals(next[1])) {
                stack.push(next);
                time += Integer.parseInt(next[2]);
            } else if (next[1].equals("end")) {
                stack.pop();
                time = Integer.parseInt(next[2]) - time + 1;
                out[Integer.parseInt(next[0])] = time;
            }
            i++;

        }
        return out;
    }
}
