package PreviousQuestions;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MedianFinder {

	PriorityQueue<Integer> minHeap = null;
	PriorityQueue<Integer> maxHeap = null;

	public MedianFinder() {
		minHeap = new PriorityQueue<Integer>();
		maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());

	}

	public void addNum(int num) {
		minHeap.offer(num);
		maxHeap.offer(minHeap.poll());

		if (minHeap.size() < maxHeap.size()) {
			minHeap.offer(maxHeap.poll());
		}

	}

	public double FindMedian() {
		if (minHeap.size() > maxHeap.size()) {
			return minHeap.peek();
		}
		return (minHeap.peek() + maxHeap.peek()) / 2.0;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MedianFinder mdFinder = new MedianFinder();

		int n = sc.nextInt();

		while (n != 0) {
			mdFinder.addNum(n);
			System.out.println(mdFinder.FindMedian());

			n = sc.nextInt();

		}

		sc.close();

	}

}
