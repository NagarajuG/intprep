package DynamicProgramming;

public class OptimalBinarySearchTree {

	int getSum(int[] freq, int start, int end) {
		int s = 0;
		for (int i = start; i <= end; i++) {
			if (i >= freq.length)
				continue;
			s += freq[i];
		}

		return s;
	}

	int optimalSearchTree(int[] keys, int[] freq, int n) {
		int[][] cost = new int[n + 1][n + 1];
		int[][] s = new int[n + 1][n + 1];

		for (int i = 0; i < n; i++) {
			cost[i][i] = freq[i];
			s[i][i] = 0;
		}

		for (int diff = 1; diff < n; diff++) {
			for (int row = 0; row <= n - diff; row++) {
				int j = row + diff;
				cost[row][j] = Integer.MAX_VALUE;

				for (int k = row; k <= j; k++) {
					int c = ((row < k) ? cost[row][k - 1] : 0) + ((k < j) ? cost[k + 1][j] : 0) + getSum(freq, row, j);

					if (c < cost[row][j]) {
						cost[row][j] = c;
						s[row][j] = k;
					}

				}

			}

		}

		System.out.println("Costs matrix \n");

		for (int i = 0; i < n; i++) {
			for (int k = 0; k < n; k++) {
				System.out.print(cost[i][k] + "\t");
			}
			System.out.println("\n");
		}

		System.out.println("nodes matrix\n");

		for (int i = 0; i < n; i++) {
			for (int k = 0; k < n; k++) {
				System.out.print(s[i][k] + "\t");
			}
			System.out.println("\n");
		}

		return cost[0][n - 1];

	}

	int modifiedOptimalSearchTree(int[] keys, int[] freq, int n) {
		int[][] cost = new int[n + 1][n + 1];
		int[][] s = new int[n + 1][n + 1];

		int[][] sum = new int[n + 1][n + 1];

		for (int i = 0; i < n; i++) {
			cost[i][i] = freq[i];
			s[i][i] = 0;
		}

		for (int a = 0; a < n; a++) {
			int p = freq[a];
			sum[a][a] = p;

			for (int b = a + 1; b < n; b++) {
				p += freq[b];
				sum[a][b] = p;

			}
		}

		for (int diff = 1; diff < n; diff++) {
			for (int row = 0; row <= n - diff; row++) {
				int j = row + diff;
				cost[row][j] = Integer.MAX_VALUE;

				for (int k = row; k <= j; k++) {
					int c = ((row < k) ? cost[row][k - 1] : 0) + ((k < j) ? cost[k + 1][j] : 0) + sum[row][j];

					if (c < cost[row][j]) {
						cost[row][j] = c;
						s[row][j] = k;
					}

				}

			}

		}

		System.out.println("Sums matrix \n");

		for (int i = 0; i < n; i++) {
			for (int k = 0; k < n; k++) {
				System.out.print(sum[i][k] + "\t");
			}
			System.out.println("\n");
		}

		System.out.println("Costs matrix \n");

		for (int i = 0; i < n; i++) {
			for (int k = 0; k < n; k++) {
				System.out.print(cost[i][k] + "\t");
			}
			System.out.println("\n");
		}

		System.out.println("nodes matrix\n");

		for (int i = 0; i < n; i++) {
			for (int k = 0; k < n; k++) {
				System.out.print(s[i][k] + "\t");
			}
			System.out.println("\n");
		}

		return cost[0][n - 1];

	}

	public static void main(String[] args) {
		int keys[] = { 10, 20, 30, 40 };
		int freq[] = { 4, 2, 6, 3 };
		int n = keys.length;
		OptimalBinarySearchTree obst = new OptimalBinarySearchTree();

		System.out.println("Cost of Optimal BST is " + obst.optimalSearchTree(keys, freq, n));

		System.out.println(
				"\nCost of Optimal BST is with modified method " + obst.modifiedOptimalSearchTree(keys, freq, n));

	}

}
