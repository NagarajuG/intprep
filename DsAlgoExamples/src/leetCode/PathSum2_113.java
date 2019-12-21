package leetCode;

import java.util.ArrayList;
import java.util.List;

/*
 * 
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

	Note: A leaf is a node with no children.
	
	Example:
	
	Given the below binary tree and sum = 22,
	
	      5
	     / \
	    4   8
	   /   / \
	  11  13  4
	 /  \    / \
	7    2  5   1
	Return:
	
	[
	   [5,4,11,2],
	   [5,8,4,5]
	]
 */
public class PathSum2_113 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (root == null)
			return result;

		pathSumUtil(root, sum, 0, result, new ArrayList<Integer>());

		return result;

	}

	private void pathSumUtil(TreeNode root, int target, int sumSofar, List<List<Integer>> result,
			List<Integer> current) {
		if (root == null) {
			return;
		}

		sumSofar += root.val;
		current.add(root.val);
		List<Integer> leftPaList = new ArrayList<Integer>(current);
		List<Integer> rightPaList = new ArrayList<Integer>(current);

		if (sumSofar == target && root.left == null && root.right == null) {
			result.add(new ArrayList<Integer>(current));
			return;
		}

		pathSumUtil(root.left, target, sumSofar, result, leftPaList);
		pathSumUtil(root.right, target, sumSofar, result, rightPaList);

	}

	public static void main(String[] args) {

	}

}
