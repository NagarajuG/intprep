package DynamicProgramming;

import java.util.Scanner;

public class MinTimeToWriteCharacters {

	static int minTime(int n) {
		int i = 1, c = 1, d = 2;
		int[] time = new int[n + 1];

		for (int j = 0; j <= n; j++) {
			if (j <= 2) {
				time[j] = j;
			} else {
				if (j % 2 == 0) {
					time[j] = Math.min(time[j - 1] + i, time[j / 2] + c);
				} else {
					time[j] = Math.min(time[j - 1] + i, time[(j + 1) / 2] + c + d);
				}
			}
		}

		return time[n];
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		sc.close();

		System.out.println("\nMinimum time to write characters is " + minTime(n));

	}

}
