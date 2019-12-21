package backTracking;

public class Sudoku {
	
	

	static boolean isSafe(int[][] board, int val, int row, int col) {
		for (int i = 0; i < board.length; i++) {
			if (board[row][i] == val) {
				return false;
			}
		}

		for (int j = 0; j < board.length; j++) {
			if (board[j][col] == val)
				return false;
		}

		int srt = (int) Math.sqrt(board.length);
		int rs = row - (row % srt);
		int cs = col - (col % srt);

		for (int i = rs; i < rs + srt; i++) {
			for (int j = cs; j < cs + srt; j++) {
				if (board[i][j] == val)
					return false;
			}
		}

		return true;
	}
	
	static boolean solveSudoku(int[][] board, int N) {
		int row = -1, col = -1;
		boolean solved = true;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 0) {
					solved = false;
					row = i;
					col = j;
					break;
				}
			}
			if (!solved)
				break;
		}

		if (solved) {
			return true;
		}

		for (int k = 1; k <= N; k++) {
			if (isSafe(board, k, row, col)) {
				board[row][col] = k;
				if (solveSudoku(board, N)) {
					return true;
				} else {
					board[row][col] = 0;
				}

			}
		}

		return false;

	}

	static void printBoard(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print("\t" + board[i][j]);
			}
			System.out.println("\n");
		}

	}

	public static void main(String[] args) {
		int[][] board = new int[][] 
				{ 
					{ 3, 0, 6, 5, 0, 8, 4, 0, 0 },
					{ 5, 2, 0, 0, 0, 0, 0, 0, 0 },
					{ 0, 8, 7, 0, 0, 0, 0, 3, 1 },
					{ 0, 0, 3, 0, 1, 0, 0, 8, 0 },
					{ 9, 0, 0, 8, 6, 3, 0, 0, 5 },
					{ 0, 5, 0, 0, 9, 0, 6, 0, 0 },
					{ 1, 3, 0, 0, 0, 0, 2, 5, 0 },
					{ 0, 0, 0, 0, 0, 0, 0, 7, 4 },
					{ 0, 0, 5, 2, 0, 6, 3, 0, 0 }
				};
				
		int N = board.length;

		if (solveSudoku(board, N)) {
			System.out.println("\n The final solution is\n");
			printBoard(board); // print solution
		} else {
			printBoard(board);
			System.out.println("No solution");
		}

	}

}
