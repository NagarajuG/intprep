package PreviousQuestions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class AllBracketsValidation {

	static void validateExpression(String str) {
		int n = str.length();

		if (n == 0) {
			System.out.println("Valid Expression!!!");
			return;
		}

		char top;
		Stack<Character> stack = new Stack<>();
		stack.push('a');

		for (int i = 0; i < n; i++) {
			char ch = str.charAt(i);

			if (ch == '(' || ch == '{' || ch == '[') {
				stack.push(ch);
			} else {
				top = stack.peek();
				if (top == 'a') {
					System.out.println("Invalid expression !!!\n");
					return;
				}

				top = stack.pop();

				if (top == '(' && ch == ')')
					continue;
				else if (top == '{' && ch == '}')
					continue;
				else if (top == '[' && ch == ']')
					continue;
				else {
					System.out.println("Invalid expression !!! \n");
					return;
				}
			}
		}

		System.out.println("Valid expression!!! \n");
	}

	public static void main(String[] args) throws IOException {
		InputStreamReader i = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(i);

		String str = br.readLine();

		validateExpression(str);

	}

}
