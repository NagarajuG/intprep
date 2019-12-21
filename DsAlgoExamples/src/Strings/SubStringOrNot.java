package Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class SubStringOrNot {

	public static void main(String[] args) throws IOException {
		String[] subStrs = new String[] { "i", "a", "am", "mam", "man" };
		InputStreamReader r = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(r);
		
		String testStr = br.readLine();
		
		for(int i = 0; i<subStrs.length;i++) {
			if(testStr.length() == 0) {
				System.out.println("TRUE");
				System.exit(0);
			}
			testStr = testStr.replaceAll(subStrs[i], "");
		}
		
		if(testStr.isEmpty())
			System.out.println("TRUE");
		else
			System.out.println("FALSE");
		

	}

}
