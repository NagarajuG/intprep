package Trees;

import java.util.LinkedList;
import java.util.Scanner;

public class HeapTree {

	private int total = 0;

	public static class Tree {
		int data;
		Tree left;
		Tree right;

		Tree(int x) {
			data = x;
			left = null;
			right = null;
		}
	}

	void swap(Tree node1, Tree node2) {
		int t = node1.data;
		node1.data = node2.data;
		node2.data = t;
	}

	int heapifyAfterInsert(Tree root) {
		if (root == null) {
			return Integer.MAX_VALUE;
		}

		int l = heapifyAfterInsert(root.left);
		int r = heapifyAfterInsert(root.right);

		if (l < r) {
			if (l < root.data) {
				swap(root, root.left);
			}
		} else if (r < l) {
			if (r < root.data) {
				swap(root, root.right);
			}
		}

		return root.data;
	}

	void BFS(Tree root) {

		LinkedList<Tree> q = new LinkedList<Tree>();

		q.add(root);

		while (q.size() != 0) {
			Tree p = q.poll();
			System.out.println(p.data + "\t");
			if (p.left != null)
				q.add(p.left);
			if (p.right != null)
				q.add(p.right);
		}

	}

	Tree findParent(Tree root, int n) {
		String str = "";
		int i = n / 2;
		Tree p = root;

		while (i > 1) {
			if (i % 2 == 1)
				str = "R" + str;
			else
				str = "L" + str;

			i = i / 2;
		}

		for (int j = 0; j < str.length(); j++) {
			if (str.charAt(j) == 'L')
				p = p.left;
			else if (str.charAt(j) == 'R')
				p = p.right;
			else
				break;
		}

		return p;
	}

	Tree formHeapTree(Tree root, Tree node) {

		if (root == null) {
			root = node;
			total++;
		} else {
			int n = total + 1;
			Tree p = findParent(root, n);

			if (p.left == null)
				p.left = node;
			else
				p.right = node;

			total++;
		}

		heapifyAfterInsert(root);

		return root;
	}

	void heapifyDelete(Tree root) {
		Tree p = root;
		if (root == null) {
			return;
		}

		while (p != null) {
			if (p.left != null && p.right != null) {
				if ((p.data > p.left.data) || (p.data > p.right.data)) {
					if (p.left.data < p.right.data) {
						if (p.left.data < p.data) {
							swap(p, p.left);
							p = p.left;
						}
					} else if (p.right.data < p.left.data) {
						if (p.right.data < p.data) {
							swap(p, p.right);
							p = p.right;
						}
					}
				} else {
					return;
				}
			} else if (p.left != null && p.left.data < p.data) {
				swap(p, p.left);
				p = p.left;
			} else if (p.right != null && p.right.data < p.data) {
				swap(p, p.right);
				p = p.right;
			} else {
				return;
			}
		}
	}

	void delete(Tree root) {
		int n = total;
		Tree p = findParent(root, n);

		total = total - 1;
		System.out.println("Deleted " + root.data + "\n");
		if (p.right != null) {
			root.data = p.right.data;
			p.right = null;
		} else if (p.left != null) {
			root.data = p.left.data;
			p.left = null;
		} else {
			root = null;
		}

		heapifyDelete(root);

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Tree root = null;
		HeapTree hp = new HeapTree();

		int n = sc.nextInt();
		while (n != 0) {
			Tree node = new Tree(n);
			root = hp.formHeapTree(root, node);
			n = sc.nextInt();
		}

		sc.close();

		System.out.println("\n The smallest element so far is " + root.data + "\n");

		System.out.println("\n Level order traversal is \n");
		hp.BFS(root);

		while (hp.total >= 1) {
			hp.delete(root);

		}

	}

}
