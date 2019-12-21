package leetCode;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

	For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
	
	    1
	   / \
	  2   2
	 / \ / \
	3  4 4  3
	 
	
	But the following [1,2,2,null,3,null,3] is not:
	
	    1
	   / \
	  2   2
	   \   \
	   3    3
	 
	
	Note:
	Bonus points if you could solve it both recursively and iteratively.
 */
public class SymmetricTree101 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;

		return isSymmetricUtil(root.left, root.right);

	}

	private boolean isSymmetricUtil(TreeNode node1, TreeNode node2) {

		if (node1 == null && node2 == null) {
			return true;
		}

		if (node1 == null || node2 == null) {
			return false;
		}

		if (node1.val != node2.val)
			return false;

		return isSymmetricUtil(node1.left, node2.right) && isSymmetricUtil(node1.right, node2.left);

	}

	public boolean isSymmetricIterative(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		queue.add(root);
		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode node1 = queue.poll();
			TreeNode node2 = queue.poll();

			if (node1 == null && node2 == null)
				continue;
			if (node1 == null || node2 == null)
				return false;
			if (node1.val != node2.val)
				return false;

			queue.add(node1.left);
			queue.add(node2.right);
			queue.add(node1.right);
			queue.add(node2.left);
		}

		return true;
	}

	public static void main(String[] args) {

	}

}
