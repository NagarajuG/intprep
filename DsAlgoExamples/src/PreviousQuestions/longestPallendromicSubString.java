package PreviousQuestions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class longestPallendromicSubString {

	static void pallenDrumUsingDP(String str) {
		int n = str.length();
		int[][] match = new int[n][n];

		for (int i = 0; i < n; i++) {
			match[i][i] = 1;
		}

		for (int j = 0; j < n; j++) {
			for (int i = 0; i <= j; i++) {
				if (str.charAt(i) == str.charAt(j) && (j - i <= 1 || match[i + 1][j - 1] == 1)) {
					match[i][j] = 1;

				}
			}
		}

		System.out.println("The DP matrix is\n");

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(match[i][j] + "\t");

			}
			System.out.println("\n");

		}

		for (int i = 0; i < n; i++) {
			for (int j = n - 1; j > i; j--) {
				if (match[i][j] == 1) {
					System.out.println(str.substring(i, j + 1));
					return;

				}

			}

		}
		System.out.println("No pallendrum found!!!");
	}

	static void logestPallendromicString(String str) {
		int n = str.length();
		int maxLength = 0, start = 0, low = 0, high = 0;

		for (int i = 0; i < n; i++) {
			low = i - 1;

			if (i + 1 < n && str.charAt(i) == str.charAt(i + 1))
				high = i + 2;
			else
				high = i + 1;

			while (low >= 0 && high < n && str.charAt(low) == str.charAt(high)) {
				if (high - low + 1 > maxLength) {
					start = low;
					maxLength = high - low + 1;
				}

				low--;
				high++;
			}
		}
		System.out.println("The max pallendromic string is...." + str.substring(start, start + maxLength));

	}

	public static void main(String[] args) throws IOException {
		InputStreamReader i = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(i);

		String str = br.readLine();

		pallenDrumUsingDP(str);

		logestPallendromicString(str);

	}

}
