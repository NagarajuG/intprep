package DynamicProgramming;

public class MaxSizeSquareSubMatrix {

	static int maxSizeSquareMatrix(int[][] matrix, int length) {
		int[][] solution = new int[matrix.length + 1][matrix[0].length + 1];
		int max = 0;

		for (int i = 0; i < matrix.length + 1; i++) {
			for (int j = 0; j < matrix[0].length + 1; j++) {
				solution[i][j] = 0;
			}
		}

		for (int i = 1; i <= matrix.length; i++) {
			for (int j = 1; j <= matrix[0].length; j++) {
				if (matrix[i - 1][j - 1] == 0) {
					solution[i][j] = 0;
				} else if (matrix[i - 1][j - 1] != 0) {
					solution[i][j] = matrix[i - 1][j - 1]
							+ Math.min(solution[i - 1][j], Math.min(solution[i][j - 1], solution[i - 1][j - 1]));
				}
				if (solution[i][j] > max)
					max = solution[i][j];
			}
		}

		System.out.println("The solution matrix is \n");

		for (int i = 0; i <= matrix.length; i++) {
			for (int j = 0; j <= matrix[0].length; j++) {
				System.out.print(solution[i][j] + "\t");
			}
			System.out.println("\n");
		}

		return max;

	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 0, 1, 1, 0, 1 }, { 1, 1, 0, 1, 0 }, { 0, 1, 1, 1, 0 }, { 1, 1, 1, 1, 0 },
				{ 1, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0 } };

		int result = maxSizeSquareMatrix(matrix, matrix.length);

		System.out.println("The max length of sub matrix is" + result + "X" + result);

	}

}
