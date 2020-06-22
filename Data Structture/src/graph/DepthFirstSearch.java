package graph;
import edu.princeton.cs.algs4.*;
public class DepthFirstSearch {
        private boolean[] marked;
        private int count;
        private int[] pathTo;
        private final int s;
        public DepthFirstSearch(graph G, int s) {
            marked = new boolean[G.V()];
            pathTo = new int[G.V()];
            this.s = s;
            dfs(G, s);

        }
        public void dfs(graph G, int s) {
            marked[s] = true;
            count++;
            for(int v : G.adj(s)) {
                if(!marked[v]) {
                    pathTo[v] = s;
                    dfs(G, v);
                }
            }

        }
        public static void main(String[] args) {
            graph G = new graph(new In(args[0]));
            int s = Integer.parseInt(args[1]);
            DepthFirstSearch search = new DepthFirstSearch(G, s);
        }

       public boolean marked(int w) {
            return marked[w];
       }

       public boolean hasPathto (int w) {
            return marked[w];
       }

       public void egdeTo(int w) {
            if (!hasPathto(w)) {
                return;
            }
            Stack<Integer> path = new Stack<>();
            for (int t = w; t != this.s; t = pathTo[t]) {
                path.push(t);
            }
            path.push(s);
            for (int q : path) {
                if (q == s) {
                    System.out.print(q);
                } else {
                    System.out.print("-" + q);
                }

            }
       }
       public int count() {
            return count;
       }
}
