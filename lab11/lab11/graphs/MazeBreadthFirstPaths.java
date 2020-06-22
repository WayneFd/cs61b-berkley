package lab11.graphs;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 *  @author Josh Hug
 */
public class MazeBreadthFirstPaths extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */
    private int s;
    private int t;
    private boolean targetFound = false;
    private Maze maze;


    public MazeBreadthFirstPaths(Maze m, int sourceX, int sourceY, int targetX, int targetY) {
        super(m);
        maze = m;
        s = maze.xyTo1D(sourceX, sourceY);
        t = maze.xyTo1D(targetX, targetY);
        distTo[s] = 0;
        edgeTo[s] = s;
    }


    /** Conducts a breadth first search of the maze starting at the source. */
    private void bfs(int v) {
        // TODO: Your code here. Don't forget to update distTo, edgeTo, and marked, as well as call announce()
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        marked[v] = true;
        queue.add(v);
        announce();
        while(!queue.isEmpty()) {
            int p = queue.poll();
            if (p == t) {
                targetFound = true;
            }
            if (targetFound) {
                return;
            }
            for (int w : maze.adj(p)) {
                if (!marked[w]) {
                    edgeTo[w] = p;
                    marked[w] = true;
                    announce();
                    distTo[w] = distTo[p] + 1;
                    queue.add(w);
                }
            }
        }
    }


    @Override
    public void solve() {
        bfs(s);
    }
}

