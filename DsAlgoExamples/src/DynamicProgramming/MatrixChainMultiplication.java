package DynamicProgramming;

public class MatrixChainMultiplication {

	char name = 'A';

	void printParenthesis(int start, int end, int[][] sol) {
		if (start == end) {
			System.out.print(name);
			name++;

			return;
		}
		System.out.print("(");
		printParenthesis(start, sol[start][end], sol);
		printParenthesis(sol[start][end] + 1, end, sol);

		System.out.print(")");

	}

	static int minOpsMatrixMultiplication(int[] arr) {
		int n = arr.length;
		int[][] m = new int[n][n];
		int[][] s = new int[n][n];
		int q = 0, j, min;

		for (int i = 0; i < n; i++) {
			m[i][i] = 0;
			s[i][i] = 0;
		}

		for (int diff = 1; diff < n - 1; diff++) {
			for (int row = 1; row < n - diff; row++) {
				j = row + diff;
				/*
				 * if (j == n) continue;
				 */
				min = Integer.MAX_VALUE;

				for (int k = row; k <= j - 1; k++) {
					q = m[row][k] + m[k + 1][j] + arr[row - 1] * arr[k] * arr[j];

					if (q < min) {
						min = q;
						s[row][j] = k;
						m[row][j] = min;
					}
				}
			}
		}

		System.out.println("Products matrix \n");

		for (int i = 1; i < n; i++) {
			for (int k = 1; k < n; k++) {
				System.out.print(m[i][k] + "\t");
			}
			System.out.println("\n");
		}

		System.out.println("Parenthesis matrix\n");

		for (int i = 1; i < n; i++) {
			for (int k = 1; k < n; k++) {
				System.out.print(s[i][k] + "\t");
			}
			System.out.println("\n");
		}

		MatrixChainMultiplication mc = new MatrixChainMultiplication();

		mc.printParenthesis(1, n - 1, s);

		return m[1][n - 1];

	}

	public static void main(String[] args) {
		int[] arr = new int[] { 40, 20, 30, 10, 30 };


		System.out.println("The minimum multiplications required " + minOpsMatrixMultiplication(arr));

	}

}
