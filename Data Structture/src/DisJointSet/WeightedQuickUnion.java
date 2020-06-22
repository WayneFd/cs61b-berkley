package DisJointSet;

public class WeightedQuickUnion implements DisJointSet {
    public int[] ds;
    public WeightedQuickUnion(int p) {
        ds = new int[p];
        for (int i = 0; i < p; i++) {
            ds[i] = -1;
        }
    }
    private int find(int p) {
        while (ds[p] >= 0) {
            ds[p] = find(ds[p]);
            p = ds[p];
        }
        return p;
    }
    private void link(int p, int q) {
        int size = ds[p] + ds[q];
        if (ds[p] < ds[q]) {
           ds[q] = p;
           ds[p] = size;
        } else {
            ds[p] = q;
            ds[q] = size;
        }
    }
    public void connect(int p, int q) {
        int pid = find(p);
        int qid = find(q);
        link(pid,qid);

    }
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public static void main(String[] args) {
        WeightedQuickUnion items = new WeightedQuickUnion(16);
        items.connect(15, 11);
        items.connect(11, 5);
        items.connect(5, 1);
        items.connect(1, 0);
        items.connect(12, 5);
        items.connect(1, 6);
        items.connect(7, 1);
        for (int i : items.ds) {
            System.out.println(i);
        }

    }
}

