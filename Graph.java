import java.util.Arrays;

class Edge {
    int src, dest, weight;

    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

class Graph {
    int V, E;
    Edge[] edges;

    Graph(int v, int e) {
        V = v;
        E = e;
        edges = new Edge[E];
        for (int i = 0; i < e; ++i)
            edges[i] = new Edge(0, 0, 0);
    }

    void bellmanFord(int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Relax all edges |V| - 1 times
        for (int i = 1; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                int u = edges[j].src;
                int v = edges[j].dest;
                int weight = edges[j].weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v])
                    dist[v] = dist[u] + weight;
            }
        }

        // Check for negative-weight cycles
        for (int j = 0; j < E; ++j) {
            int u = edges[j].src;
            int v = edges[j].dest;
            int weight = edges[j].weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }

        printArr(dist);
    }

    void printArr(int[] dist) {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; ++i)
            System.out.println(i + "\t\t" + dist[i]);
    }

    public static void main(String[] args) {
        int V = 5; // Number of vertices in graph
        int E = 8; // Number of edges in graph

        Graph graph = new Graph(V, E);

        // add edge 0-1 (or A-B in above figure)
        graph.edges[0] = new Edge(0, 1, -1);
        // add edge 0-2 (or A-C in above figure)
        graph.edges[1] = new Edge(0, 2, 4);
        // add edge 1-2 (or B-C in above figure)
        graph.edges[2] = new Edge(1, 2, 3);
        // add edge 1-3 (or B-D in above figure)
        graph.edges[3] = new Edge(1, 3, 2);
        // add edge 1-4 (or B-E in above figure)
        graph.edges[4] = new Edge(1, 4, 2);
        // add edge 3-2 (or D-C in above figure)
        graph.edges[5] = new Edge(3, 2, 5);
        // add edge 3-1 (or D-B in above figure)
        graph.edges[6] = new Edge(3, 1, 1);
        // add edge 4-3 (or E-D in above figure)
        graph.edges[7] = new Edge(4, 3, -3);

        graph.bellmanFord(0);
    }
}

