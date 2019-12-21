package Graphs;

public class FloodFillVariation {

	static int M = 8;
	static int N = 8;

	int maxTotal = 0;
	int total = 0;

	void floodFillUtil(int screen[][], boolean[][] visited, int x, int y, int prevC) {
		// Base cases
		if (x < 0 || x >= M || y < 0 || y >= N)
			return;

		if (screen[x][y] != prevC)
			return;

		// Replace the color at (x, y)
		if (screen[x][y] == prevC && !visited[x][y]) {
			this.total++;
			visited[x][y] = true;
		}

		// Recur for north, east, south and west
		if (x + 1 < M && !visited[x + 1][y])
			floodFillUtil(screen, visited, x + 1, y, prevC);
		if (x - 1 >= 0 && !visited[x - 1][y])
			floodFillUtil(screen, visited, x - 1, y, prevC);
		if (y + 1 < N && !visited[x][y + 1])
			floodFillUtil(screen, visited, x, y + 1, prevC);
		if (y - 1 >= 0 && !visited[x][y - 1])
			floodFillUtil(screen, visited, x, y - 1, prevC);

		if (this.total > this.maxTotal) {
			this.maxTotal = this.total;
		}

	}

	void floodFill(int screen[][], int x, int y) {
		boolean[][] visited = new boolean[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					int prevC = screen[i][j];
					this.total = 0;
					floodFillUtil(screen, visited, i, j, prevC);

				}
			}
		}

	}

//Driver code 
	public static void main(String[] args) {
		int screen[][] = { { 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 0, 0 }, { 1, 0, 0, 1, 1, 0, 1, 1 },
				{ 1, 2, 2, 2, 2, 0, 1, 0 }, { 1, 1, 1, 2, 2, 0, 1, 0 }, { 1, 1, 1, 2, 2, 2, 2, 0 },
				{ 1, 1, 1, 1, 1, 2, 1, 1 }, { 1, 1, 1, 1, 1, 2, 2, 1 }, };
		// int x = 4, y = 4, newC = 3;
		FloodFillVariation ffv = new FloodFillVariation();
		ffv.floodFill(screen, 3, 2);

		System.out.println("Updated screen after call to floodFill: ");
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++)
				System.out.print(screen[i][j] + " ");
			System.out.println();
		}

		System.out.println("The max length of connected color is .." + ffv.maxTotal);
	}
}
