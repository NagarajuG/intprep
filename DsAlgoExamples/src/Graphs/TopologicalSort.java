package Graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {

	int V;
	LinkedList<Integer> adj[];

	TopologicalSort(int v) {
		this.V = v;
		adj = new LinkedList[this.V];

		for (int i = 0; i < this.V; i++)
			adj[i] = new LinkedList<Integer>();
	}

	void addEdge(int src, int dest) {
		this.adj[src].add(dest);
	}

	void topologicalSortUtil(TopologicalSort graph, boolean[] visited, int v, Stack<Integer> stack) {
		visited[v] = true;

		Iterator<Integer> ie = graph.adj[v].iterator();

		while (ie.hasNext()) {
			int i = ie.next();
			if (!visited[i])
				topologicalSortUtil(graph, visited, i, stack);
		}

		stack.push(v);

	}

	void topologicalSort(TopologicalSort graph) {
		Stack<Integer> stack = new Stack<Integer>();
		boolean[] visited = new boolean[this.V];

		for (int i = 0; i < this.V; i++) {
			visited[i] = false;
		}

		for (int i = 0; i < this.V; i++) {
			if (!visited[i])
				topologicalSortUtil(graph, visited, i, stack);
		}

		while (stack.empty() == false) {
			System.out.print("\t" + stack.pop());
		}
	}

	public static void main(String[] args) {
		TopologicalSort g = new TopologicalSort(9);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(1, 5);
		g.addEdge(2, 3);
		g.addEdge(2, 8);
		g.addEdge(3, 6);
		g.addEdge(4, 6);
		g.addEdge(4, 8);
		g.addEdge(5, 8);
		g.addEdge(6, 7);
		g.addEdge(7, 8);

		System.out.println("Following is a Topological " + "sort of the given graph");
		g.topologicalSort(g);

	}

}
