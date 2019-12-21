package DynamicProgramming;

public class PallendrumPartitionWithCuts {

	static int minCut(String str) {
		int n = str.length();
		int[][] dp = new int[n][n];
		int[][] comparedDp = new int[n][n];
		int cut[] = new int[n];
		int x = 0;

		for (int j = 0; j < n; j++) {
			cut[j] = j;
			for (int i = 0; i <= j; i++) {

				if (str.charAt(i) == str.charAt(j) && (j - i <= 1 || dp[i + 1][j - 1] == 1)) {

					dp[i][j] = 1;

					comparedDp[i][j] = ++x;

					if (i > 0) {
						cut[j] = Math.min(cut[j], cut[i - 1] + 1);
					} else {
						cut[j] = 0;
					}
				}
			}

		}

		String result = "";

		int sidx = 0, eidx = n - 1, nidx = 0;
		for (int y = 0; y < dp.length;) {
			sidx = y;
			eidx = n - 1;
			if (dp[y][sidx] == 1) {
				while (dp[y][eidx] != 1) {
					eidx--;
				}
				nidx = eidx;
				if (sidx <= eidx) {
					while (sidx <= eidx && dp[y][sidx] == dp[y][eidx]) {
						sidx++;
						eidx--;
					}
				}

				result = result + str.substring(y, nidx + 1) + "|";
				y = nidx + 1;

			} else {
				y++;
			}

		}

		System.out.println("\n The result string with cuts is " + result + "\n");

		System.out.println("The comparisions matrix is \n");

		for (int i = 0; i < n; i++) {
			for (int k = 0; k < n; k++) {
				System.out.print(comparedDp[i][k] + "\t");
			}
			System.out.println("\n");
		}

		System.out.println("The dp matrix is \n");

		for (int i = 0; i < n; i++) {
			for (int k = 0; k < n; k++) {
				System.out.print(dp[i][k] + "\t");
			}
			System.out.println("\n");
		}

		System.out.println("\nThe cuts array is \n");

		for (int i = 0; i < n; i++) {
			System.out.print(cut[i] + "\t");
		}

		return cut[n - 1];
	}

	public static void main(String[] args) {
		String str = "mamdam";
		System.out.println("Min cuts needed for " + "Palindrome Partitioning" + " is " + minCut(str));

	}

}
