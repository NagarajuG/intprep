package DynamicProgramming;

import java.util.Dictionary;
import java.util.HashMap;

public class WordUsingDice {

	static boolean checkWordWithDice(char[][] diceM, String s1) {

		HashMap<Integer, String> map = new HashMap<Integer, String>();

		for (int i = 0; i < diceM.length; i++) {
			boolean m1 = false;
			String s2 = s1;
			for (int j = 0; j < 6; j++) {
				Character cs = diceM[i][j];
				if (s2.contains(cs.toString())) {
					m1 = true;
					// int val = i;
					if (map.containsKey(i)) {
						String newcs = map.get(i) + cs.toString();
						map.put(i, newcs);

					} else {
						map.put(i, cs.toString());
					}

				}
			}

			if (!m1) {
				return false;
			}
		}

		String iteration = s1;

		for (int i = 0; i < diceM.length; i++) {
			String cs = map.get(i);
			if (cs.length() == 1) {
				iteration = iteration.replace(cs, "");
				map.remove(i);
			} else {
				map.put(i, cs);

			}
		}
		
		

		System.out.println("The remaing string is ..." + iteration);

		return true;
	}

	public static void main(String[] args) {
		String s1 = "hello";
		char[][] dice = new char[][] { { 'a', 'l', 'c', 'd', 'e', 'f' }, { 'a', 'b', 'c', 'd', 'e', 'f' },
				{ 'a', 'b', 'c', 'h', 'e', 'f' }, { 'a', 'b', 'c', 'd', 'o', 'f' }, { 'a', 'b', 'c', 'l', 'e', 'f' } };

		checkWordWithDice(dice, s1);

	}

}
