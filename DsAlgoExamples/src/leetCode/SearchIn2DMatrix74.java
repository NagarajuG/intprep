package leetCode;

/*
 * 
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

	Integers in each row are sorted from left to right.
	The first integer of each row is greater than the last integer of the previous row.
		
	Example 1:
		
		Input:
		matrix = [
		  [1,   3,  5,  7],
		  [10, 11, 16, 20],
		  [23, 30, 34, 50]
		]
		target = 3
		Output: true
	
	Example 2:
		
		Input:
		matrix = [
		  [1,   3,  5,  7],
		  [10, 11, 16, 20],
		  [23, 30, 34, 50]
		]
		target = 13
		Output: false
 */
public class SearchIn2DMatrix74 {
	public boolean searchMatrix(int[][] matrix, int target) {
		int rowMax = matrix.length;
		int colMax = matrix[0].length;
		int pivotIndex, pivot, left = 0, right = rowMax * colMax - 1;

		while (left <= right) {
			pivotIndex = (left + right) / 2;
			pivot = matrix[pivotIndex / rowMax][pivotIndex % colMax];

			if (target == pivot) {
				return true;
			} else {
				if (target > pivot) {
					left = pivotIndex + 1;
				} else {
					right = pivotIndex - 1;
				}
			}
		}

		return false;
	}

}
