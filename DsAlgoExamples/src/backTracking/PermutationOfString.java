package backTracking;

import java.util.HashMap;
import java.util.Map;

public class PermutationOfString {
	HashMap<String, Integer> map;
	int total = 0;

	static String swap(String str, int i, int j) {
		char temp;
		char[] strInChars = str.toCharArray();
		temp = strInChars[i];
		strInChars[i] = strInChars[j];
		strInChars[j] = temp;

		return String.valueOf(strInChars);

	}

	static void permute(String str, int start, int end) {
		if (start == end) {

			System.out.println(str);
			return;
		}

		for (int current = start; current <= end; current++) {
			str = swap(str, start, current);
			permute(str, start + 1, end);
			str = swap(str, start, current);

		}
	}

	void swapC(char[] str, int i, int j) {
		char temp;

		temp = str[i];
		str[i] = str[j];
		str[j] = temp;

		// return String.valueOf(strInChars);

	}

	void permuteC(char[] str, int start, int end) {
		if (start == end) {
			if (!this.map.containsKey(String.valueOf(str))) {
				this.map.put(String.valueOf(str), total++);
			}

			// System.out.println(String.valueOf(str));
			return;
		}

		for (int current = start; current <= end; current++) {
			swapC(str, start, current);
			permuteC(str, start + 1, end);
			swapC(str, start, current);

		}
	}

	public static void main(String[] args) {
		String str = "ABCD";

		permute(str, 0, str.length() - 1);

		int a = 2;

		a += a++;

		System.out.println("\n a value is ..." + a);

		System.out.println("\n Now with character array \n \n");
		PermutationOfString ps = new PermutationOfString();

		char[] chars = new char[] { 'A', 'B', 'C', 'A' };

		ps.map = new HashMap<String, Integer>();

		ps.permuteC(chars, 0, chars.length - 1);

		for (Map.Entry me : ps.map.entrySet()) {
			System.out.println(me.getKey() + "\t" + me.getValue());

		}

	}

}
