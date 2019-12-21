package Graphs;

public class BellmanFord {

	public static class Edge {
		int src, dest, weight;

		Edge() {
			src = 0;
			dest = 0;
			weight = 0;
		}
	};

	int V, E;

	Edge[] edge;

	BellmanFord(int v, int e) {
		this.V = v;
		this.E = e;

		this.edge = new Edge[e];

		for (int i = 0; i < e; i++) {
			edge[i] = new Edge();
		}
	}

	void printSolution(int[] dest) {
		for (int i = 0; i < this.V; i++) {
			System.out.println("\n The distance from 0 to  \t" + i + "\t is...\t" + dest[i]);
		}
	}

	void BellmanFordAlgo(BellmanFord graph) {
		int[] dest = new int[V];

		for (int i = 0; i < V; i++) {
			dest[i] = Integer.MAX_VALUE;
		}

		dest[0] = 0;

		for (int i = 1; i < this.V; i++) {
			for (int j = 0; j < this.E; j++) {
				int u = graph.edge[j].src;
				int v = graph.edge[j].dest;
				int w = graph.edge[j].weight;

				if (dest[u] != Integer.MAX_VALUE && dest[v] > dest[u] + w) {
					dest[v] = dest[u] + w;
				}
			}
		}

		for (int j = 0; j < this.E; j++) {
			int u = graph.edge[j].src;
			int v = graph.edge[j].dest;
			int w = graph.edge[j].weight;

			if (dest[u] != Integer.MAX_VALUE && dest[v] > dest[u] + w) {
				System.out.println("There is negative edge cycle in the graph !!! \n");
			}
		}

		printSolution(dest);
	}

	public static void main(String[] args) {
		BellmanFord graph = new BellmanFord(5, 8);

		graph.edge[0].src = 0;
		graph.edge[0].dest = 1;
		graph.edge[0].weight = -1;

		// add edge 0-2 (or A-C in above figure)
		graph.edge[1].src = 0;
		graph.edge[1].dest = 2;
		graph.edge[1].weight = 4;

		// add edge 1-2 (or B-C in above figure)
		graph.edge[2].src = 1;
		graph.edge[2].dest = 2;
		graph.edge[2].weight = 3;

		// add edge 1-3 (or B-D in above figure)
		graph.edge[3].src = 1;
		graph.edge[3].dest = 3;
		graph.edge[3].weight = 2;

		// add edge 1-4 (or A-E in above figure)
		graph.edge[4].src = 1;
		graph.edge[4].dest = 4;
		graph.edge[4].weight = 2;

		// add edge 3-2 (or D-C in above figure)
		graph.edge[5].src = 3;
		graph.edge[5].dest = 2;
		graph.edge[5].weight = 5;

		// add edge 3-1 (or D-B in above figure)
		graph.edge[6].src = 3;
		graph.edge[6].dest = 1;
		graph.edge[6].weight = 1;

		// add edge 4-3 (or E-D in above figure)
		graph.edge[7].src = 4;
		graph.edge[7].dest = 3;
		graph.edge[7].weight = -3;

		graph.BellmanFordAlgo(graph);

	}

}
