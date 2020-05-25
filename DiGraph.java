import java.util.LinkedList;

/**
 * Undirected Graph represented by adjacency array
 *
 * Where we
 * maintain a vertex-indexed array of lists
 * of the vertices adjacent to each vertex.
 *
 */

public class DiGraph {
    // array of linked lists
    // array of vertices
    private final int V;
    // array of linked lists representing adjacent adges
    private LinkedList<Integer>[] adj;

    boolean marked[] = new boolean[this.V()];
    // constructs empty DiGraph with capasity V
    public DiGraph(int V){
        this.V = V;
        // initialize the array of linked lists
        this.adj = (LinkedList<Integer>[]) new LinkedList[V];
        // initialize the linedlists
        for(int i = 0; i< V; i++){
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w){
        // find the v adge and add w vertix to it
        adj[v].add(w);

    }
    // returns number of Vertices
    public  int V(){
        return this.adj.length;

    }
    // marks vertices reachabel from s
    public void DFS(DiGraph G, int s){
        dfs(G, s);
    }
    // go to the vertex v in the graph marking seen as marked
    private void dfs(DiGraph G, int v){
        // marks vertice as true
        marked[v] = true;
        // now go through its adjacent vertices
        // perform marking on all the ajacent vertices
        for(int w: G.adj[v]){
            if(!marked[w]){
                dfs(G,w);
            }
        }

    }

    // finaly returns if the given vertix is reachable from s
    // if it is reachable - it will be marked true
    public boolean visited(int j){
        return marked[j];
    }




    public static void main(String[] args){

        DiGraph G = new DiGraph(7);


        // printEdgeOnce
            for(int v = 0; v < G.V(); v++){
                for (int w: G.adj[v]){
                    System.out.print(v + " --> : " + w);
                }
            }

    }




}
