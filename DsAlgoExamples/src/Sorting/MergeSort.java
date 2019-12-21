package Sorting;

import java.util.Scanner;

public class MergeSort {

	static void merge(int[] A, int l, int m, int h) {
		int n1 = m - l + 1;
		int n2 = h - m;
		int i, j;

		int[] A1 = new int[n1];
		int[] A2 = new int[n2];

		for (i = 0; i < n1; i++)
			A1[i] = A[l + i];
		for (j = 0; j < n2; j++)
			A2[j] = A[m + 1 + j];

		i = 0;
		j = 0;
		int k = l;
		while (i < n1 && j < n2) {
			if (A1[i] <= A2[j])
				A[k++] = A1[i++];
			else
				A[k++] = A2[j++];

		}

		for (; i < n1; i++)
			A[k++] = A1[i];

		for (; j < n2; j++)
			A[k++] = A2[j];

	}

	static void mergeSort(int[] A, int l, int h) {
		if (l < h) {
			int m = (l + h) / 2;
			mergeSort(A, l, m);
			mergeSort(A, m + 1, h);
			merge(A, l, m, h);
		}

	}

	static void display(int A[], int n) {
		for (int i = 0; i < n; i++)
			System.out.print(A[i] + "\t");
	}

	public static void main(String[] args) {
		// Scanner sc = new Scanner(System.in);
		// System.out.println("Enter no elements\n");
		int noOfElements = 10; // sc.nextInt();

		int A[] = new int[] { 5, 6, 7, 8, 4, 3, 2, 9, 10, 1 };

		/*
		 * for (int i = 0; i < noOfElements; i++) { A[i] = sc.nextInt(); }
		 * 
		 * sc.close();
		 */

		System.out.println("elements before sorting\n");
		display(A, noOfElements);

		mergeSort(A, 0, noOfElements - 1);

		System.out.println("\n elements After sorting\n");
		display(A, noOfElements);

	}

}
