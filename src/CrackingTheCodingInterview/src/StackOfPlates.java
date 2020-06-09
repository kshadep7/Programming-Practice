import java.util.ArrayList;

class Stack {
	int capacity, size = 0;
	int[] arr;
	int top = -1;

	Stack(int cap) {
		capacity = cap;
		arr = new int[cap];
	}

	public boolean isFull() {
		return capacity == size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void push(int x) {
		if (!isFull()) {
			size++;
			arr[++top] = x;
		}
	}

	public int pop() {
		int x = 0;
		if (!isEmpty()) {
			size--;
			x = arr[top--];
		}
		return x;
	}
}

public class StackOfPlates {

	ArrayList<Stack> listOfStacks = new ArrayList<>();
	public int capacity;

	public StackOfPlates(int cap) {
		this.capacity = cap;
	}

	public Stack getLastStack() {
		if (listOfStacks.size() == 0)
			return null;
		return listOfStacks.get(listOfStacks.size() - 1);
	}

	/*
	 * creating a list of stacks when pushing and popping and giving
	 */
	void push(int x) {
		Stack last = getLastStack();
		if (last != null && !last.isFull()) {
			last.push(x);
		} else {
			Stack stack = new Stack(capacity);
			stack.push(x);
			listOfStacks.add(stack);
		}
	}

	public int pop() {
		int x = 0;
		Stack last = getLastStack();
		if (last != null && !last.isEmpty()) {
			x = last.pop();
		}
		if (last.isEmpty())
			listOfStacks.remove(listOfStacks.size() - 1);

		return x;
	}

	public static void main(String[] args) {

		StackOfPlates plates = new StackOfPlates(3);

		plates.push(1);
		plates.push(2);
		plates.push(3);
		plates.push(4);
		plates.push(5);

		plates.pop();
		// plates.pop();

		System.out.println(plates.listOfStacks);
	}
}
