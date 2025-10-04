import java.util.*;

public class TopologicalSorting {
    static class Edge{
        int src;
        int dest;

        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    /*

            ( 5 )
           ^    ^
          /      \
        ( 3 )   ( 4 )
          ^       ^
          \      /
           \    /
            ( 2 )
              ^
              |
            ( 1 )
     */

    public static void createGraph(ArrayList<Edge> graph[]) {
        // Creating new ArrayList of Edge type in each index
        for(int i=0; i < graph.length; i++)
            graph[i] = new ArrayList<Edge>();

        graph[1].add(new Edge(1,2));
        graph[2].add(new Edge(2,3));
        graph[2].add(new Edge(2,4));
        graph[3].add(new Edge(3,5));
        graph[4].add(new Edge(4,5));
    }


    // TOPOLOGICAL SORTING
    public static void topSorting(ArrayList<Edge> graph[], boolean vis[], int curr, Stack<Integer> stack){
        vis[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);

            // if next node not visited traverse and add to stack
            if(!vis[e.dest]) {
                topSorting(graph, vis, e.dest, stack);
            }
        }
        stack.push(curr);
    }

    // Running TopSort through the number of nodes and printing the TopOrder from stack
    public static void topSort(ArrayList<Edge> graph[], int V){
        boolean vis[] = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        // 🔑 Detect smallest valid index (skip unused 0 if needed)
        int start = -1;
        for (int i = 0; i < V; i++) {
            if (!graph[i].isEmpty()) {
                start = i;
                break;
            }
        }
        if (start == -1) {
            System.out.println("Graph is empty!");
            return;
        }

        // Run DFS from all unvisited nodes (covers disconnected graphs too)
        for (int i = start; i < V; i++) {
            if (!vis[i]) {
                topSorting(graph, vis, i, stack);
            }
        }

        System.out.println("Topologically Sorted order : ");
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }


    public static void main(String args[]){
        int V = 6;    // since

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        topSort(graph, V);
    }
}
