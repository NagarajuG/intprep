package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestCommonSubSequesnce {

	static void longestCommonSubSequence(String s1, String s2, int s1len, int s2len) {
		int[][] lengths = new int[s1len + 1][s2len + 1];

		for (int i = 0; i <= s1len; i++) {
			for (int j = 0; j <= s2len; j++) {
				if (i == 0 || j == 0)
					lengths[i][j] = 0;
				else if (s1.charAt(i - 1) == s2.charAt(j - 1))
					lengths[i][j] = lengths[i - 1][j - 1] + 1;
				else
					lengths[i][j] = Math.max(lengths[i][j - 1], lengths[i - 1][j]);

			}
		}

		System.out.println("\n the lengths matrix is \n");

		for (int i = 0; i <= s1len; i++) {
			for (int j = 0; j <= s2len; j++) {
				System.out.print(lengths[i][j] + "\t");

			}
			System.out.println("\n");
		}

		int i = s1len, j = s2len;

		String result = "";

		while (i > 0 && j > 0) {
			if (lengths[i][j] == lengths[i - 1][j - 1] + 1) {
				result = s2.charAt(i -1) + result;
				i--;
				j--;
			} else if (lengths[i][j] == lengths[i - 1][j]) {
				i--;
			} else {
				j--;
			}
		}
		
		System.out.println("Result is \t" + result);

		System.out.println("The length of longest sub sequence is " + lengths[s1len][s2len]);

	}

	public static void main(String[] args) throws IOException {
		InputStreamReader i = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(i);

		String s1 = br.readLine();
		String s2 = br.readLine();

		longestCommonSubSequence(s1, s2, s1.length(), s2.length());

		br.close();
		i.close();

	}

}
