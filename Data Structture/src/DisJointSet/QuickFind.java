package DisJointSet;

public class QuickFind implements DisJointSet {
    private int[] ds;
    // initialize the ds Array
    public QuickFind(int p){
        ds = new int[p];
        for (int i = 0; i < p; i++) {
            ds[i] = i;
        }
    }

    //Connect two item;
    public void connect(int p, int q) {
        int pid = ds[p];
        int qid = ds[q];
        for (int i = 0; i < ds.length; i++) {
            if (ds[i] == pid) {
                ds[i] = qid;
            }
        }
    }

    // return true if the two item are connected
    public boolean isConnected(int p, int q) {
        return ds[p] == ds[q];
    }

}
