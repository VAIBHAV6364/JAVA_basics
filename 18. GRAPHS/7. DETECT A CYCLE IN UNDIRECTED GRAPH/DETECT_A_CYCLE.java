import java.util.ArrayList;
public class DETECT_A_CYCLE {
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


    // Detect cycle using DFS
    public static boolean detectCycleProcesser(ArrayList<Edge>[] graph, boolean[] visited, int curr, int parent) {
        visited[curr] = true;

        for (Edge e : graph[curr]) {
            if (!visited[e.dest]) {
                if (detectCycleProcesser(graph, visited, e.dest, curr)) {
                    return true;
                }
            }
            else if (e.dest != parent) {
                return true; // back edge → cycle
            }
        }
        return false;
    }

    // helper for Dis connected components
    public static void detectCycle(ArrayList<Edge> graph[], boolean visited[], int V){
        boolean hasCycle = false;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (detectCycleProcesser(graph, visited, i, -1)) {
                    hasCycle = true;
                    break;
                }
            }
        }

        System.out.println("Cycle present? " + (hasCycle ? "YES" : "NO"));
    }


    public static void main(String args[]){
        int V = 7;

        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);

        boolean visited[] = new boolean[V];
        System.out.println("DOES THE CYCLE EXISTS IN THE GRAPH : ");

        detectCycle(graph, visited, V);
    }

}
