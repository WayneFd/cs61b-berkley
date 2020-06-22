package DisJointSet;

public class QuickUnion implements DisJointSet {
    private int[] ds;
    public QuickUnion(int p) {
        ds = new int[p];
        for (int i = 0; i < p; i++) {
            ds[i] = -1;
        }
    }

    private int find (int p) {
        while (ds[p] != -1) {
            p = ds[p];
        }
        return p;
    }
    public void connect(int p, int q) {
       int qid = find(q);
       int pid = find(p);
       ds[qid] =pid;
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}
