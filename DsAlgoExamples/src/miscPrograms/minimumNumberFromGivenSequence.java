package miscPrograms;

import java.io.IOException;

public class minimumNumberFromGivenSequence {

	// Returns minimum number made from given sequence without repeating digits
	static String getMinNumberForPattern(String seq) {
		int n = seq.length();

		if (n >= 9)
			return "-1";

		char result[] = new char[n + 1];

		int count = 1;

		// The loop runs for each input character as well as
		// one additional time for assigning rank to each remaining characters
		for (int i = 0; i <= n; i++) {
			if (i == n || seq.charAt(i) == 'I') {
				for (int j = i - 1; j >= -1; j--) {
					result[j + 1] = (char) ((int) '0' + count++);
					if (j >= 0 && seq.charAt(j) == 'I')
						break;
				}
			}
		}
		return new String(result);
	}

	public static void main(String[] args) throws IOException {
		String inputs[] = { "I", "D", "IDID","DD", "II", "DIDI", "IIDDD", "DDIDDIID" };

		for (String input : inputs) {
			System.out.println(getMinNumberForPattern(input));
		}
	}
}
