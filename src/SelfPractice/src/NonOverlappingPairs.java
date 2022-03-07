import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Pair {
	private int start, finish;

	public Pair(int start, int finish) {
		this.start = start;
		this.finish = finish;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getFinish() {
		return finish;
	}

	public void setFinish(int finish) {
		this.finish = finish;
	}
}

class NonOverlappingPairs {
	public static void main(String[] args) {
		List<Pair> act = new ArrayList<>();
		Pair pair1 = new Pair(1, 4);
		Pair pair2 = new Pair(3, 5);
		Pair pair3 = new Pair(0, 6);
		Pair pair4 = new Pair(5, 7);
		Pair pair5 = new Pair(3, 8);
		Pair pair6 = new Pair(5, 9);
		Pair pair7 = new Pair(6, 10);
		Pair pair8 = new Pair(8, 11);
		Pair pair9 = new Pair(8, 12);
		Pair pair10 = new Pair(2, 13);
		Pair pair11 = new Pair(12, 14);

		act.add(pair1);
		act.add(pair2);
		act.add(pair3);
		act.add(pair4);
		act.add(pair5);
		act.add(pair6);
		act.add(pair7);
		act.add(pair8);
		act.add(pair9);
		act.add(pair10);
		act.add(pair11);

		for (Pair p : selectActivity(act))
			System.out.println(p.getStart() + "," + p.getFinish());
	}


	/*
	Idea:
	so let me understand
	ask: we have to find single activity wich does not overlap with any other activity
	is that considered as sinle activity

	so the first solution comes to mind is to check if there is an overlap or not
	so by iterating thru the

	ask if we have to find max no of act or return the intervals?
	look at main fuction
	its a list of pair
	so we have to return

	first pair with second pair
	so the end time of first and end time of second
	so sorting the pairs by end time
	then check each pair with other pairs

	sort it
	check first end time and second start time
	so
	1. sort the paris by edn timee
	2. campare first end time with second start time
	  2.1 if (second.first >= first.end) then no overlap
		  if yes then add result
	  2.2 the key is here to keep track of the latest pair to check with other pairs
		for eg. we add (1,4) to reult first we cheeck (3,5) so no add
		then is 0, 6 so no
		then
		so we will check 5, 7 with other pairs


  */
// what is the input? list of pairs?
	public static List<Pair> selectActivity(List<Pair> activities) {

		// sorting the list
		// so wee will needing a comparator aas we sorting by end time

		activities.sort((a, b) -> a.getFinish() - b.getFinish());

		//so keeping track of latest activity i amm thinking of using stack as it will always give me top element /activity
		Stack<Pair> stack = new Stack<>();
		// we will add first pair in the stack
		stack.push(activities.get(0));

		// iterate the list
		for (int i = 1; i < activities.size(); i++) {

			// we will peek first
			Pair first = stack.peek();
			Pair second = activities.get(i);

			//check if overlap
			// ask what if they are equal ??/
			// does that count aas diff activity
			if (second.getStart() >= first.getFinish()) {
				// no overlap
				// so push to stack
				stack.push(second);
			}

		}
		// so now we have all the activities in the stack
		// no no we will make List and add elements in list
		// yes i am adding to stack
		// or we can use list aas well and check with last element
		// so basically we have iterate thru our. result as well
		// yes!!!
		// as we sorting by end time does all the job
		// converting to list and then returning should i do that?

		List<Pair> ans = new ArrayList<>();
		while (!stack.isEmpty()) {
			ans.add(stack.pop());
		}
		return ans;
	}
}




