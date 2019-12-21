package PreviousQuestions;

public class TPArrayMovements {
	static int solve(int n, int h) {
		int[][] sol = new int[h][n + 1];

		sol[0][n] = 1;

		System.out.println("Before solution \n");

		for (int i = 0; i < sol.length; i++) {
			for (int j = 0; j < sol[0].length; j++) {
				System.out.print(sol[i][j] + "\t");

			}
			System.out.println("\n");
		}

		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j < h; j++) {
				sol[j][i] = sol[j][i] + sol[j][i + 1];

				if (j + 1 < h)
					sol[j][i] = sol[j][i] + sol[j + 1][i + 1];
				if (j - 1 >= 0)
					sol[j][i] = sol[j][i] + sol[j - 1][i + 1];

			}
		}

		System.out.println("\n");

		for (int i = 0; i < sol.length; i++) {
			for (int j = 0; j < sol[0].length; j++) {
				System.out.print(sol[i][j] + "\t");

			}
			System.out.println("\n");
		}

		return sol[0][n];
	}

	public static void main(String[] args) {
		System.out.println("The no of possible ways to stay at index 0 after 3 moves is .." + solve(10, 10) + "\n");
	}

}
