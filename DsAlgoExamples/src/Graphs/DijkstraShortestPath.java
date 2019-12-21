package Graphs;

public class DijkstraShortestPath {
	int V = 9;

	int minDistance(int[] dist, boolean[] sptSet, int V) {
		int min_index = 0, min = Integer.MAX_VALUE;
		for (int v = 0; v < V; v++) {
			if (!sptSet[v] && dist[v] < min) {
				min = dist[v];
				min_index = v;
			}
		}

		return min_index;
	}

	void printSolution(int[] dist, int V) {
		for (int v = 0; v < V; v++) {
			System.out.println("\n The distance from 0 to \t" + v + "\t is\t " + dist[v]);
		}
	}

	void diskstra(int[][] graph, int src, int V) {
		int[] dist = new int[V];
		boolean[] sptSet = new boolean[V];

		for (int v = 0; v < V; v++) {
			sptSet[v] = false;
			dist[v] = Integer.MAX_VALUE;
		}

		dist[0] = 0;

		for (int count = 0; count < V - 1; count++) {
			int u = minDistance(dist, sptSet, V);

			sptSet[u] = true;

			for (int v = 0; v < V; v++) {
				if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
					dist[v] = dist[u] + graph[u][v];
				}
			}

		}

		printSolution(dist, V);
	}

	public static void main(String[] args) {

		int[][] graph = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
				{ 0, 8, 0, 7, 0, 4, 0, 0, 2 }, { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
				{ 0, 0, 4, 14, 10, 0, 2, 0, 0 }, { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
				{ 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

		DijkstraShortestPath dj = new DijkstraShortestPath();

		dj.diskstra(graph, 0, 9);

	}

}
