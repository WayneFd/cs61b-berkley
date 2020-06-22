package graph;
import edu.princeton.cs.algs4.*;
public class Search {
    public static void main(String[] args) {
        graph G = new graph(new In(args[0]));
        int s = Integer.parseInt(args[1]);
        DepthFirstSearch search = new DepthFirstSearch(G, s);
        for (int i = 0; i < G.V(); i++) {
            if(search.marked(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println("are connected with " + s);
        search.egdeTo(6);
    }
}
