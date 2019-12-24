package leetCode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * 
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

	Example:
		
		Input:
		[
		  1->4->5,
		  1->3->4,
		  2->6
		]
		Output: 1->1->2->3->4->4->5->6
 */
public class MergeKSortedLinkedLists23 {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode h = new ListNode(0);
		ListNode ans = h;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				h.next = l1;
				h = h.next;
				l1 = l1.next;
			} else {
				h.next = l2;
				h = h.next;
				l2 = l2.next;
			}
		}
		if (l1 == null) {
			h.next = l2;
		}
		if (l2 == null) {
			h.next = l1;
		}
		return ans.next;
	}

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0) {
			return null;
		}
		int interval = 1;
		while (interval < lists.length) {
			System.out.println(lists.length);
			for (int i = 0; i + interval < lists.length; i = i + interval * 2) {
				lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
			}
			interval *= 2;
		}

		return lists[0];
	}

	public ListNode mergeKListsQ(ListNode[] lists) {
		Comparator<ListNode> cmp;
		cmp = new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				// TODO Auto-generated method stub
				return o1.val - o2.val;
			}
		};

		Queue<ListNode> q = new PriorityQueue<ListNode>(cmp);
		for (ListNode l : lists) {
			if (l != null) {
				q.add(l);
			}
		}
		ListNode head = new ListNode(0);
		ListNode point = head;
		while (!q.isEmpty()) {
			point.next = q.poll();
			point = point.next;
			ListNode next = point.next;
			if (next != null) {
				q.add(next);
			}
		}
		return head.next;
	}

	public ListNode mergeKLists2(ListNode[] lists) {
		int totalLists = lists.length;
		if (totalLists == 0)
			return null;
		if (totalLists == 1)
			return lists[0];

		ListNode head = lists[0];

		for (int i = 1; i < lists.length; i++) {
			head = merge(head, lists[i]);

		}

		return head;

	}

	private ListNode merge(ListNode head1, ListNode head2) {
		ListNode l1 = head1, l2 = head2, dHead = new ListNode(-1);
		ListNode head = dHead;

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				head.next = l1;
				l1 = l1.next;
			} else {
				head.next = l2;
				l2 = l2.next;
			}
			head = head.next;

		}

		if (l1 != null) {
			head.next = l1;
		}

		if (l2 != null) {
			head.next = l2;
		}

		return dHead.next;

	}

}
