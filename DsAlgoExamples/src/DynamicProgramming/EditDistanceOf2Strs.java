package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EditDistanceOf2Strs {

	static int subStrLen(String s1, String s2) {
		int n1 = s1.length();
		int n2 = s2.length();
		int[][] sol = new int[n1 + 1][n2 + 1];
		int max = 0;

		for (int i = 0; i < n1 + 1; i++) {
			for (int j = 0; j < n2 + 1; j++) {
				if (i == 0 || j == 0) {
					sol[i][j] = 0;
				} else {
					if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
						sol[i][j] = 1 + sol[i - 1][j - 1];
					} else {
						sol[i][j] = Math.max(sol[i][j - 1], sol[i - 1][j]);
					}
				}

				if (sol[i][j] > max)
					max = sol[i][j];

			}
		}

		return n2 - max;
	}

	static int simplest(String s1, String s2) {
		String s3 = s2;
		for (int i = 0; i < s1.length(); i++) {
			Character pchar = s1.charAt(i);
			s3 = s3.replaceFirst(pchar.toString(), "");
		}

		return s3.length();
	}

	static int opsRequired(String s1, String s2) {
		if (s1.length() == 0)
			return s2.length();
		else if (s2.length() == 0)
			return s1.length();
		else
			return subStrLen(s1, s2);
	}

	public static void main(String[] args) throws IOException {
		InputStreamReader i = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(i);

		System.out.println("\nEnter 2 strings\n");

		String s1 = br.readLine();
		String s2 = br.readLine();

		int n = opsRequired(s1, s2);

		System.out.println("\n The distance is \t" + n);

		n = simplest(s1, s2);

		System.out.println("\n The simplest answer  is \t" + n);

	}

}
