package gfgRecomGoogle;

import java.util.Random;
import java.util.Stack;

public class LongestValidParenthesis {

	public static int longestValidParentheses(String s) {
		int maxans = 0;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(-1);
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {
				stack.pop();
				if (stack.empty()) {
					stack.push(i);
				} else {
					maxans = Math.max(maxans, i - stack.peek());
				}
			}
		}
		System.out.println(maxans);
		return maxans;

	}

	public static void main(String[] args) {

		Random random = new Random();
		System.out.println(random.ints(5, 10));

		longestValidParentheses("))()(");

	}
}