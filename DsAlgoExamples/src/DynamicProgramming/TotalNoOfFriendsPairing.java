package DynamicProgramming;

import java.util.Scanner;

public class TotalNoOfFriendsPairing {

	static int totalFriendsPairing(int n) {
		int[] arr = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			if (i <= 2) {
				arr[i] = i;
			} else {
				arr[i] = arr[i - 1] + (i + 1) * arr[i - 2];

			}
		}

		for (int i = 0; i <= n; i++) {
			System.out.print(arr[i] + "\t");

		}

		return arr[n];

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		System.out.println("total no of pairs ... \t" + totalFriendsPairing(n));

		sc.close();

	}

}
