package Sorting;

public class QuickSort {

	static void display(int A[], int n) {
		for (int i = 0; i < n; i++)
			System.out.print(A[i] + "\t");
	}

	static void swap(int A[], int i, int j) {
		int t = A[i];
		A[i] = A[j];
		A[j] = t;
	}

	static int partition(int A[], int l, int h) {
		int p = A[l];
		int i = l, j = h + 1;
		while (true) {
			do {
				i++;
			} while (i <= h && A[i] < p);

			do {
				j--;
			} while (A[j] > p && (j >= l));

			if (i < j) {
				swap(A, i, j);
			} else {
				swap(A, l, j);
				return j;

			}
		}

	}

	static void quickSort(int A[], int l, int h) {
		int j;
		if (l < h) {
			j = partition(A, l, h);
			quickSort(A, l, j - 1);
			quickSort(A, j + 1, h);
		}
	}

	public static void main(String[] args) {
		int noOfElements = 10; // sc.nextInt();

		int A[] = new int[] { 5, 6, 7, 8, 4, 3, 2, 9, 10, 1 };

		/*
		 * for (int i = 0; i < noOfElements; i++) { A[i] = sc.nextInt(); }
		 * 
		 * sc.close();
		 */

		System.out.println("elements before sorting\n");
		display(A, noOfElements);

		quickSort(A, 0, noOfElements - 1);

		System.out.println("\n elements After sorting\n");
		display(A, noOfElements);

	}

}
