package LinkedLists;

import java.util.Scanner;

public class SingleLinkedList {

	static class List {
		private int data;
		private List next;
		
		List(int data) {
			this.data = data;
			this.next = null;
		}
		
	}
	
	void printList(List head)
	{
		List node = head;
		
		while(node != null) {
			System.out.println(node.data + "\t");
			node = node.next;
		}
	}
	public static void main(String[] args) {
		SingleLinkedList list = new SingleLinkedList();
		Scanner sc = new Scanner(System.in);
		
		List first = new List(sc.nextInt());
		List curr = first;
		int number = sc.nextInt();
		
		while(number != 0) {
			List node = new List(number);
			curr.next = node;
			curr = curr.next;
			number = sc.nextInt();
		}

		list.printList(first);
	}

}
