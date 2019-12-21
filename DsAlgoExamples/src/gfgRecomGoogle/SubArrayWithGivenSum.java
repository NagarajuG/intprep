package gfgRecomGoogle;

import java.util.Scanner;

public class SubArrayWithGivenSum {

	static void findSubArray(int[] arr, int size, int sum) {
		int i = 0, total = 0, j = -1;
		while (j < size) {
			if (total == sum) {
				System.out.println("The sub array from\t" + i + " to " + j);
				return;
			}
			if (total < sum) {
				j++;
				total = total + arr[j];

			}
			if (total > sum) {
				total = total - arr[i];
				i++;
			}
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		System.out.println("Enter the array elements");
		System.out.println();

		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}

		int sum = sc.nextInt();

		sc.close();

		findSubArray(arr, size, sum);

	}

}
