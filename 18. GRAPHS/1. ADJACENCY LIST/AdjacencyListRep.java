import java.util.*;
public class AdjacencyListRep {
    static class Edge{
        int src;
        int dest;

        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    /*
        NOTE :
        when a array of non primitive data type is created it always initially stores null.
        we cant change null to something else in java directly
        we need to create an empty arraylist in each index instead of null
        so we write the for loop in createGraph() function;
         */
    public static void createGraph(ArrayList<Edge> graph[]) {
        // Creating new ArrayList of Edge type in each index
        for(int i=0; i < graph.length; i++)
            graph[i] = new ArrayList<Edge>();

        graph[0].add(new Edge(0,2));
        graph[1].add(new Edge(1,2));
        graph[1].add(new Edge(1,3));
        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,3));
        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,2));
    }

    // Print Adjacency List
    public static void printGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            System.out.print("Node " + i + " -> ");
            for (Edge e : graph[i]) {
                System.out.print(e.dest + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]){
        int V = 4;

        ArrayList<Edge> graph[] = new ArrayList[V];
        // a array(graph) of arrayList type where each index in array
        // stores a arraylist and each position in arraylist is a edge

        createGraph(graph);

        printGraph(graph);
    }
}
