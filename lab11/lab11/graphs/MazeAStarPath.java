package lab11.graphs;

import edu.princeton.cs.algs4.IndexMinPQ;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *  @author Josh Hug
 */
public class MazeAStarPath extends MazeExplorer {
    private int s;
    private int t;
    private boolean targetFound = false;
    private Maze maze;
    private IndexMinPQ<Integer> pq;

    public MazeAStarPath(Maze m, int sourceX, int sourceY, int targetX, int targetY) {
        super(m);
        maze = m;
        s = maze.xyTo1D(sourceX, sourceY);
        t = maze.xyTo1D(targetX, targetY);
        distTo[s] = 0;
        edgeTo[s] = s;
    }

    /** Estimate of the distance from v to the target. */
    private int h(int v) {
        return Math.abs(maze.toX(v) - maze.toX(t)) + Math.abs(maze.toY(v) - maze.toY(t));
    }

    /** Finds vertex estimated to be closest to target. */
    private int findMinimumUnmarked() {
        return -1;
        /* You do not have to use this method. */
    }

//    private class star {
//        public star(int s, int dis) {
//            this.s = s;
//            this.dis = dis;
//        }
//        int s;
//        int dis;
//    }
//
//
//    static Comparator<star> cNode = new Comparator<star>() {
//        @Override
//        public int compare(star o1, star o2) {
//            return o1.dis - o2.dis;
//        }
//    };

    /** Performs an A star search from vertex s. */
    private void astar(int s) {
        pq = new IndexMinPQ<>(maze.V());
        for (int v = 0; v < maze.V(); v++) {
            distTo[v] = Integer.MAX_VALUE;
        }
        distTo[s] = 0;
        pq.insert(s, distTo[s] + h(s));

        while(!pq.isEmpty()) {
            relax(pq.delMin());
        }
    }
    private void relax(int k) {
        for (int w : maze.adj(k)) {
            announce();
            if (distTo[w] > distTo[k] + 1) {
                distTo[w] = distTo[k] + 1;
                edgeTo[w] = k;
                if (pq.contains(w)) {
                    pq.changeKey(w, distTo[w] + h(w));
                } else {
                    pq.insert(w, distTo[w] + h(w));
                }
            }
        }
    }
    private void pathto(int v) {
        for (int w = v; w != s; w = edgeTo[w]) {
            marked[w] = true;
        }
        marked[s] = true;
        announce();
    }
    @Override
    public void solve() {
        astar(s);
        pathto(t);
    }

}

