package PreviousQuestions;

import java.util.Scanner;

public class FirstLastIndexOfElementInSortedArray {
	private int first = Integer.MAX_VALUE;
	private int last = -1;

	void bSearch(int[] arr, int key, int low, int high) {
		if (low > high) {
			return;
		}

		int mid = (low + high) / 2;

		if (key == arr[mid]) {
			if (this.first > mid)
				this.first = mid;
			if (this.last < mid)
				this.last = mid;

			bSearch(arr, key, low, mid - 1);
			bSearch(arr, key, mid + 1, high);

		}
		if (key < arr[mid])
			bSearch(arr, key, low, mid - 1);
		else
			bSearch(arr, key, mid + 1, high);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		FirstLastIndexOfElementInSortedArray obj = new FirstLastIndexOfElementInSortedArray();
		System.out.println("Enter elemennts... 0 to end\n");
		int n = sc.nextInt();
		int[] arr = new int[100];
		int i = 0;

		while (n > 0) {
			arr[i++] = n;
			n = sc.nextInt();
		}

		System.out.println("enter key element\n");
		int key = sc.nextInt();

		obj.bSearch(arr, key, 0, i - 1);

		if (obj.last == -1)
			obj.first = -1;

		System.out.println("First index is...\t" + obj.first + "and last index is \t" + obj.last);

		sc.close();

	}

}
