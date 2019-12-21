package leetCode;

/*
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

	Note: You can only move either down or right at any point in time.
	
	Example:
	
	Input:
	[
	  [1,3,1],
	  [1,5,1],
	  [4,2,1]
	]
	Output: 7
	Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */

public class MinimumPathSum64 {
	private int M;
	private int N;

	public int minPathSum(int[][] grid) {
		this.M = grid.length;
		this.N = grid[0].length;
		int[][] result = new int[this.M][this.N];

		result[0][0] = grid[0][0];
		for (int i = 0; i < this.M; i++) {
			for (int j = 0; j < this.N; j++) {
				result[i][j] = grid[i][j];
				int s1 = Integer.MAX_VALUE, s2 = Integer.MAX_VALUE;

				if (i > 0)
					s1 = grid[i][j] + result[i - 1][j];
				if (j > 0)
					s2 = grid[i][j] + result[i][j - 1];

				if (!(i == 0 && j == 0)) {
					result[i][j] = Math.min(s1, s2);
				}
			}
		}

		return result[this.M - 1][this.N - 1];
	}

	public static void main(String[] args) {

	}

}
