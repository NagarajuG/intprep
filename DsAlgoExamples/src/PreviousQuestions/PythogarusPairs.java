package PreviousQuestions;

import java.util.HashSet;

public class PythogarusPairs {

	static void findPairs(int[] arr) {
		HashSet<Integer> hSet = new HashSet<Integer>();

		for (int i = 0; i < arr.length; i++) {
			hSet.add(arr[i] * arr[i]);
		}

		for (int s : hSet) {
			int total = s;
			for (int a : hSet) {
				int b = total - a;
				if (hSet.contains(b)) {
					System.out.println("Found \t" + s + " = " + a + " + " + b);
					// hSet.remove(a);
					// hSet.remove(b);
				}
			}

		}
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 3, 5, 12, 5, 13 };

		findPairs(arr);

	}

}
