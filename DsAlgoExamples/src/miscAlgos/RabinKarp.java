package miscAlgos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RabinKarp {
	static final int cbound = 256;

	static void search(String txt, String pat, int q) {
		int plen = pat.length();
		int tlen = txt.length();
		int hval = 1, tval = 0, pval = 0;

		for (int i = 0; i < plen - 1; i++) {
			hval = (hval * cbound) % q;
		}

		for (int i = 0; i < plen; i++) {
			pval = (cbound * pval + ((int) pat.charAt(i))) % q;
			tval = (cbound * tval + ((int) txt.charAt(i))) % q;
		}

		for (int i = 0; i <= tlen - plen; i++) {
			if (pval == tval) {
				int j = 0;
				for (; j < plen; j++) {
					if (pat.charAt(j) != txt.charAt(i + j))
						break;
				}
				if (j == plen) {
					System.out.println("The pattern found at.. " + i);
				}
			} else {
				tval = (cbound * (tval - ((int) txt.charAt(i)) * hval) + (int) txt.charAt(i + plen)) % q;

				if (tval < 0)
					tval = tval + q;
			}

		}
	}

	public static void main(String[] args) throws IOException {
		InputStreamReader i = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(i);

		System.out.println("Enter Text and pattern \n");

		String txt = br.readLine();
		String pat = br.readLine();
		int q = 101; // some prime number

		search(txt, pat, q);

	}

}
