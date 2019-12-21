package PreviousQuestions;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

class TopKelementsFromArray {
	static List<Integer> topKFrequent(int[] nums, int k) {
		// build hash map : character and how often it appears
		HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
		for (int n : nums) {
			count.put(n, count.getOrDefault(n, 0) + 1);
		}

		// init heap 'the less frequent element first'
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> count.get(n1) - count.get(n2));

		// keep k top frequent elements in the heap
		for (int n : count.keySet()) {
			heap.add(n);
			if (heap.size() > k)
				heap.poll();
		}

		// build output list
		List<Integer> top_k = new LinkedList<Integer>();
		while (!heap.isEmpty())
			top_k.add(heap.poll());
		Collections.reverse(top_k);
		return top_k;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 7, 8, 9, 10, 1, 6, 2, 1, 6, 5, 4, 1, 6 };
		int k = 3;

		List<Integer> top_k = topKFrequent(nums, k);

		Iterator<Integer> it = top_k.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
