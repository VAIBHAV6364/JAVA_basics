import java.util.*;
public class WeightedGraph {
    public static void main(String args[]) {
        int V = 4;     // number of vertices
        int[][] graph = new int[V][V];

        createGraph(graph, V);
        printAdjacencyMatrix(graph, V);
        printNeighboursOfANode(graph, V, 2);
    }

    // PRINT ADJACENCY MATRIX      // T.C = O(V^2)
    public static void createGraph(int[][] graph, int V){
        System.out.println("Enter Adjacenecy Matrix : Enter weight from row node to column node if exists else 0.");
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < V; i++){
            for(int j = 0; j < V; j++){
                graph[i][j] = sc.nextInt();
            }
        }
    }

    // PRINT ADJACENCY MATRIX       // T.C = O(V^2)
    public static void printAdjacencyMatrix(int[][] graph, int V){
        System.out.println("Adjacency Matrix (UnWeighted): ");
        for(int i = 0; i < V; i++){
            for(int j = 0; j < V; j++){
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    // PRINT NEIGHBOURS OF A NODE
    public static void printNeighboursOfANode(int[][] graph, int V, int node){
        System.out.println("\nNeighbours of node "+node+" are : ");
        for(int j = 0; j < V; j++){
            if(graph[node][j] != 0){
                System.out.println(j + " - weight : " + graph[node][j]);
            }
        }
    }
}
