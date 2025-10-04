// Time Complexity : O(E log E)

import java.util.*;
public class MST_Cost_From_UnDirectedGraph {
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
        // Creating new ArrayList of Edge type in each index
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

        public Pair(int n, int c) {
            this.node = n;
            this.cost = c;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost;  // order in ascending order according to cost
        }
    }

    public static void primsAlgo(ArrayList<Edge> graph[], int V, int src, int inCost) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();  // Non MST set
        boolean vis[] = new boolean[V];    // MST set
        pq.add(new Pair(src, inCost));

        int mstCost = 0;

        while (!pq.isEmpty()) {  // i.e Non MST set has no more nodes left, all nodes added to MST
            Pair curr = pq.remove();
            if (!vis[curr.node]) {
                vis[curr.node] = true;
                mstCost += curr.cost;

                for (int i = 0; i < graph[curr.node].size(); i++) {  // iterate through each edge of curr node and add them
                    Edge e = graph[curr.node].get(i);
                    if (!vis[e.dest]) {
                        pq.add(new Pair(e.dest, e.weight));
                    }
                }
            }
        }
        System.out.println("\nThe Minimum cost of the MST of this graph is : "+mstCost);
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
        int V = 7;

        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);

        printGraph(graph);

        int srcNode = 0;
        int inCost = 0;
        primsAlgo(graph, V, 0, inCost);
    }
}


