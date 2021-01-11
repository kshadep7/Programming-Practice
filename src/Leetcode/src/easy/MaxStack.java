package easy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class MaxStack {

    /**
     * initialize your data structure here.
     */
    Deque<Integer> dq;
    PriorityQueue<Integer> heap;

    public MaxStack() {
        dq = new ArrayDeque<>();
        heap = new PriorityQueue<>((a, b) -> b - a);
    }

    public void push(int x) {
        heap.offer(x);
        dq.addLast(x);
    }

    public int pop() {
        int del = dq.removeLast();
        heap.remove(del);
        return del;
    }

    public int top() {
        return dq.getLast();
    }

    public int peekMax() {
        return heap.peek();
    }

    public int popMax() {
        int del = heap.poll();
        dq.removeLastOccurrence(del);
        return del;
    }
}

