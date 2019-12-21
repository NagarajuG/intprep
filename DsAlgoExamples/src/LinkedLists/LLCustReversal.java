package LinkedLists;

import java.util.Scanner;
import java.util.Stack;

public class LLCustReversal {

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
	
	List customReversal(List head, int revNumber) {
		List p = head, p1 = null;
		Stack<List> stack = new Stack<List>();
		while(p != null) {
			for(int i =0; i< revNumber && p != null; i++) {
				p1 = p;
				p = p.next;
				
			}
			for(int i =0; i< revNumber && p!= null ; i++) {
				stack.push(p);
				p = p.next;
			}
			while(!stack.empty()) {
				p1.next = stack.pop();
				p1 = p1.next;
			}
			
			p1.next = p;
		}
		
		return head;
	}
	
	public static void main(String[] args) {
		LLCustReversal list = new LLCustReversal();
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
		System.out.println("\n enter the reversal number");
		int revNumber = sc.nextInt();
		
		System.out.println("\n List after reversing");
		
		list.printList(list.customReversal(first, revNumber));
		
		sc.close();
	}



}
