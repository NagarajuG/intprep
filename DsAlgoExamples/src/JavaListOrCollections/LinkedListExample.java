package JavaListOrCollections;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListExample {

	static void print(LinkedList<String> strings, String operation) {
		System.out.println("\n\nAfter \t" + operation + " \n");
		for (String str : strings) {
			System.out.println(str);
		}
	}

	public static void main(String[] args) {
		LinkedList<String> strings = new LinkedList<String>();

		strings.add("one");
		strings.add("two");
		strings.add("three");
		strings.add(2, "forcedTwo");
		strings.add(2, "againForcedTwo");

		print(strings, "creation");

		System.out.println("\n Using Iterator\n");
		Iterator<String> itr = strings.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		strings.removeFirst();
		print(strings, "removeFirst");

		strings.removeLast();
		print(strings, "removeLast");

		strings.push("pushedString");

		print(strings, "pushedString");

		strings.sort(null);

		print(strings, "sorting");

	}

}
