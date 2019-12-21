package backTracking;

public class test {

	public static void printAllPath(int a[][], int i, int j, int m, int n, String str) {
		if (i < m || j < n)
			return;
		
		if(a[i][j] != 1)
			return;

		if (i == m && j == n) {
			str = str + "(" + i + ", " + j + ")" + "\t";
			System.out.println(str);
			return;
		}

		str = str + "(" + i + ", " + j + ")" + "\t";
		printAllPath(a, i - 1, j, m, n, str);
		printAllPath(a, i, j - 1, m, n, str);
	}

	public static void main(String args[]) {
		int a[][] = { { 1, 1, 1, 1, 1 }, { 0, 1, -1, 0, 1 }, { 1, 1, 1, -1, 0 }, { 1, 1, 1, 0, 1 }, { 0, 1, 1, 1, 0 } };
		int m = 1;
		int n = 1;
		printAllPath(a, 4, 3, m, n, "");
	}

}
