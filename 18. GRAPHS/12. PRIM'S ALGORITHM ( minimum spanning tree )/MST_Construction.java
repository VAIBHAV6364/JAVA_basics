import java.util.*;
public class MST_Construction {
    static class Edge{
        int src;
        int dest;
        int weight;

        public Edge(int s, int d, int wt){
            this.src = s;
            this.dest = d;
            this.weight = wt;
        }
    }

    // CREATE GRAPH
    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++)
            graph[i] = new ArrayList<Edge>();

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }

    /*
                  ( 0 )
                /   |   \
         10   /     |    \  15
            /       |     \
         ( 1 )      | 30   \
           \        |       ( 2 )
            \       |     /
         40 \      |    /  50
              \    |  /
                ( 3 )
     */

    //Pair class
    public static class Pair implements Comparable<Pair> {
        int node;
        int cost;
        int parent; // NEW: To store parent node

        public Pair(int n, int c, int p) {
            this.node = n;
            this.cost = c;
            this.parent = p;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost;  // order in ascending order according to cost
        }
    }

    public static void primsAlgo(ArrayList<Edge> graph[], int V, int src, int inCost) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean vis[] = new boolean[V];
        pq.add(new Pair(src, inCost, -1)); // src has no parent

        int mstCost = 0;
        ArrayList<Edge> mstEdges = new ArrayList<>(); // to store MST edges

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!vis[curr.node]) {
                vis[curr.node] = true;
                mstCost += curr.cost;

                // If not the source, record the edge that added this node
                if (curr.parent != -1) {
                    mstEdges.add(new Edge(curr.parent, curr.node, curr.cost));
                }

                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    if (!vis[e.dest]) {
                        pq.add(new Pair(e.dest, e.weight, curr.node));
                    }
                }
            }
        }

        // Print result
        System.out.println("\nThe Minimum cost of the MST of this graph is : " + mstCost);
        System.out.println("Edges in the MST:");
        for (Edge e : mstEdges) {
            System.out.println("Node "+e.src + " ---> Node " + e.dest + " (weight " + e.weight + ")");
        }
    }

    // Print Adjacency List
    public static void printGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            System.out.print("Node " + i + " -> ");
            for(Edge e : graph[i]) {
                System.out.print(e.dest + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]){
        int V = 4;

        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);

        printGraph(graph);

        int srcNode = 0;
        int inCost = 0;
        primsAlgo(graph, V, srcNode, inCost);
    }
}
