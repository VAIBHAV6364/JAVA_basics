import java.util.*;
public class WeightedGraphAdjList {
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

    public static void createGraph(ArrayList<Edge> graph[]) {
        // Creating new ArrayList of Edge type in each index
        for(int i=0; i < graph.length; i++)
            graph[i] = new ArrayList<Edge>();

        graph[0].add(new Edge(0,2,2));
        graph[1].add(new Edge(1,3,0));
        graph[1].add(new Edge(1,2,10));
        graph[2].add(new Edge(2,0,2));
        graph[2].add(new Edge(2,3,-1));
        graph[2].add(new Edge(2,1,10));
        graph[3].add(new Edge(3,1,0));
        graph[3].add(new Edge(3,2,-1));
    }

    // Print Adjacency List
    public static void printGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            System.out.println("Node " + i + " -> ");
            for (Edge e : graph[i]) {
                System.out.println(e.dest + " - " + "weight : "+e.weight);
            }
            System.out.println();
        }
    }

    public static void printNeighbours(ArrayList<Edge> graph[], int Node){
        System.out.println("\nNeighbours connected to "+Node+" are : ");
        for(int i=0; i < graph[Node].size(); i++){
            Edge e = graph[Node].get(i);
            System.out.println(e.dest + " - weight : "+ e.weight);
        }
    }

    public static void main(String args[]){
        int V = 4;

        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);

        printGraph(graph);

        printNeighbours(graph, 2);
    }
}
