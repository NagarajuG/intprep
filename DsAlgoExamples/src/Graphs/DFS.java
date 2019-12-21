package Graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class DFS {

	public static class Graph {
		int V;
		LinkedList<Integer> adjusentList[];

		Graph(int v) {
			V = v;

			adjusentList = new LinkedList[V];

			for (int i = 0; i < v; i++) {
				adjusentList[i] = new LinkedList<>();
			}
		}
	}

	public static void addEdge(Graph graph, int src, int dest) {
		if (graph != null) {

			graph.adjusentList[src].add(dest);

		}
	}

	static void printGraph(Graph graph) {
		for (int v = 0; v < graph.V; v++) {
			System.out.println("adjusent list of vertex" + v);
			System.out.print("head ");
			for (Integer i : graph.adjusentList[v]) {
				System.out.printf("( %d, %d)", v, i);
			}

			System.out.println("\n");

		}
	}

	static void DfsUtil(Graph graph, int v, boolean[] visited) {
		if (visited[v] != true) {
			visited[v] = true;
			System.out.print(v + "\t");

			Iterator<Integer> i = graph.adjusentList[v].iterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n])
					DfsUtil(graph, n, visited);
			}

		}
	}

	static void DFSearch(Graph graph, int start) {
		boolean[] visited = new boolean[graph.V];

		DfsUtil(graph, start, visited);

	}

	static void BfsUtil(Graph graph, int v, boolean[] visited) {
		if (visited[v] != true) {
			visited[v] = true;
			System.out.print(v + "\t");
			LinkedList<Integer> queue = new LinkedList<Integer>();

			queue.add(v);

			while (queue.size() != 0) {
				int cv = queue.poll();
				Iterator<Integer> i = graph.adjusentList[cv].iterator();
				while (i.hasNext()) {
					int n = i.next();
					if (!visited[n]) {
						visited[n] = true;
						System.out.print(n + "\t");
						queue.add(n);
					}
				}

			}

		}
	}

	static void BFSearch(Graph graph, int start) {
		boolean[] visited = new boolean[graph.V];

		BfsUtil(graph, start, visited);

	}

	static void newBFSearch(Graph graph, int start) {
		boolean[] visited = new boolean[graph.V];

		LinkedList<Integer> queue = new LinkedList<Integer>();

		queue.add(start);

		while (queue.size() != 0) {
			int cv = queue.poll();
			visited[cv] = true;
			System.out.print(cv + "\t");
			Iterator<Integer> i = graph.adjusentList[cv].iterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					queue.add(n);
				}
			}

		}

	}

	static void DFSwithStack(Graph graph, int v, boolean[] visited, Stack<Integer> stack) {
		visited[v] = true;
		System.out.println(v + "\t");

		Iterator<Integer> it = graph.adjusentList[v].iterator();
		while (it.hasNext()) {
			int n = it.next();
			if(!visited[n])
				stack.push(n);
		}

		if (stack.isEmpty() == false) {
			int n = stack.pop();
			DFSwithStack(graph, n, visited, stack);

		}

	}

	public static void main(String[] args) {

		Graph graph = new Graph(8);

		addEdge(graph, 4, 6);
		addEdge(graph, 6, 5);
		addEdge(graph, 6, 7);
		addEdge(graph, 4, 2);
		addEdge(graph, 2, 3);
		addEdge(graph, 2, 1);

		printGraph(graph);

		System.out.println("\n DFS travel path is \n");

		DFSearch(graph, 4);

		System.out.println("\n BFS travel path is \n");

		BFSearch(graph, 4);

		System.out.println("\n new BFS travel path is \n");

		newBFSearch(graph, 4);

		boolean[] visited = new boolean[8];

		Stack<Integer> stack = new Stack<Integer>();
		
		System.out.println("\n DFS travel path is (using stack) \n");

		DFSwithStack(graph, 4, visited, stack);

	}

}
