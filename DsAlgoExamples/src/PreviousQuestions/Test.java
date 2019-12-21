package PreviousQuestions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Test {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> resultList = new ArrayList<List<Integer>>();

		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();

		TreeNode node = root;
		stack1.push(node);

		while (!stack1.isEmpty() || !stack2.isEmpty()) {
			List<Integer> list1 = new ArrayList<Integer>();
			while (!stack1.isEmpty()) {
				TreeNode cNode = stack1.pop();

				if (cNode != null) {
					if (cNode.left != null)
						stack2.push(cNode.left);

					if (cNode.right != null)
						stack2.push(cNode.right);

					list1.add(cNode.val);

				}
			}

			if (list1.size() > 0)
				resultList.add(list1);

			List<Integer> list2 = new ArrayList<Integer>();

			while (!stack2.isEmpty()) {
				TreeNode cNode = stack2.pop();
				if (cNode != null) {
					if (cNode.right != null)
						stack1.push(cNode.right);

					if (cNode.left != null)
						stack1.push(cNode.left);

					list2.add(cNode.val);

				}
			}

			if (list2.size() > 0)
				resultList.add(list2);

		}

		return resultList;

	}

	public int minAddToMakeValid(String S) {
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == '(') {
				stack.push(S.charAt(i));
			}

			if (S.charAt(i) == ')') {
				if (!stack.isEmpty()) {
					if (stack.peek() == '(') {
						stack.pop();
					} else {
						stack.push(S.charAt(i));

					}

				} else {
					stack.push(S.charAt(i));

				}

			}

		}

		return stack.size();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[][] transpose(int[][] A) {
		int M = A.length;
		int N = A[0].length;

		int[][] mat = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				mat[i][j] = A[j][i];
			}
		}

		return mat;

	}

}
