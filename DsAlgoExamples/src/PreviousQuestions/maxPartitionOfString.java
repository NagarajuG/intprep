package PreviousQuestions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Partitioning the string of maximum cuts such that a character will not appear in other partition */
public class maxPartitionOfString {

	public static void main(String[] args) throws IOException {
		InputStreamReader i = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(i);

		String str = br.readLine();

		int[] lastIndex = new int[26];
		for (int j = 0; j < str.length(); j++) {
			lastIndex[str.charAt(j) - 'a'] = j;

		}

		int start = 0, end = 0;

		for (int j = 0; j < str.length(); j++) {
			if (lastIndex[str.charAt(j) - 'a'] > end) {
				end = lastIndex[str.charAt(j) - 'a'];
			}

			if (end == j) {
				System.out.println(end - start + 1);
				System.out.println(str.substring(start, end + 1));
				start = end + 1;
				end = 0;
			}

		}

	}

}
