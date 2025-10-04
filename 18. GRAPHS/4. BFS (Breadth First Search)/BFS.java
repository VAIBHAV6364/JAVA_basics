// Time Complexity : O(V+E)
// Space Complexity :

import java.util.*;
public class BFS {
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


    // *** BFS ***
    public static void bfs(ArrayList<Edge> graph[], int V, int startingPointNode){
        System.out.println();
        System.out.println("BFS TRAVERSAL : \n");
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[V];
        q.add(startingPointNode);

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

        bfs(graph, V, 0);
    }
}
