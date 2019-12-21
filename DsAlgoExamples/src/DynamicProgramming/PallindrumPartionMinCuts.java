package DynamicProgramming;

public class PallindrumPartionMinCuts {

	static int minCut(String str) {
		int sizeOfString = str.length();
		int[][] dp = new int[sizeOfString][sizeOfString];
		int[][] comparedDp = new int[sizeOfString][sizeOfString];
		int cut[] = new int[sizeOfString];
		int x = 0;

		for (int pivotPoint = 0; pivotPoint < sizeOfString; pivotPoint++) {
			cut[pivotPoint] = pivotPoint; // Assuming no pallendrums so far and all are different characters
			for (int iterateTillPivot = 0; iterateTillPivot <= pivotPoint; iterateTillPivot++) {
				// iterate from starting character till the current pivot character
				if (str.charAt(iterateTillPivot) == str.charAt(pivotPoint)
						&& (pivotPoint - iterateTillPivot <= 1 || dp[iterateTillPivot + 1][pivotPoint - 1] == 1)) {
					// if the current iterate character is same as pivot character AND
					// the difference between the current iterate point and pivot point is either 0
					// or 1 OR
					// the previous character dp[iteratePoint + 1][pivoitPoint - 1]should be
					// contributing to the ongoing pallendrum
					dp[iterateTillPivot][pivotPoint] = 1;
					// mark this character can contribute to pallendrum
					comparedDp[iterateTillPivot][pivotPoint] = ++x;

					if (iterateTillPivot > 0) {
						// if iteratePoint is greater than 0 ....which means the first and last
						// character are not matching
						// then the Minimum of current cut point, previous point +1 will be new cut
						// point;
						cut[pivotPoint] = Math.min(cut[pivotPoint], cut[iterateTillPivot - 1] + 1);
					} else {
						// entered into the case when the first and current pivot characters are
						// matching
						cut[pivotPoint] = 0;
					}
				}
			}

		}

		System.out.println("The comparisions matrix is \n");

		for (int i = 0; i < sizeOfString; i++) {
			for (int k = 0; k < sizeOfString; k++) {
				System.out.print(comparedDp[i][k] + "\t");
			}
			System.out.println("\n");
		}

		System.out.println("The dp matrix is \n");

		for (int iterateTillPivot = 0; iterateTillPivot < sizeOfString; iterateTillPivot++) {
			for (int k = 0; k < sizeOfString; k++) {
				System.out.print(dp[iterateTillPivot][k] + "\t");
			}
			System.out.println("\n");
		}

		System.out.println("\nThe cuts array is \n");

		for (int iterateTillPivot = 0; iterateTillPivot < sizeOfString; iterateTillPivot++) {
			System.out.print(cut[iterateTillPivot] + "\t");
		}

		return cut[sizeOfString - 1];
	}

	public static void main(String[] args) {
		String str = "abaacd";
		System.out.println("Min cuts needed for " + "Palindrome Partitioning" + " is " + minCut(str));

	}

}
