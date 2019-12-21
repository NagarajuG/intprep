package DynamicProgramming;

import java.util.HashMap;

public class SumOf2NosEqualsOther2Nos {

	static public class qElement {
		int sum, a, b;

		qElement(int s, int i, int j) {
			sum = s;
			a = i;
			b = j;
		}

	}

	static void checkQuebesSum(int n) {
		if (n < 1) {
			return;
		}

		int[] qubes = new int[n + 1];
		int[][] sums = new int[n + 1][n + 1];
		HashMap<Integer, qElement> map = new HashMap<Integer, qElement>();

		for (int i = 0; i < n + 1; i++) {
			qubes[i] = i * i * i;
		}

		for (int i = 1; i <= n; i++) {
			sums[i][i] = qubes[i];
			for (int j = i + 1; j <= n; j++) {

				sums[i][j] = qubes[i] + qubes[j];
				qElement ql = new qElement(sums[i][j], i, j);
				if (map.containsKey(sums[i][j])) {
					qElement q2 = map.get(sums[i][j]);
					System.out.println("The qubes sums matched for \t " + i + " +" + j + "\t=\t" + q2.a + " +" + q2.b);
				}

				map.put(sums[i][j], ql);

			}
		}

	}

	public static void main(String[] args) {
		int n = 1000;

		checkQuebesSum(n);

	}

}
