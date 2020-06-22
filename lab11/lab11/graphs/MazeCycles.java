package lab11.graphs;

import java.util.Stack;

/**
 *  @author Josh Hug
 */
public class MazeCycles extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */
   // private boolean[] onstack;
    private int[] parent;
    private boolean hascycle;
    public MazeCycles(Maze m) {
        super(m);
        parent = new int[m.V()];
        distTo[0] = 0;
        edgeTo[0] = 0;

    }

    @Override
    public void solve() {
        for (int i = 0; i < maze.V(); i++) {
            if (!marked[i]) {
                dfs(i, i);
            }
        }
    }

    // Helper methods go here
    private void dfs(int v, int p) {
        marked[v] = true;
        announce();
        for (int w : maze.adj(v)) {
            if (hascycle()) {
                return;
            } else if (!marked[w]) {
                parent[w] = v;
                distTo[w] = distTo[v] + 1;
                dfs(w, v);
            } else if ( w != p) {
                hascycle = true;
                for (int j = v; j != w; j = parent[j]) {
                    edgeTo[j] = parent[j];
                }
                edgeTo[w] = v;
                announce();
            }
        }
    }

    private boolean hascycle() {
        return hascycle;
    }

}

