package gfgRecomGoogle;

import java.util.Scanner;

class EggDroppingPuzzle {
	static int eggDrop(int n, int k) {
		if(n == 0 || k == 0)
			return 0;
		
		if(k == 1)
			return n;
		
		int[][] eggfloor = new int[n + 1][k + 1];
		
		for (int i = 0; i <= n; i++) {
			eggfloor[i][1] = 1;
			eggfloor[i][0] = 0;
		}
		for (int i = 1; i <= k; i++) {
			eggfloor[1][i] = i;
		}
		
		for(int floor = n; floor >= 1;floor--) {
			for(int egg = 1;egg<=k;egg++) {
				eggfloor[floor][egg] = 0;
				
				int res = 1 + Math.max(eggfloor[floor][k-egg], eggfloor[n-floor][k]);
				
				if(res > eggfloor[floor][egg] ) {
					eggfloor[floor][egg] = res;
				}
			}
		}
		
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= k; j++) {
				System.out.print(eggfloor[i][j] + "\t");
			}
			System.out.println("\n");
		}
		
		System.out.println("The result is " + eggfloor[1][2]);
		
		
		return eggfloor[1][2];
		
		
		
	}
	
	public static void main(String[] args) {
		eggDrop(100,2);
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[][] eggfloor = new int[n + 1][k + 1];
			for (int i = 0; i <= n; i++) {
				eggfloor[i][1] = 1;
				eggfloor[i][0] = 0;
			}
			for (int i = 1; i <= k; i++) {
				eggfloor[1][i] = i;
			}

			for (int i = 2; i <= n; i++) {
				for (int j = 2; j <= k; j++) {
					eggfloor[i][j] = Integer.MAX_VALUE;
					for (int x = 1; x <= j; x++) {
						int res = 1 + Math.max(eggfloor[i - 1][x - 1], eggfloor[i][j - x]);
						if (res < eggfloor[i][j]) {
							eggfloor[i][j] = res;
						}

					}
				}
			}
			System.out.println(eggfloor[n][k] + "\n");

			for (int i = 0; i <= n; i++) {
				for (int j = 0; j <= k; j++) {
					System.out.print(eggfloor[i][j] + "\t");
				}
				System.out.println("\n");
			}

		}
		

		sc.close();

	}
}
