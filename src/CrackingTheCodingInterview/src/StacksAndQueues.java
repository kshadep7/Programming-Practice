import java.util.Arrays;
import java.util.Stack;

public class StacksAndQueues {

	public static void main(String[] args) {

		int[] arr = new int[6];
		for (int i = 0; i < arr.length; i++) {

			arr[i] = i;
		}
		System.out.println(Arrays.toString(arr));
		int div = arr.length / 3;

		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		Stack<Integer> stack3 = new Stack<>();

		for (int i = 0; i < div; i++) {
			stack1.add(arr[i]);
		}

		System.out.println(stack1);

	}

}
