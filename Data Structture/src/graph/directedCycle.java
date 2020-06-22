package graph;

import java.util.Stack;

public class directedCycle {
    private boolean[] marked;
    private int[] egdeTo;
    private Stack<Integer> cycle;
    private boolean[] onStack;

    public directedCycle(digraph G) {
        marked = new boolean[G.V()];
        egdeTo = new int[G.V()];
        onStack = new boolean[G.V()];

        for (int w = 0; w < G.V(); w++) {
            dfs(G, w);
        }
    }
    private void dfs(digraph G, int w) {
        onStack[w] = true;
        marked[w] = true;
        for (int t : G.adj(w)) {
            if (hascycle()) {
                return;
            } else if (!marked[t]) {
                egdeTo[t] = w;
                dfs(G, t);
            } else if (onStack[t]) {
                cycle = new Stack<Integer>();
                for(int q = w; q != t; q = egdeTo[q]) {
                    cycle.push(q);
                }
                cycle.push(t);
                cycle.push(w);
            }
        }
        onStack[w] = false;
    }
    public  boolean hascycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }
}
