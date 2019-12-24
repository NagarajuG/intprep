package leetCode;
/*
 * 
 * Given a 2D board and a word, find if the word exists in the grid.

	The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring.
	 The same letter cell may not be used more than once.
	
	Example:
	
	board =
	[
	  ['A','B','C','E'],
	  ['S','F','C','S'],
	  ['A','D','E','E']
	]
	
	Given word = "ABCCED", return true.
	Given word = "SEE", return true.
	Given word = "ABCB", return false.
 */

public class WordSearch79 {
	private int rows;
	private int cols;

	public boolean exist(char[][] board, String word) {
		this.rows = board.length;
		this.cols = board[0].length;
		int index = 0;

		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.cols; j++) {
				if (board[i][j] == word.charAt(index)) {
					if (checkExist(board, word, index, i, j)) {
						return true;
					}
				}
			}
		}

		return false;
	}

	private boolean checkExist(char[][] board, String word, int index, int row, int col) {
		if (row < 0 || col < 0 || row >= this.rows || col >= this.cols || board[row][col] != word.charAt(index)) {
			return false;
		}

		if (index == word.length() - 1 && board[row][col] == word.charAt(index)) {
			return true;
		}

		char ch = board[row][col];
		board[row][col] = ' ';

		boolean found = checkExist(board, word, index + 1, row, col + 1)
				|| checkExist(board, word, index + 1, row, col - 1) || checkExist(board, word, index + 1, row + 1, col)
				|| checkExist(board, word, index + 1, row - 1, col);

		board[row][col] = ch;

		return found;

	}

	public static void main(String[] args) {

	}

}
