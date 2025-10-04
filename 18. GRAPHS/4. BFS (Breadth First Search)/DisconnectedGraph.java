import java.util.*;
public class DisconnectedGraph {
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


    // *** BFS ***
    // ( 0 )--( 1 )--( 2 )
    //     ( 3 )--( 4 )
    public static void bfsDisconnected(ArrayList<Edge> graph[], int V, boolean visited[], int start){
        System.out.println();
        System.out.println("BFS TRAVERSAL : ");
        Queue<Integer> q = new LinkedList<>();

        q.add(start);

        while(!q.isEmpty()){
            int curr = q.remove();
            // check if already visited node
            if(visited[curr] == false) {
                System.out.print(curr + " ");
                visited[curr] = true;

                // add neighbours
                for(int i = 0; i < graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }


    public static void main(String args[]){
        int V = 5;

        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);

        boolean visited[] = new boolean[V];
        for(int i = 0; i < V; i++){
            if(visited[i] == false){

            }
        }
    }
}
