package hw4.puzzle;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;

import java.util.HashMap;
import java.util.Map;

public class Solver {
    HashMap<WorldState, Integer> edmap;
    private Stack<WorldState> history;
    private class SearchNode implements Comparable<SearchNode> {
        private WorldState world;
        private int move;
        private SearchNode prev;
        private int priority;
        private SearchNode(WorldState s, SearchNode p) {
            world = s;
            move = prev == null ? 0 : prev.move + 1;
            prev = p;
            if (edmap.containsKey(s)) {
                priority = move + edmap.get(s);
            } else {
                int dis = s.estimatedDistanceToGoal();
                edmap.put(s, dis);
                priority = dis + move;
            }
        }
        public int compareTo(SearchNode o) {
            return this.priority - o.priority;
        }
        public WorldState world() {
            return world;
        }

        public SearchNode prev() {
            return prev;
        }

        public int move() {
            return move;
        }
    }

    public Solver(WorldState initial) {
        history =new Stack<>();
        edmap = new HashMap<>();
        MinPQ<SearchNode> helper = new MinPQ<>();
        SearchNode curr = new SearchNode(initial, null);
        while (!curr.world.isGoal()) {
            for (WorldState next : curr.world.neighbors()){
                if(curr.prev() == null || !next.equals(curr.prev.world)) {
                    SearchNode nextNode = new SearchNode(next, curr);
                    helper.insert(nextNode);
                }
            }
            curr = helper.delMin();
        }
        while( curr != null) {
            history.push(curr.world());
            curr = curr.prev();
            Map<Integer,Integer> ans = new HashMap<>();
            ans.gee
        }

    }
    public int moves(){return history.size() - 1;};
    public Iterable<WorldState> solution() {
        return history;
    };
}
