package backTracking;

public class ShortestSafeRoute {
	int M, N;
	int bestSol;

	boolean isSafe(int[][] mat, int row, int col) {
		if (row - 1 >= 0 && mat[row - 1][col] == 0)
			return false;
		if (row + 1 <= M - 1 && mat[row + 1][col] == 0)
			return false;
		if (col - 1 >= 0 && mat[row][col - 1] == 0)
			return false;
		if (col + 1 <= N - 1 && mat[row][col + 1] == 0)
			return false;

		// if (visited[row][col])
		// return false;

		return true;
	}

	boolean printUtil(int[][] mat, int row, int col, int total, String str) {
		if (col == this.N - 1) {
			if (this.bestSol > total) {
				this.bestSol = total;
			}
			System.out.println("The path is..." + str);
			System.out.println("Reached with cost .. " + total);
			return true;
		}

		// for (int r = row; r < this.M; r++) {
		for (int c = col; c < this.N; c++) {
			if (isSafe(mat, row, c)) {
				total++;
				str = str + "(" + row + "," + c + ")" + "\t";
				printUtil(mat, row, c + 1, total, str);

			}
			printUtil(mat, row + 1, c, total, str);
			// printUtil(mat, row - 1, c, total, str);

		}
		// }

		return true;

	}

	public static void main(String[] args) {
		int[][] mat = new int[][] { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 0, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 }, { 1, 0, 1, 1, 1, 1, 1, 1, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 0, 1, 1, 1, 1, 0, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 } };

		ShortestSafeRoute ssr = new ShortestSafeRoute();
		ssr.M = 12;
		ssr.N = 10;
		ssr.bestSol = Integer.MAX_VALUE;
		String str = "";
		// boolean[][] visited = new boolean[12][10];
		// Stack<>

		if (ssr.printUtil(mat, 4, 0, 0, str)) {
			System.out.println("The optimal solution is with ..." + ssr.bestSol);
		}

	}

}
