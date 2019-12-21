package PreviousQuestions;

import java.util.Stack;

public class StackInPlaceReversal {

	public static void main(String[] args) {
		Stack<Integer> st = new Stack<>();
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		st.push(5);
		st.push(6);

		// System.out.println(st);
		reverse(st);
		while (!st.isEmpty()) {
			System.out.println(st.pop());
		}

		// System.out.println(st);
	}

	public static void reverse(Stack<Integer> st) {
		if (st == null || st.isEmpty() == true)
			return;

		int element = st.pop();
		reverse(st);

		insertAtBottom(st, element);
	}

	public static void insertAtBottom(Stack<Integer> st, int element) {
		if (st.isEmpty() == true) {
			st.push(element);
			return;
		}

		int element2 = st.pop();
		insertAtBottom(st, element);

		st.push(element2);
	}
}