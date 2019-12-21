package PreviousQuestions;

import java.util.concurrent.ConcurrentHashMap;

public class LRUCacheImplementation {
	public class Node {
		int data;
		Node next;
		Node prev;

		public Node(int data) {
			super();
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}

	// public class Cache {
	ConcurrentHashMap<Integer, Node> cache = new ConcurrentHashMap<Integer, Node>();
	Node head = null;
	int capacity;

//		public Cache(int val) {
//			this.capacity = val;
//		}

	public void put(int key, int val) {
		Node node = new Node(val);
		this.AddNode(node);
		cache.put(key, node);

	}

	public int get(int key) {
		if (cache.containsKey(key)) {
			Node node = cache.get(key);
			this.head = this.moveToFront(node.data);

			return node.data;
		}

		return 0;

	}

	public void remove(int key) {
		if (cache.containsKey(key)) {
			Node node = cache.remove(key);
			this.RemoveNode(node.data);
		}
	}

	private Node AddNode(Node node) {
		if (this.head == null) {
			head = node;
		} else {
			node.next = head;
			head.prev = node;
			head = node;
		}

		return node;

	}

	private Node RemoveNode(int val) {
		Node node = head;
		if (node.data == val) {
			node = node.next;
			head = node;
			node.prev = null;
		} else {
			while (node != null && node.data != val) {
				node = node.next;
			}

			if (node.data == val && node.next != null) {
				node.prev.next = node.next;
				node.next.prev = node.prev;
			} else {
				node.prev.next = null;
				node.prev = null;
			}
		}

		return node;

	}

	private Node moveToFront(int val) {
		Node node = head;
		if (node.data == val)
			return node;
		while (node.data != val) {
			node = node.next;
		}

		if (node.next != null) {
			node.prev.next = node.next;
			node.next.prev = node.prev;

		} else {
			node.prev.next = null;
		}

		node.next = head;
		head.prev = node;
		node.prev = null;

		return node;

	}

	public void print() {
		System.out.println("\nThe cache elements are \n");
		Node node = head;
		while (node != null) {
			System.out.print(node.data + "\t");
			node = node.next;
		}

		System.out.println("\n");

	}

	public static void main(String[] args) {
		LRUCacheImplementation mycache = new LRUCacheImplementation();
		// Cache mycache = new lruCacheImplementation.cache

		mycache.put(1, 1);
		mycache.put(2, 2);
		mycache.put(3, 3);
		mycache.put(4, 4);
		mycache.put(5, 5);
		mycache.put(6, 6);
		mycache.put(7, 7);

		mycache.print();

		System.out.println(mycache.get(1));
		mycache.print();

		System.out.println(mycache.get(3));
		mycache.print();
		System.out.println(mycache.get(5));
		mycache.print();
		System.out.println(mycache.get(7));
		System.out.println(mycache.get(2));

		mycache.print();

	}

}
