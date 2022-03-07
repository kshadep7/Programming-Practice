package Hard;

import easy.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLLs {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);

		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);

		ListNode l3 = new ListNode(5);
		l3.next = new ListNode(6);
		l3.next.next = new ListNode(8);

		ListNode[] arr = {l1, l2, l3};

		ListNode node = mergeKLists(arr);


	}

	// brute force
	//TC: N(n+m) -> worst case n^2
	public static ListNode mergeKLists(ListNode[] lists) {

		if (lists == null || lists.length == 0)
			return null;

		int len = lists.length;
		ListNode node = lists[0];
		for (int i = 1; i < len; i++) {
			node = merge(node, lists[i]);
		}

		return node;
	}

	private static ListNode merge(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(-1);
		ListNode pre = head;

		while (l1 != null && l2 != null) {

			if (l1.val <= l2.val) {
				pre.next = l1;
				l1 = l1.next;
			} else {
				pre.next = l2;
				l2 = l2.next;
			}
			pre = pre.next;
		}
		pre.next = l1 == null ? l2 : l1;

		return head.next;
	}

	//using sorting of list
	// get all nodes in in a list and then sort the list
	// TC: N LogN SC: N -> list
	static ListNode merge1(ListNode[] list) {
		List<ListNode> ls = new ArrayList<>();
		// 0(n) n -> all nodes
		for (ListNode l : list) {
			while (l != null) {
				ls.add(l);
				l = l.next;
			}
		}
		// 0(nlogn)
		Collections.sort(ls, (a, b) -> a.val - b.val);
		ListNode node = new ListNode(-1);
		ListNode pre = node;
		// O(n)
		for (ListNode l : ls) {
			pre.next = l;
			l = l.next;
		}
		return node.next;
	}

	//using min heap
	static ListNode merge2(ListNode[] list) {
		PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);

		for (ListNode l : list) {
			while (l != null) {
				heap.add(l);
				l = l.next;
			}
		}
		ListNode node = new ListNode(-1);
		ListNode pre = node;

		while (!heap.isEmpty()) {
			pre.next = heap.remove();
			pre = pre.next;
		}

		return node.next;
	}
}
