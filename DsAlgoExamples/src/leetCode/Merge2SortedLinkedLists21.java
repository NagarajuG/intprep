package leetCode;

/*
 * 
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

	Example:
	
	Input: 1->2->4, 1->3->4
	Output: 1->1->2->3->4->4
 */
public class Merge2SortedLinkedLists21 {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null)
			return null;

		ListNode l3 = null, head = null;

		while (l1 != null && l2 != null) {
			if (head == null) {
				if (l1.val < l2.val) {
					head = l1;
					l3 = head;
					l1 = l1.next;
				} else {
					head = l2;
					l3 = head;
					l2 = l2.next;
				}
			} else {
				if (l1.val < l2.val) {
					l3.next = l1;
					l3 = l3.next;
					l1 = l1.next;
				} else {
					l3.next = l2;
					l3 = l3.next;
					l2 = l2.next;
				}
			}
		}
		if (l1 != null) {
			if (head == null)
				return l1;
			else
				l3.next = l1;
		} else if (l2 != null) {
			if (head == null)
				return l2;
			else
				l3.next = l2;

		}

		return head;
	}

	public static void main(String[] args) {

	}

}
