import java.util.*;
public class DijkstraAlgorithm {
    static class Edge {
        int src;
        int dest;
        int weight;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.weight = w;
        }
    }

    /*
                       7
              ( 1 )-------->( 3 )
              ^               ^   \  1
           2 /                |     *
         ( 0 )             2  |     ( 5 )
            \                 |    ^
          4  *               |    /  5
             ( 2 )-------->( 4 )
                     3
     */

    public static void createGraph(ArrayList<Edge> graph[]) {
        // Creating new ArrayList of Edge type in each index
        for(int i=0; i < graph.length; i++)
            graph[i] = new ArrayList<Edge>();

        graph[0].add(new Edge(0,1, 2));
        graph[0].add(new Edge(0,2, 4));
        graph[1].add(new Edge(1,3, 7));
        graph[2].add(new Edge(2,4, 3));
        graph[3].add(new Edge(3,5, 1));
        graph[4].add(new Edge(4,3, 2));
        graph[4].add(new Edge(4,5, 5));
    }

//---------------------------------------------------------------------------------------------------------------------------------
    // PAIR CLASS to store the pair consisting of node and distance to it
    static class Pair implements Comparable<Pair> {
        // implements Comparable to sort pairs according to dist of pair and not node value of pair
        int node;
        int dist;

        public Pair(int n, int d){
            this.node = n;
            this.dist = d;
        }

        @Override
        public int compareTo(Pair p2) {   // returns positive / negative / 0
            return this.dist - p2.dist;   // compare in ascending order according to distance
            // return p2.dist - this.dist;   // descending order
        }
    }
    // DIJKSTRA'S ALGO : to find the shortest distance from src to all nodes
    public static void dijkstra(ArrayList<Edge> graph[], int src, int V) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int dist[] = new int[V];
        // At first initialize all distances to infinity
        for(int i = 0; i < V; i++) {
            if(i != src)
                dist[i] = Integer.MAX_VALUE;
        }

        boolean vis[] = new boolean[V];

        pq.add(new Pair(src,0));

        while( !pq.isEmpty() ){
            Pair curr = pq.remove();  // Pair in pq with the shortest distance
            if(!vis[curr.node]) {  // visit the unvisited node
                vis[curr.node] = true;

                // obtain curr node's neighbours
                for(int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    int u = e.src;
                    int v = e.dest;
                    //relaxation
                    if(dist[u] + e.weight < dist[v]) {
                        dist[v] = dist[u] + e.weight;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        // print distances
        for(int i = 0; i < V; i++) {
            System.out.println("Distance from Node 0 --> Node "+i+" = "+dist[i]);
        }
    }
//---------------------------------------------------------------------------------------------------------

    // Print Adjacency List
    public static void printGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            System.out.print("Node " + i + " --> ");
            for(Edge e : graph[i]) {
                System.out.print(e.dest + " ");
            }
            System.out.println();
        }
    }


    public static void main(String args[]){
        int V = 6;

        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);

        printGraph(graph);

        System.out.println("\nShortest distance from 0 to all nodes using Dijkstra's Algorithm : ");
        dijkstra(graph, 0, V);
    }
}
