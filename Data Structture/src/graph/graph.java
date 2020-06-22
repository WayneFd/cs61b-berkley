package graph;
import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.In;

import java.util.ArrayList;

public class graph {
    private final int V;
    private int E;
    private ArrayList<Integer>[] adj;
    public graph(int V) {
        this.V = V;
        this.E = 0;
        adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<Integer>();
        }
    }

    public void addEgde(int V, int T) {
        adj[V].add(T);
        adj[T].add(V);
        E++;
    }

    public int V() {
        return this.V;
    }

    public int E() {
        return this.E;
    }

    public graph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int T = in.readInt();
            int V = in.readInt();
            addEgde(T, V);
        }
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }


}
