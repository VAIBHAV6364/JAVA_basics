import java.util.*;
public class Demo {
    static Scanner sc = new Scanner(System.in);
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

    // CREATE EDGE LIST     // T.C = O(E)
    public static void createEdgeList(ArrayList<Edge> edges){
        System.out.println("Enter the number of edges : ");
        int E = sc.nextInt();
        for(int i = 0; i < E; i++){
            System.out.println("Enter src, dest, weight : ");
            int s = sc.nextInt();
            int d = sc.nextInt();
            int w = sc.nextInt();
            edges.add(new Edge(s,d,w));
        }
    }

    // PRINT ARRAY LIST    //T.C = O(E)
    public static void printEdgeList(ArrayList<Edge> edges){
        System.out.println("Edge List (Weighted : ");
        for(Edge e : edges){
            System.out.println(e.src + " -> " + e.dest + " (weight : " + e.weight + ")");
        }
    }

    // PRINT NEIGHBOURS   // T.C = O(E)
    public static void printNeighbours(ArrayList<Edge> edges, int node){
        System.out.println("\nNeighbours of node "+ node + " are : ");
        for(Edge e : edges){
            if(e.src == node){
                System.out.println(e.dest + " - weight : " + e.weight);
            }
        }
    }

    public static void main(String args[]){
        int V = 4;
        ArrayList<Edge> edges = new ArrayList<>();
        createEdgeList(edges);
        printEdgeList(edges);
        printNeighbours(edges, 2);
    }
}
