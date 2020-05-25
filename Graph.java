import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Undirected Graph represented by adjacency array
 *
 * Where we
 * maintain a vertex-indexed array of lists
 * of the vertices adjacent to each vertex.
 *
 */
public class Graph {
 //create a V-vertex graph with no edges

    private int V;// number of vertices
    private int E; // number of edges
    private LinkedList[] adj; // adjasency array of adjacent elements
    /*
  * Constructor
  */
  public Graph(int V){
    this.V = V;
    this.E = 0;
    // create list and initialize to empty, like int[]
    adj = new LinkedList[V];
    // intialize linked lists to empty per each array element
      for(int i = 0; i < adj.length; i++ ){
          adj[i] = new LinkedList();
      }
  }
    // number of vertices
    public int V() {
      return this.V;
    }
    // number of edges
    public int E(){
        return this.E;
    }
    // add edge v-w to this graph, vertices are present just need to ad connection
    // that means make them adjacent to each otehr
   public void addEdge(int v, int w) {
      // add v to the array if not present
        // if present v to add adge - add w to the linked list
        // add w to the linked list element
        // add as adjacent to vertex v
        adj[v].add(w);
        // add as adjacent to vertex w
        adj[w].add(v);
        // increment number of edges
        E++;
    }
        // vertices adjacent to v
    public List<Integer> adj(int v) {
      // return the linked list of adjacent cells that belongs to v
      return adj[v];
    }
}
