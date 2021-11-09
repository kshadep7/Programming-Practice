package InsideCodeTech;

import java.util.Scanner;

public class AddTwoLinkedLists {

	public static void main(String[] args) {

//		LinkedList l1 = new LinkedList(3);
//		l1.next = new LinkedList(2);
//		l1.next.next = new LinkedList(1);
//
//		LinkedList l2 = new LinkedList(5);
//		l2.next = new LinkedList(9);
//		l2.next.next = new LinkedList(4);
//		l2.next.next.next = new LinkedList(3);

//        printLL(l1);
//        printLL(l2);

//        printLL(add(l1, l2));


		// Here we use the Scanner class to read file content line-by-line.
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();

		// From the above line of code we got a line from the file
		// content. Now we want to split the line with comma as the
		// character delimiter.
		Scanner lineScanner = new Scanner(line);
		lineScanner.useDelimiter(",");
		while (lineScanner.hasNext()) {
			// Get each splitted data from the Scanner object and print
			// the value.
			String part = lineScanner.next();
			System.out.print(part + " ");
		}
		 scanner.close();
	}

	// TC: max(m, n)
	static LinkedList add(LinkedList l1, LinkedList l2) {
		if (l1 == null)
			return l2;
		else if (l2 == null)
			return l1;
		int carry = 0;
		LinkedList head = new LinkedList(0);
		LinkedList res = head;
		while (l1 != null || l2 != null || carry > 0) {
			int a = l1 == null ? 0 : l1.data;
			int b = l2 == null ? 0 : l2.data;
			int sum = carry + a + b;
			LinkedList node = new LinkedList(sum % 10);
			head.next = node;
			carry = sum / 10;
			head = head.next;

			if (l1 != null)
				l1 = l1.next;
			if (l2 != null)
				l2 = l2.next;
		}
		return res.next;
	}

	static void printLL(LinkedList ll) {
		while (ll != null) {
			System.out.print(ll.data + " -> ");
			ll = ll.next;
		}
		System.out.println("\n");
	}

}
