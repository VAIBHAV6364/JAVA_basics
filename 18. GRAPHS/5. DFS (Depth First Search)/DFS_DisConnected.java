import java.util.*;
public class DFS_DisConnected {
    static class Edge{
        int src;
        int dest;

        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        // Creating new ArrayList of Edge type in each index
        for(int i=0; i < graph.length; i++)
            graph[i] = new ArrayList<Edge>();

        graph[0].add(new Edge(0,1));
        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));
        graph[3].add(new Edge(3,4));
        graph[4].add(new Edge(4,3));
    }


    // ( 0 )--( 1 )--( 2 )
    //     ( 3 )--( 4 )
    // *** DFS ***
    public static void DFS(ArrayList<Edge> graph[], int curr, boolean visited[]) {
        if(visited[curr] == true)
            return;

        System.out.print(curr + " ");
        visited[curr] = true;
        for(int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            DFS(graph, e.dest, visited);
        }
    }


    public static void main(String args[]){
        int V = 5;

        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);

        boolean visited[] = new boolean[V];
        System.out.println("\n DFS TRAVERSAL : ");
        for(int i = 0; i < V; i++){
            if(visited[i] == false){
                DFS(graph, i, visited);
                System.out.println();
            }
        }
    }
}
