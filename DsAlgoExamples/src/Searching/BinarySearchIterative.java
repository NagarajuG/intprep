package Searching;

import java.util.Scanner;

public class BinarySearchIterative {

	public static void main(String[] args) {
		int[] A = new int[100];

		System.out.println("Enter number the elements in sorted order, terminate by 0");

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i = 0;
		while (n != 0) {
			A[i++] = n;
			n = sc.nextInt();
		}

		System.out.println("Enter element to be found");
		int key = sc.nextInt();

		int l = 0, h = i;

		while (l <= h) {
			int mid = (l + h) / 2;

			if (A[mid] == key) {
				System.out.println("Element found");
				System.exit(1);
			} else if (key < A[mid]) {
				h = mid - 1;
			} else {
				l = mid + 1;
			}

		}

		System.out.println("Element not found");
	}

}
