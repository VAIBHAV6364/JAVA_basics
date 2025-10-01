import java.util.*;
public class APNA_PrintAllPath_SrcToTrg {
    static class Edge{
        int src;
        int dest;

        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

     /*
           ( 1 )-----( 3 )
           /          |   \
         ( 0 )        |  ( 5 )
           \          |  /   \
           ( 2 )-----( 4 )   ( 6 )
     */

    public static void createGraph(ArrayList<Edge> graph[]) {
        // Creating new ArrayList of Edge type in each index
        for(int i=0; i < graph.length; i++)
            graph[i] = new ArrayList<Edge>();

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));
    }


    // Print All Paths From Source To Destination
    public static void printAllPaths(ArrayList<Edge> graph[], boolean vis[], int curr, String path, int tar){
        // Base Case
        if(curr == tar) {
            System.out.println(path);
            return;
        }

        vis[curr] = true;  // mark before recursion
        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) {
                printAllPaths(graph, vis, e.dest, path + " -> " + e.dest, tar);
            }
        }
        vis[curr] = false; // unmark after recursion (backtrack)
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

        boolean visited[] = new boolean[V];
        System.out.println("\n0 to 5 all paths : ");
        printAllPaths(graph, visited, 0, "0", 5);
    }
}
