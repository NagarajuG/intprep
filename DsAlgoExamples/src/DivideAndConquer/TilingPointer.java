package DivideAndConquer;

public class TilingPointer {

	void display(int A[][], int N) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(A[i][j] + "\t");
			}
			System.out.println("");
		}
		System.out.println("\n");
	}

	void Tiling(int A[][], int N, int m, int n, int x, int y) {
		if (N == 2) {
			for (int i = m; i < m + N; i++) {
				for (int j = n; j < n + N; j++) {
					if (A[i][j] != 1)
						A[i][j] = 1;
				}
			}
			display(A, 8);
		} else {
			int p = N / 2;
			int m1 = m+0, m2 = m+0, m3 = m+p, m4 = m+p;
			int n1 = n+0, n2 = n+p, n3 = n+0, n4 = n+p;

			if (x >= m1 && x < m1 + p && y >= n1 && y < n1 + p) {
				A[p][p] = 1;
				A[p - 1][p] = 1;
				A[p][p - 1] = 1;

				Tiling(A, p, m1, n1, x, y);
				Tiling(A, p, m2, n2, p - 1, p);
				Tiling(A, p, m3, n3, p, p - 1);
				Tiling(A, p, m4, n4, p, p);
			} else if (x >= m2 && x < m2 + p && y >= n2 && y < n2 + p) {
				A[p][p] = 1;
				A[p - 1][p - 1] = 1;
				A[p][p - 1] = 1;

				Tiling(A, p, m4, n4, p, p);
				Tiling(A, p, m2, n2, x, y);
				Tiling(A, p, m1, n1, p - 1, p - 1);
				Tiling(A, p, m3, n3, p, p - 1);

			} else if (x >= m3 && x < m3 + p && y >= n3 && y < n3 + p) {
				A[p][p] = 1;
				A[p - 1][p - 1] = 1;
				A[p - 1][p] = 1;

				Tiling(A, p, m1, n1, p - 1, p - 1);
				Tiling(A, p, m2, n2, x, y);
				Tiling(A, p, m3, n3, p - 1, p);
				Tiling(A, p, m4, n4, p, p);
			} else if (x >= m4 && x < m4 + p && y >= n4 && y < n4 + p) {
				A[p - 1][p] = 1;
				A[p - 1][p - 1] = 1;
				A[p][p - 1] = 1;

				Tiling(A, p, m1, n1, p - 1, p - 1);
				Tiling(A, p, m2, n2, x, y);
				Tiling(A, p, m3, n3, p, p - 1);
				Tiling(A, p, m4, n4, p - 1, p);
			}

		}
	}

	public static void main(String[] args) {
		int A[][] = new int[8][8];
		TilingPointer tp = new TilingPointer();
		

		int x = 3, y = 4;

		A[x][y] = 1;

		System.out.println("\nInitial condition is\n");

		tp.display(A, 8);

		System.out.println("\nFinal soulution is\n");

		tp.Tiling(A, 8, 0, 0, x, y);

		tp.display(A, 8);

	}

}
