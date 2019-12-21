package JavaListOrCollections;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListExample {

	public static void main(String[] args) {
		ArrayList<String> strings = new ArrayList<String>();

		strings.add("Hi");
		strings.add("Hello");
		strings.add("How");
		strings.add(2, "are");
		strings.add(2, "you");

		System.out.println("Using for stmt\n");
		for (String str : strings) {
			System.out.println(str);
		}

		System.out.println("\n Using Iterator");
		Iterator<String> itr = strings.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

	}

}
