package LinkedLists;

import java.util.Scanner;

public class LinkedListAddition {
	static class List {
		private int data;
		private List next;

		List(int data) {
			this.data = data;
			this.next = null;
		}

	}

	void printList(List head) {
		List node = head;

		while (node != null) {
			System.out.println(node.data + "\t");
			node = node.next;
		}
	}

	List readList(Scanner sc) {

		List first = new List(sc.nextInt());
		List curr = first;
		int number = sc.nextInt();

		while (number != 0) {
			List node = new List(number);
			curr.next = node;
			curr = curr.next;
			number = sc.nextInt();
		}

		return first;

	}

	List reverse(List head) {
		if (head == null) {
			return null;
		}

		List p = null, p1 = head;

		while (p1 != null) {
			p1 = p1.next;
			head.next = p;
			p = head;
			head = p1;
		}

		return p;
	}

	public static void main(String[] args) {
		LinkedListAddition list = new LinkedListAddition();
		Scanner sc = new Scanner(System.in);
		List list1 = list.readList(sc);
		List list2 = list.readList(sc);

		sc.close();

		list1 = list.reverse(list1);
		list2 = list.reverse(list2);
		int carry = 0;

		List p1 = list1, p2 = list2, list3 = null, p3 = null;

		while (p1 != null || p2 != null) {
			int result = 0;
			if (p1 != null) {
				result += p1.data;
				p1 = p1.next;
			}

			if (p2 != null) {
				result += p2.data;
				p2 = p2.next;
			}

			result += carry;

			carry = result / 10;
			result = result % 10;
			List node = new List(result);

			if (list3 == null) {
				list3 = node;
				p3 = node;
			} else {
				p3.next = node;
				p3 = p3.next;
			}

		}

		if (carry != 0) {
			List node = new List(carry);
			p3.next = node;
			p3 = p3.next;
		}

		list3 = list.reverse(list3);
		list1 = list.reverse(list1);
		list2 = list.reverse(list2);

		System.out.println("The final answer is \n");

		list.printList(list3);

	}

}
