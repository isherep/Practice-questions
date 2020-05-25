import java.util.List;

/**
 * Depth-first-search
 *
 * Marks each seen vertex with the boolean marked.
 *
 * If the graph is connected,
 * every adjacency-list entry is checked
 *
 * Time - DFS marks all the vertices connected to a
 * given source in time proportional to the sum of their degrees.
 *
 * v1 + (incident edges) + v2 + (incident edges) + .... + vn + (incident edges)
 *
 * Time - O(V) + O(E) = O(V + E).
 * Space - O(V)
 */

public class GDepthFirstSearch {
    private Graph G;
    private boolean[] marked;
    private int count;
    private int[] edgeTo;
    /**
     *
     * @param G
     * @param s - vertex s we are checking if present
     */
    public GDepthFirstSearch(Graph G, int s){
        this.G = G;
        // create new array to mark each vertex if seen
        marked = new boolean[G.V()];
        // initialize edges to empty
        edgeTo = new int[G.V()];

    }
    public boolean marked(int v){
        return marked[v];

        //return adj[v] == marked;
    }
    private void dfs(Graph G, int v){
        // iterate through graph vertices
        // if not found element - mark them true;
        marked[v] = true;
        count ++;

        // look for the list of adjacent vertexes

        for(int w: G.adj(v)){
            // if adjacent verti was not seen yet
            if(!marked[w]){
                // mark it as an adge vertex
                edgeTo[w] = v;
                // continue down his nodes
                dfs(G,w);
            }
        }
    }
    public int count(){
        return count;
    }

    public boolean hasPathTo(int v){
        return true;

    }

    //public List<Integer> pathTo(int v){

    //}
}
