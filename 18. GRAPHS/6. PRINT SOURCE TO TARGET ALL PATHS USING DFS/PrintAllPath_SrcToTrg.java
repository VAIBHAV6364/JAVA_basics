import java.util.*;
public class PrintAllPath_SrcToTrg {
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


/*

Call

We run:
    printAllPaths(graph, visited, 0, "0", 5);


That means:
    start = 0
    target = 5

Tracing the Recursion

I’ll represent the recursion stack like this:

Function(curr, path, visited[])

Step 1: Start
printAllPaths(0, "0")
mark 0 visited
neighbors = {1,2}

Step 2: Go to 1
printAllPaths(1, "0 -> 1")
mark 1 visited
neighbors = {0,3}
0 already visited → skip

go to 3
Step 3: Go to 3
printAllPaths(3, "0 -> 1 -> 3")
mark 3 visited
neighbors = {1,4,5}

1 already visited → skip
go to 4
Step 4: Go to 4
printAllPaths(4, "0 -> 1 -> 3 -> 4")
mark 4 visited
neighbors = {2,3,5}

2 not visited → go
Step 5: Go to 2
printAllPaths(2, "0 -> 1 -> 3 -> 4 -> 2")
mark 2 visited
neighbors = {0,4}
both visited → backtrack

Backtrack → unmark 2
Step 6: Back at 4
Next neighbor = 5
printAllPaths(5, "0 -> 1 -> 3 -> 4 -> 5")
curr == tar (5) → print path

✅ Output:
0 -> 1 -> 3 -> 4 -> 5
Backtrack → unmark 5, then unmark 4
Step 7: Back at 3
Next neighbor = 5
printAllPaths(5, "0 -> 1 -> 3 -> 5")
curr == tar (5) → print path

✅ Output:
0 -> 1 -> 3 -> 5
Backtrack → unmark 5, unmark 3, unmark 1
Step 8: Back at 0
Next neighbor = 2
printAllPaths(2, "0 -> 2")

mark 2 visited
neighbors = {0,4}
0 visited → skip

go to 4
Step 9: Go to 4
printAllPaths(4, "0 -> 2 -> 4")

mark 4 visited
neighbors = {2,3,5}
2 visited → skip

go to 3
Step 10: Go to 3
printAllPaths(3, "0 -> 2 -> 4 -> 3")
mark 3 visited

neighbors = {1,4,5}
go to 1
Step 11: Go to 1
printAllPaths(1, "0 -> 2 -> 4 -> 3 -> 1")

mark 1 visited
neighbors = {0,3}
both visited → backtrack
Backtrack → unmark 1
Step 12: Back at 3
Next neighbor = 5
printAllPaths(5, "0 -> 2 -> 4 -> 3 -> 5")


curr == tar (5) → print path
✅ Output:
0 -> 2 -> 4 -> 3 -> 5


Backtrack → unmark 5, unmark 3
Step 13: Back at 4
Next neighbor = 5
printAllPaths(5, "0 -> 2 -> 4 -> 5")
curr == tar (5) → print path

✅ Output:
0 -> 2 -> 4 -> 5


Backtrack → unmark 5, unmark 4, unmark 2
Final Output (All Paths from 0 → 5)
0 -> 1 -> 3 -> 4 -> 5
0 -> 1 -> 3 -> 5
0 -> 2 -> 4 -> 3 -> 5
0 -> 2 -> 4 -> 5

Recursion Stack Example (for path 0 → 1 → 3 → 4 → 5)

At its deepest point:

printAllPaths(0, "0")
    printAllPaths(1, "0 -> 1")
        printAllPaths(3, "0 -> 1 -> 3")
            printAllPaths(4, "0 -> 1 -> 3 -> 4")
                printAllPaths(5, "0 -> 1 -> 3 -> 4 -> 5")  <-- target reached


Then it backtracks step by step, unmarking visited nodes.

 */