package JavaListOrCollections;

import java.util.Iterator;
import java.util.Stack;

public class StackExample {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();

		stack.add("one");
		stack.push("two");
		stack.add(1, "1");
		stack.push("2");

		System.out.println("\n printing stack using iterator");

//		while (!stack.empty()) {
//			System.out.println(stack.pop());
//
//		}

		/*
		 * Iterator overwrites the property of Stack and you can access it in the
		 * reverse order also------- which is bad
		 */

		Iterator<String> it = stack.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}

}
