package Hard;

import java.util.PriorityQueue;

public class FindMedianFromDataStream {
	private PriorityQueue<Double> maxHeap; // for storing smaller side of stream
	private PriorityQueue<Double> minHeap; // for storing larger side of stream

	public static void main(String[] args) {

	}

	public FindMedianFromDataStream() {
		maxHeap = new PriorityQueue<>();
		minHeap = new PriorityQueue<>();
	}

	// TC: 5 x logn -> 3 add and 2 remove
	// SC: n -> all nums in both heaps
	public void addNum(int num) {
		// add to max heap
		maxHeap.offer((double) num);
		// balance size
		minHeap.offer(maxHeap.peek());
		maxHeap.remove();

		// check for size -> we want max heap to have n+1 elements and minheap to have n
		if (maxHeap.size() < minHeap.size()) {
			maxHeap.offer(minHeap.peek());
			minHeap.remove();
		}
	}

	// O(1)
	public double findMedian() {
		return maxHeap.size() > minHeap.size() ? maxHeap.peek() :
				(maxHeap.peek() + minHeap.peek()) * 0.5;
	}
}
