package Arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ParanthesisMatchingSimple {

	public static void main(String[] args) throws Exception {
		InputStreamReader r = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(r);

		String str = br.readLine();

		int count = 0;

		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '(') {
				count++;
			} else if(str.charAt(i) == ')') {
				count--;
				if(count < 0 ) {
					System.out.println("Invalid Parentheses expression");
					System.exit(1);
				}
			}
		}
		
		if(count == 0)
			System.out.println("Valid Expression");
		else
			System.out.println("Invalid Expression");

	}

}
