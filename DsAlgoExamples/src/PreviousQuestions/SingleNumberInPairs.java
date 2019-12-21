package PreviousQuestions;

import java.util.Scanner;

public class SingleNumberInPairs {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] arr = new int[n];

		for (int j = 0; j < n; j++) {
			arr[j] = scanner.nextInt();
		}

		scanner.close();

		int result = 0;

		for (int j = 0; j < arr.length; j++) {
			result = result ^ arr[j];

		}

		System.out.println("\nThe result is \t" + result);

	}

}
