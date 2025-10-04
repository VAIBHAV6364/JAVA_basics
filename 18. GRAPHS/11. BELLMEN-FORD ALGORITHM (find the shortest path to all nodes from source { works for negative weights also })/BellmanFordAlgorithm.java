// Time Complexity : O(E x V)

import java.util.*;
public class BellmanFordAlgorithm {
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
                              -10
           ( 1 )_______________________
           ^   |                       \
       2  /    |                        *
         /     |                       ( 4 )
      ( 0 )    |  -4                    ^
        \      |                       /
     4   \     |                      /
          *    *                    /
          ( 2 ) ---------------->( 3 )

     */

    public static void createGraph(ArrayList<Edge> graph[]) {
        // Creating new ArrayList of Edge type in each index
        for(int i=0; i < graph.length; i++)
            graph[i] = new ArrayList<Edge>();

        graph[0].add(new Edge(0,1, 2));
        graph[0].add(new Edge(0,2, 4));
        graph[1].add(new Edge(1,2, -4));
        graph[2].add(new Edge(2,3, 2));
        graph[3].add(new Edge(3,4, 4));
        graph[4].add(new Edge(4,1, -1));
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


    // BELLMAN-FORD ALGORITHM
    public static void bellmanFord(ArrayList<Edge> graph[], int src, int V) {
        int dist[] = new int[V];
        // At first initialize all distances to infinity
        for(int i = 0; i < V; i++) {
            if(i != src)
                dist[i] = Integer.MAX_VALUE;
        }

        for (int k = 0; k < V - 1; k++) {    // takes O(V)
            // both the for loops together below take O(E)
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < graph[i].size(); j++) {  // extract neighbours of each node
                    Edge e = graph[i].get(j);
                    int u = e.src;
                    int v = e.dest;

                    // relax edge
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + e.weight < dist[v]) {    // Because in java infinity + (-ve) value gives (-ve) in java
                        dist[v] = dist[u] + e.weight;
                    }
                }
            }
        }


        for(int i = 0; i < dist.length; i++) {
            System.out.println("Distance from Node "+src+" to Node "+i+" = "+dist[i]);
        }
    }


    public static void main(String args[]){
        int V = 5;

        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);

        printGraph(graph);

        System.out.println("\nShortest distance from 0 to all nodes using Bellman Ford's Algorithm : ");
        bellmanFord(graph, 0, V);
    }
}
