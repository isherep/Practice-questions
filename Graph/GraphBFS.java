import java.util.Iterator;
import java.util.LinkedList;

/**
 * Visualization https://www.cs.usfca.edu/~galles/visualization/BFS.html
 *
 * Time - Linear (V + E)
 *
 *
 * put the source node in the queue
 *
 * while(!q.isEmty()){
 *     Int current = que.deque();
 *
 *     // process current element in the hash table as visited
 *     visited[current] = true;
 *     // process adjacent
 *
 *     for(each a: current.listOfAnjacent){
 *          if(a is not visited)
 *
 *          // mark a as visited
 *          // add to a queua
 *         q.enque(a);
 *        // mark
 *     }
 *
 *
 * }
 *
 *
 * DFS
 *
 *
 *    // mark the source as visited
 *
 *    for(each a: current.listOfAdjacent )  for(Integer a: adj[v])  - adj[v] is a linked list
 *                                          Can be replaced by iterator
 *                                            while(it.hasNext)
 *
     *    if(a is not visited){
     *          isvisited[a] = true;
     *          dfs(adj(a))
     *   }
 *    // go down to source adjacent
 *
 *
 *
 *
 */

public class GraphBFS {
/*
    class Graph
    {
        private int V;   // No. of vertices
        private LinkedList<Integer> adj[]; //Adjacency Lists

        // Constructor
        Graph(int v)
        {
            V = v;
            adj = new LinkedList[v];
            for (int i=0; i<v; ++i)
                adj[i] = new LinkedList();
        }

        // Function to add an edge into the graph
        void addEdge(int v,int w)
        {
            adj[v].add(w);
        }

        // prints BFS traversal from a given source s
        void BFS(int s)
        {
            // Mark all the vertices as not visited(By default
            // set as false)
            // for primitive types we can keep track in the array if the vertex was visited
            boolean visited[] = new boolean[V];
            // Create a queue for BFS
            LinkedList<Integer> queue = new LinkedList<Integer>();
            // Mark the current node as visited and enqueue it
            visited[s]=true;
            queue.add(s);

            while (queue.size() != 0)
            {
                // Dequeue a vertex from queue and print it
                s = queue.poll();
                System.out.print(s+" ");

                // Get all adjacent vertices of the dequeued vertex s
                // If a adjacent has not been visited, then mark it
                // visited and enqueue it
                Iterator<Integer> i = adj[s].listIterator();
                while (i.hasNext())
                {
                    int n = i.next();
                    if (!visited[n])
                    {
                        visited[n] = true;
                        queue.add(n);
                    }
                }
            }


        }
        }
        */
/*
        // Driver method to
        public static void main(String args[])
        {
            Graph g = new Graph(4);

            g.addEdge(0, 1);
            g.addEdge(0, 2);
            g.addEdge(1, 2);
            g.addEdge(2, 0);
            g.addEdge(2, 3);
            g.addEdge(3, 3);

            System.out.println("Following is Breadth First Traversal "+
                    "(starting from vertex 2)");

            g.BFS(2);
        }
    }
// This code is contributed by Aakash Hasija

   // Output:
   // Following is Breadth First Traversal (starting from vertex 2)
//2 0 3 1*/
}

