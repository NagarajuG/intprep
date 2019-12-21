package backTracking;

public class NQueensPlacement {

	int[] columnForRow = new int[8];
	int total = 0;
	int count = 0;

	boolean checkrow(int row) {
		// System.out.println("\n in checkrow method");

		count++;

		for (int i = 0; i < row; i++) {
			int diff = Math.abs(columnForRow[row] - columnForRow[i]);
			if (diff == 0 || diff == row - i) {
				return false;
			}
		}

		return true;

	}

	void printBoard(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (columnForRow[i] == j) {
					System.out.print("X\t");
				} else {
					System.out.print("-\t");
				}

			}
			System.out.print("\n");
		}
		System.out.println("\n");
		total = total + 1;
	}

	void placeNQueen(int row, int n) {
		// System.out.println("\n in placeNQeen function with row as" + row);
		if (row == n) {
			printBoard(n);
			return;
		}

		for (int i = 0; i < n; i++) {
			columnForRow[row] = i;
			if (checkrow(row)) {
				placeNQueen(row + 1, n);
			}

		}
	}

	public static void main(String[] args) {
		NQueensPlacement nq = new NQueensPlacement();

		System.out.println("In main function");
		nq.placeNQueen(0, 4);

		System.out.println("The total no of solutions found is ... " + nq.total);

		System.out.println("The checkrow got called " + nq.count + "  times");

	}

}
