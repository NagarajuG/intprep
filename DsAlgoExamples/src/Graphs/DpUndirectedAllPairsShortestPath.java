package Graphs;

import java.util.Arrays;

public class DpUndirectedAllPairsShortestPath {

	public static class Graph {
		int V;
		int[][] Path = new int[10][10];

		Graph(int v) {
			V = v;

			for (int i = 0; i < v; i++) {
				for (int j = 0; j < v; j++) {
					Path[i][j] = 0;
				}

			}
		}
	}

	public static void addEdge(Graph graph, int src, int dest, int value) {
		if (graph != null) {

			graph.Path[src][dest] = value;

			graph.Path[dest][src] = value;

		}
	}

	public static void findShortestPath(Graph graph, int size, int src, int dest) {
		int[][] solution = new int[2][size];

		Arrays.fill(solution[0], Integer.MAX_VALUE);
		Arrays.fill(solution[1], -1);

		for (int i = 0; i < size; i++) {
			for (int j = i; j < size; j++) {
				if(graph.Path[i][j] != 0) {
					int distSoFar = (solution[0][i] == Integer.MAX_VALUE) ? 0 : solution[0][i];
					int newDist = graph.Path[i][j] + distSoFar;
					if (newDist < solution[0][j]) {
						solution[0][j] = newDist;
						solution[1][j] = i;
					}			
				}
			}
		}
		if(solution[0][dest] != 0) {
			System.out.println("\nSolution Possible with " + solution[0][dest] );
			String str = "->9";
			int n = dest;
			while(n != src) {
				int c = solution[1][n];
				str = "->" + c + str;
				n = c;
			}
			
			System.out.println("\n Solution path is " + str);
			
		} else {
			System.out.println("Not Possible\n");
		}
	}

	public static void main(String[] args) {

		Graph graph = new Graph(10);

		addEdge(graph, 0, 1, 9);
		addEdge(graph, 0, 2, 2);
		addEdge(graph, 0, 3, 4);
		addEdge(graph, 1, 2, 5);
		addEdge(graph, 1, 4, 7);
		addEdge(graph, 2, 3, 1);
		addEdge(graph, 2, 5, 3);
		addEdge(graph, 3, 4, 6);
		addEdge(graph, 3, 5, 4);
		addEdge(graph, 4, 5, 1);
		addEdge(graph, 4, 6, 2);
		addEdge(graph, 4, 7, 7);
		addEdge(graph, 5, 7, 6);
		addEdge(graph, 5, 8, 4);
		addEdge(graph, 6, 7, 2);
		addEdge(graph, 7, 8, 4);
		addEdge(graph, 6, 9, 3);
		addEdge(graph, 7, 9, 2);
		addEdge(graph, 8, 9, 2);

		findShortestPath(graph, 10, 0, 9);

		// printGraph(graph);

	}

}
