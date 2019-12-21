package Graphs;

public class PrintAllPathsFromTopLeftToBottomRight {
	int M = 4;
	int N = 4;
	int count = 0;

	public void printAllPaths(int[][] arr, int i, int j, String str) {
		if (i > this.M || j > this.N) {
			return;
		}

		if (i == this.M && j == this.N) {
			str += "(" + i + "," + j + ")";
			System.out.println(str);
			this.count++;
		}

		str += "(" + i + "," + j + ")\t";
		printAllPaths(arr, i + 1, j, str);
		printAllPaths(arr, i, j + 1, str);
	}

	public static void main(String[] args) {
		PrintAllPathsFromTopLeftToBottomRight objAllPathsFromTopLeftToBottomRight = new PrintAllPathsFromTopLeftToBottomRight();
		int[][] arr = new int[4][4];
		String str = "";

		objAllPathsFromTopLeftToBottomRight.printAllPaths(arr, 0, 0, str);
		System.out.println("Total paths are ...\t" + objAllPathsFromTopLeftToBottomRight.count);

	}

}
