package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasingSubSequesnce {

	static void LIS(int[] arr, int size) {
		int[] list = new int[size];

		Arrays.fill(list, 1);

		int max = 0;

		for (int i = 1; i < size; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && list[i] < list[j] + 1) {
					list[i] = list[j] + 1;
				}

			}
		}

		for (int i = 0; i < size; i++) {
			if (list[i] > max)
				max = list[i];
		}

		System.out.println("The length of max increasing subsequesnce is \t " + max);

		for (int i = 0; i < size; i++) {
			System.out.println("The number and its lis is" + arr[i] + "\t" + list[i]);
		}
	}

	static void modifiedLis(int[] arr, int size) {
		int[][] counts = new int[2][size];

		Arrays.fill(counts[0], 1);
		Arrays.fill(counts[1], 0);

		int max = 0, n = 0;

		for (int i = 1; i < size; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && counts[0][i] < counts[0][j] + 1) {
					counts[0][i] = counts[0][i] + 1;
					counts[1][i] = j;
					max = Math.max(max, counts[0][i]);
				}
			}
		}

		for (int i = 0; i < size; i++) {
			if (counts[0][i] > max) {
				max = counts[0][i];
				n = i;
			}

		}

		System.out.println("The max number is " + max);

		String path = "->" + arr[n];

		while (n != 0) {
			int c = counts[1][n];

			if (c != 0)
				path = "->" + arr[c] + path;

			n = c;

		}

		System.out.println("The path is " + path);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("\nEnter number of elements\n");

		int n = sc.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			int j = sc.nextInt();
			arr[i] = j;
		}

		modifiedLis(arr, n);

		sc.close();
	}

}
