package miscAlgos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KnuthMorrisPratt {
	void prepareLps(String s2, int[] lps, int size) {
		int i = 1;
		int len = 0;
		lps[len] = 0;

		while (i < size) {
			if (s2.charAt(i) == s2.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			} else {
				if (len != 0) {
					len = lps[len - 1];

				} else {
					lps[i] = len;
					i++;
				}
			}
		}
	}

	void findPattern(String s1, String s2) {
		int n1 = s1.length();
		int n2 = s2.length();

		int[] lps = new int[n2];

		this.prepareLps(s2, lps, n2);
		int i = 0, j = 0;

		while (i < n1) {
			if (s1.charAt(i) == s2.charAt(j)) {
				i++;
				j++;

				if (j == n2) {
					System.out.println("The Sring found at " + (i - j));
					j = lps[j - 1];
				}
			} else {
				if (j != 0)
					j = lps[j - 1];
				else
					i++;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		InputStreamReader i = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(i);
		System.out.println("Enter the 2 strings\n");

		String s1 = br.readLine();
		String s2 = br.readLine();

		KnuthMorrisPratt kmp = new KnuthMorrisPratt();

		kmp.findPattern(s1, s2);

	}

}
