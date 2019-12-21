package DynamicProgramming;

public class SubSetSumEqualsN {

	static boolean isSubSetSum(int[] arr, int n, int sum) {
		boolean[][] solution = new boolean[sum + 1][n + 1];

		for (int i = 0; i <= n; i++) {
			solution[0][i] = true;
		}

		for (int j = 1; j <= sum; j++) {
			solution[j][0] = false;
		}

		for (int i = 1; i <= sum; i++) {
			for (int j = 1; j <= n; j++) {
				solution[i][j] = solution[i][j - 1];
				if (i >= arr[j - 1]) {
					solution[i][j] = solution[i][j] || solution[i - arr[j - 1]][j - 1];
					if(i== sum && solution[i-arr[j-1]][j-1]) {
						printSolution(solution, arr, sum, j-1 );
					}
				}
			}
		}

		// System.out.println("The DP matrix is like below \n");

		/*
		 * for (int i = 0; i <= sum; i++) { System.out.print(i + "-> \t"); for (int j =
		 * 0; j <= n; j++) { System.out.print(solution[i][j] + "\t"); }
		 * System.out.println("\n"); }
		 */

		return solution[sum][n];
	}
	
	static void printSolution(boolean[][] solution, int[] arr, int sum, int idx) {
		int x = arr[idx];
		String result =  arr[idx] + "\t";
		int m = sum - x;
		int n = idx;
		
		while(solution[m][n] == true) {
			if(x + arr[n-1] == sum) {
				result = result + arr[n -1] + "\t";
				System.out.println("The result is \t" + result);
				return;
			} else {
				n--;
			}
			
			if(solution[m][n] == false) {
				x += arr[n];
				result = result + arr[n] + "\t";
				m = sum - x;
				n = sum -x;
			}
			
			if(n < 0)
				return;
		}
	}

	public static void main(String[] args) {
		int set[] = { 3, 34, 4, 12, 5, 1, 2 };
		int sum = 8;
		int n = set.length;
		if (isSubSetSum(set, n, sum) == true)
			System.out.println("Found a subset" + " with given sum");
		else
			System.out.println("No subset with" + " given sum");

	}

}
