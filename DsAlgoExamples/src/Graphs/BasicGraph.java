package Graphs;

import java.util.LinkedList;

public class BasicGraph {

	public static class Graph {
		int V;
		LinkedList<Integer>[] adjusentList;

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

			graph.adjusentList[dest].add(src);

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

	public static void main(String[] args) {

		Graph graph = new Graph(5);

		addEdge(graph, 0, 1);
		addEdge(graph, 0, 2);
		addEdge(graph, 1, 2);
		addEdge(graph, 1, 3);
		addEdge(graph, 2, 4);
		addEdge(graph, 3, 4);
		addEdge(graph, 1, 4);

		printGraph(graph);

	}

}
