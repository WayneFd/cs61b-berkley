package tree;

import edu.princeton.cs.algs4.In;

import java.lang.reflect.Array;
import java.util.*;

public class solution {

    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }
    }
    public static class TreeNode {
          int val;
          TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }
    public static Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> p = new LinkedList<>();
        p.offer(root);
        while(!p.isEmpty()){
            int size = p.size();
            Node pre = null;
            for (int k = 0; k < size; k++) {
                Node curr = p.poll();
                if (curr.left != null);
                p.offer(curr.left);
                if (curr.right != null);
                p.offer(curr.right);
                if (pre == null) {
                    pre = curr;
                } else {
                    pre.next = curr;
                    pre = curr;
                }
            }
        }
        return root;

    }

        public static int[] exclusiveTime(int n, List<String> logs) {
            int sum = 0;
            int[] ans = new int[n];
            for(int i = 0; i < ans.length;i++) {
                ans[i] = 0;
            }
            int count;
            Stack<String> helper = new Stack<>();
            helper.push(logs.get(0));
            String[] prev = logs.get(0).split(":");
            for (int i = 1; i < logs.size(); i++) {
                String[] temp = logs.get(i).split(":");
                if (temp[0].equals(prev[0])) {
                    helper.pop();
                    int index = Integer.parseInt(temp[0]);
                    count = Integer.parseInt(temp[2]) -Integer.parseInt(prev[2]) + 1;
                    ans[index] = count;
                }
                else {
                    String[] last = helper.peek().split(":");
                    int index = Integer.parseInt(prev[0]);
                    if ((temp[1].equals("start") && prev[1].equals("start")) || (temp[1].equals("end") && prev[1].equals("end"))){
                        ans[index] +=  Integer.parseInt(temp[2]) -Integer.parseInt(prev[2]);
                    } else {
                        ans[index] +=  Integer.parseInt(temp[2]) -Integer.parseInt(prev[2]) - 1;
                    }
                    helper.push(logs.get(i));
                }
            }
            return ans;
        }
    public static void main(String[] args) {
      int n = 2;
      List<String> logs = new ArrayList<>();
      logs.add("0:start:0");
        logs.add("1:start:2");
        logs.add("1:end:5");
        logs.add("0:end:6");
        int[] ans;
        String[] k = logs.get(0).split(":");
    }

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> ans = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < stones.length; i++) {
            ans.add(stones[i]);
        }
        while(ans.size() >= 1) {
            int a = ans.poll();
            int b = ans.poll();
            if ((a-b) > 0) {
                ans.add(a-b);
            }
        }
        return ans.size() == 1 ? ans.poll() : 0;
    }
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            helper(candidates, ans,new ArrayList<Integer>(), 0, candidates.length, target);
            return ans;

        }
        private void helper(int[] candi,List<List<Integer>> ans, List<Integer> level, int n, int length, int target) {
            if (target < 0 || n >= length) {
                return;
            }
            if (target == 0) {
                ans.add(new ArrayList<>(level));
                return;
            }
            for (int i = n; i < length; i++) {
                level.add(candi[i]);
                helper(candi,ans,level, i+1,length, target - candi[i]);
                level.remove(level.size() - 1);
            }

        }
    }



