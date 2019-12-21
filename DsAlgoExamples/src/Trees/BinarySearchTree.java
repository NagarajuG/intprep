package Trees;

import java.util.Scanner;

public class BinarySearchTree {
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

	public static class DNode {
		String data;
		DNode prev;
		DNode next;

		public DNode() {
			this.data = "";
			this.next = null;
			this.prev = null;
		}
	}

	static Tree formTree(Tree root, Tree node) {
		Tree p, p1;
		if (root == null) {
			root = node;
		} else {
			p = root;
			p1 = p;
			while (p != null) {
				if (node.data > p.data) {
					p1 = p;
					p = p.right;
				} else {
					p1 = p;
					p = p.left;
				}
			}

			if (node.data > p1.data)
				p1.right = node;
			else
				p1.left = node;

		}

		return root;
	}

	static Tree mirrorImage(Tree root) {
		if (root == null) {
			return null;
		}

		Tree left = mirrorImage(root.left);
		Tree right = mirrorImage(root.right);

		root.left = right;
		root.right = left;

		return root;
	}

	static void reverseInOrder(Tree root) {
		Tree p = root;
		if (p != null) {
			reverseInOrder(p.right);
			System.out.print(p.data + "\t");
			reverseInOrder(p.left);
		}
	}

	static void inOrder(Tree root) {
		Tree p = root;
		if (p != null) {
			inOrder(p.left);
			System.out.print(p.data + "\t");
			inOrder(p.right);
		}
	}

	static void preOrder(Tree root) {
		Tree p = root;
		if (p != null) {
			System.out.print(p.data + "\t");
			preOrder(p.left);
			preOrder(p.right);
		}
	}

	static void postOrder(Tree root) {
		Tree p = root;
		if (p != null) {
			postOrder(p.left);
			postOrder(p.right);
			System.out.print(p.data + "\t");
		}
	}

	public static void verticalOrder(Tree root, DNode head) {
		if (root == null) {
			return;
		}

		if (head == null) {
			head = new DNode();
		}

		DNode prevNode = null;

		DNode nextNode = null;

		head.data += root.data + "\t";

		if (root.left != null) {
			if (head.prev == null) {
				prevNode = new DNode();
				head.prev = prevNode;
				prevNode.next = head;
			}

		}

		verticalOrder(root.left, head.prev);

		if (root.right != null) {
			if (head.next == null) {
				nextNode = new DNode();
				head.next = nextNode;
				nextNode.prev = head;
			}
		}

		verticalOrder(root.right, head.next);

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Tree root = null;

		int n = sc.nextInt();
		while (n != 0) {
			Tree node = new Tree(n);
			root = formTree(root, node);
			n = sc.nextInt();
		}

		sc.close();

		System.out.println("\nInorder traversal is \n");
		inOrder(root);

		System.out.println("\n Pre order traversal is \n");
		preOrder(root);

		System.out.println("\n Post order traversal is \n");
		postOrder(root);

		System.out.println("\n The vertical order is \n");

		DNode head = new DNode();

		verticalOrder(root, head);

		DNode node = head;

		while (node.prev != null)
			node = node.prev;

		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}

//		System.out.println("\n Reverse In order / descending order traversal is \n");
//		reverseInOrder(root);
//
//		System.out.println("\nBefore mirror image, Pre order traversal \n");
//
//		preOrder(root);
//
//		System.out.println("\nAfter mirror image \n");
//
//		mirrorImage(root);
//
//		preOrder(root);
//
//		System.out.println("\nAfter mirror image inorder is\n");
//		inOrder(root);

	}

}
