package JavaListOrCollections;

import java.util.PriorityQueue;

public class QueueExample {

	public static void main(String[] args) {
		PriorityQueue<String> que = new PriorityQueue<>();

		que.add("1");
		que.add("2");
		que.add("3");

		System.out.println("\n Queue elements are\n ");

		while (!que.isEmpty()) {
			System.out.println(que.poll());

		}

	}

}
