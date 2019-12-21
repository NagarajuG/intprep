package Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class QuickSums {
	static int n, min, des, numplus;
	static boolean plus[];
	static String nums;

	public int minSums(String numbers, int sum) {
		n = numbers.length();
		des = sum;
		numplus = 0;
		nums = new String(numbers);
		plus = new boolean[n - 1];
		min = n;
		genPlus(0);
		if (min < n)
			return min;
		return -1;
	}

	void genPlus(int i) {
		if (i + 1 < n) {
			plus[i] = true;
			numplus++;
			genPlus(i + 1);
			plus[i] = false;
			numplus--;
			genPlus(i + 1);
		} else {
			String manip = "";
			manip += nums.substring(0, 1);
			for (int j = 1; j < n; j++) {
				if (plus[j - 1])
					manip += "+";
				manip += nums.substring(j, j + 1);
			}

			// compute sum
			int s = 0;
			StringTokenizer k = new StringTokenizer(manip, "+");
			while (k.hasMoreTokens()) {
				String st = k.nextToken();
				for (int a = 0; a < st.length(); a++) {
					if (st.charAt(a) != '0') {
						st = st.substring(a);
						break;
					}
				}
				if (st.charAt(0) == '0')
					st = "0";
				if (st.length() > 3) {
					s = -1;
					break;
				}
				s += Integer.parseInt(st);
			}
			if (s == des) {
				min = Math.min(min, numplus);
				System.out.println(manip);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		InputStreamReader i = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(i);

		String numbers = br.readLine();

		int sum = 45;

		QuickSums qs = new QuickSums();
		qs.minSums(numbers, sum);

	}
}
