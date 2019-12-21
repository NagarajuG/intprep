package DynamicProgramming;

import java.util.Scanner;

public class LargestRectangularAreaHistogram {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Histogram size\n");

		int n = sc.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		sc.close();

		int total = 0, maxSum = 0, min = 0, sum = 0;
		for (int i = 0; i < n; i++) {
			total = 1;
			min = sum = arr[i];
			for (int j = i + 1; j < n; j++) {
				total++;

				if (min > arr[j])
					min = arr[j];

				sum = min * total;

				if (maxSum < sum)
					maxSum = sum;

			}
		}

		System.out.println("The max area of rectangular in the given histograms is ..." + maxSum);

	}

}
