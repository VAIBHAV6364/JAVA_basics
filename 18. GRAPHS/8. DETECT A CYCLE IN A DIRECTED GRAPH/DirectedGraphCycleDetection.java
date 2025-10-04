import java.util.ArrayList;
public class DirectedGraphCycleDetection {
    static class Edge{
        int src;
        int dest;

        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    /*

            ( 1 )--->( 0 )<---( 2 )
                       ^       ^
                       \      /
                        \    /
                        ( 3 )

     */

    public static void createGraph(ArrayList<Edge> graph[]) {
        // Creating new ArrayList of Edge type in each index
        for(int i=0; i < graph.length; i++)
            graph[i] = new ArrayList<Edge>();

        /*
        graph[1].add(new Edge(1,0));
        graph[2].add(new Edge(2,0));
        graph[3].add(new Edge(3,0));
        graph[3].add(new Edge(3,2));
        */


        graph[0].add(new Edge(0,1));
        graph[1].add(new Edge(1,2));
        graph[2].add(new Edge(2,3));
        graph[3].add(new Edge(3,0));

    }


    // DETECT A CYCLE IN A DIRECTED GRAPH
    public static boolean detectCycleDirGraph_Processor(ArrayList<Edge> graph[], boolean vis[], int curr, boolean recursionStack[]) {
        vis[curr] = true;
        recursionStack[curr] = true;    // explicit recursion stack

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            // if cycle exists then next node [visited also] present in [recursionStack also]
            if (!vis[e.dest]) {       //  if next node not visited move there
                if (detectCycleDirGraph_Processor(graph, vis, e.dest, recursionStack)) {
                    return true;
                }
            }
            // e.dest exists already in recursion stack
            else if (recursionStack[e.dest]) {  // back edge → cycle
                return true;
            }
        }

        // on backtracking remove from recursion stack
        recursionStack[curr] = false;
        return false;
    }

    // helper for Dis connected components
    public static void hasCycle(ArrayList<Edge> graph[], int V){
        boolean visited[] = new boolean[V];
        System.out.println("DOES THE CYCLE EXISTS IN THE GRAPH : ");

        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                boolean hasCycle = detectCycleDirGraph_Processor(graph, visited, i, new boolean[V]);
                    System.out.println("Cycle present? " + (hasCycle ? "YES" : "NO"));
                }
            }
    }


    public static void main(String args[]){
        int V = 4;

        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);
        hasCycle(graph, V);
    }
}
