package graph;
import edu.princeton.cs.algs4.*;
import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class digraph {
    private ArrayList<Integer>[] adj;
    private int V;
    private int E;
    public digraph(int V) {
        this.V = V;
        this.E = 0;
        adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
    }
    public digraph(In in) {
        this(in.readInt());
        int e = in.readInt();
        for (int w = 0; w < e; w++) {
            int q = in.readInt();
            int t = in.readInt();
            addEdge(q,t);
        }

    }

    public void addEdge(int w, int t) {
        adj[w].add(t);
        E++;
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public Iterable<Integer> adj(int w) {
        return adj[w];
    }

    public digraph reverse() {
        digraph rev = new digraph(V);
        for (int i = 0; i < V; i++) {
            for (int w : adj(i)) {
                rev.addEdge(w, i);
            }
        }
        return rev;
    }

}
