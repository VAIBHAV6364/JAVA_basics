// Time Complexity : O(E x V)

import java.util.*;
public class Detect_NegWeightCycle {
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
             1
       (0) -----> (1)
        ^         /
         \       /
          \ -2  / -1
           \   /
            (2)

     Negative weight cycle: 0 -> 1 -> 2 -> 0
     Total weight = 1 + (-1) + (-2) = -2
     */

    public static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i < graph.length; i++)
            graph[i] = new ArrayList<Edge>();

        graph[0].add(new Edge(0,1, 1));
        graph[1].add(new Edge(1,2, -1));
        graph[2].add(new Edge(2,0, -2));
    }

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


    // DETECT A NEGATIVE WEIGHT CYCLE
    public static void detectNegWtCycle(ArrayList<Edge> graph[], int src, int V) {
        int dist[] = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Step 1: Relax edges V-1 times
        for (int k = 0; k < V - 1; k++) {
            for (int i = 0; i < V; i++) {
                for (Edge e : graph[i]) {
                    int u = e.src;
                    int v = e.dest;
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + e.weight < dist[v]) {
                        dist[v] = dist[u] + e.weight;
                    }
                }
            }
        }

        // Step 2: Check for negative weight cycle
        for (int i = 0; i < V; i++) {
            for (Edge e : graph[i]) {
                int u = e.src;
                int v = e.dest;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + e.weight < dist[v]) {
                    System.out.println("🚨 IT HAS A NEGATIVE WEIGHT CYCLE!!!!");
                    return;
                }
            }
        }

        System.out.println("✅ No negative weight cycle detected.");
    }



    public static void main(String args[]){
        int V = 3;

        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);

        printGraph(graph);

        detectNegWtCycle(graph, 0, V);
    }
}
