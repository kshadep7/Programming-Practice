import java.util.Stack;

public class StackWithMin extends Stack<Integer>{

	Stack<Integer> stack2ForMins = new Stack<>();
	public static void main(String[] args) {

		StackWithMin stack = new StackWithMin();
		stack.push(3);
		stack.push(5);
		stack.push(2);
		stack.push(1);
		stack.push(8);
		
		stack.pop(); // popping 8 --> min is still 1
		stack.pop();// popping 1 --> min in 2 now
		
		System.out.println(stack.toString());
		System.out.println(stack.min());
		
		
	}
	@Override
	public Integer push(Integer item) {
		if(item <= min())
			stack2ForMins.push(item);
		return super.push(item);
	}
	@Override
	public synchronized Integer pop() {
		int item = super.pop();
		if(item == min())
			stack2ForMins.pop();
		return item;
	}

	public int min() {
		if(stack2ForMins.isEmpty()) {
			return Integer.MAX_VALUE;
		}else {
			return (int) stack2ForMins.peek();
		}
	}
}
